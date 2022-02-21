package user;

import baseMongo.BaseMongoRepository;
import com.mongodb.reactivestreams.client.ClientSession;
import io.smallrye.mutiny.Uni;

public interface UserRepository extends BaseMongoRepository<UserEntity> {

    Uni<UserEntity> create(UserEntity t, ClientSession clientSession);
}
