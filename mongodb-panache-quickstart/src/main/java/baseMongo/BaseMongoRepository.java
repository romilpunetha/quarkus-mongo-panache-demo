package baseMongo;

import base.BaseRepository;
import io.quarkus.arc.properties.IfBuildProperty;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import org.bson.types.ObjectId;


@IfBuildProperty(name = "mongodb.enabled", stringValue = "true")
public interface BaseMongoRepository<T extends BaseMongoEntity>
        extends ReactivePanacheMongoRepository<T>, BaseRepository<T, ObjectId> {
}
