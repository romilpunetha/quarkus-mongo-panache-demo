package baseMongo;

import base.BaseServiceImpl;
import io.quarkus.arc.properties.IfBuildProperty;
import io.smallrye.mutiny.Uni;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;


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

    public Uni<T> get(String id) {
        return repository.get(new ObjectId(id));
    }
}
