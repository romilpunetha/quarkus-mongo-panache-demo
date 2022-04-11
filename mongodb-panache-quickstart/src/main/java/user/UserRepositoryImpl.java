package user;

import baseMongo.BaseMongoRepositoryImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.enterprise.context.ApplicationScoped;

@FieldDefaults(level = AccessLevel.PRIVATE)
@ApplicationScoped
public class UserRepositoryImpl
        extends BaseMongoRepositoryImpl<UserEntity>
        implements UserRepository {

}
