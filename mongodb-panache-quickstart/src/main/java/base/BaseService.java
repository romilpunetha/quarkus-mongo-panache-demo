package base;

import io.smallrye.mutiny.Uni;
import user.UserEntity;

import java.util.concurrent.ExecutionException;

public interface BaseService<T extends BaseEntity<ID>, ID> {

    Uni<UserEntity> create(UserEntity user);

    Uni<T> get(String id);

}
