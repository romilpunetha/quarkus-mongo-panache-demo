package user;

import baseMongo.BaseMongoServiceImpl;
import com.mongodb.*;
import com.mongodb.reactivestreams.client.ClientSession;
import io.quarkus.logging.Log;
import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.runtime.Startup;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@FieldDefaults(level = AccessLevel.PRIVATE)
@ApplicationScoped
public class UserServiceImpl
        extends BaseMongoServiceImpl<UserEntity>
        implements UserService {

    final UserRepository repository;

    @Inject
    protected ReactiveMongoClient reactiveMongoClient;

    @Inject
    protected UserServiceImpl(UserRepository repository) {

        super(repository);

        this.repository = repository;

    }

    public Uni<UserEntity> create(UserEntity user) {

        return reactiveMongoClient.startSession()
                .chain(clientSession -> {
                        clientSession.startTransaction();
                        return repository.create(user)
                                .invoke(() -> Log.debug(clientSession.hasActiveTransaction()))
                                .call(() -> Uni.createFrom().publisher(clientSession.commitTransaction()))
                                .invoke(() -> Log.debug(clientSession.hasActiveTransaction()))
                                ;
                        });

    }
}