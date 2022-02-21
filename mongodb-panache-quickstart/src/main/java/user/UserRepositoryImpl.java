package user;

import baseMongo.BaseMongoRepositoryImpl;
import com.mongodb.reactivestreams.client.ClientSession;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.enterprise.context.ApplicationScoped;

@FieldDefaults(level = AccessLevel.PRIVATE)
@ApplicationScoped
public class UserRepositoryImpl
        extends BaseMongoRepositoryImpl<UserEntity>
        implements UserRepository {

    public Uni<UserEntity> create(UserEntity t, ClientSession clientSession) {

        return this.mongoCollection().insertOne(clientSession, t)
                        .map(insertOneResult -> {
                            if (insertOneResult.getInsertedId() != null)
                                t.setId(insertOneResult.getInsertedId().asObjectId().getValue());
                            return t;
                        });
    }
}
