package user;

import baseMongo.BaseMongoServiceImpl;
import io.smallrye.mutiny.Uni;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@FieldDefaults(level = AccessLevel.PRIVATE)
@ApplicationScoped
public class UserServiceImpl
        extends BaseMongoServiceImpl<UserEntity>
        implements UserService {

    final UserRepository repository;

    @Inject
    protected UserServiceImpl(UserRepository repository) {

        super(repository);

        this.repository = repository;

    }

    public Uni<UserEntity> create(UserEntity user) {
        return repository.create(user);
    }
}