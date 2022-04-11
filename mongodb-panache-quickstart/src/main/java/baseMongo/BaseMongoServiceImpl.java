package baseMongo;

import base.BaseServiceImpl;
import io.smallrye.mutiny.Multi;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;

import java.util.List;


@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseMongoServiceImpl<T extends BaseMongoEntity>
        extends BaseServiceImpl<T, ObjectId>
        implements BaseMongoService<T> {

    BaseMongoRepository<T> repository;

    public BaseMongoServiceImpl(BaseMongoRepository<T> repository) {
        super(repository);

        this.repository = repository;
    }

    public Multi<T> getByIds(List<String> ids) {
        return repository.getByIds(ids);
    }
}
