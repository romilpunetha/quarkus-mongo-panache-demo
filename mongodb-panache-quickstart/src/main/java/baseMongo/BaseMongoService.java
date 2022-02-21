package baseMongo;

import base.BaseService;
import io.quarkus.arc.properties.IfBuildProperty;
import org.bson.types.ObjectId;

@IfBuildProperty(name = "mongodb.enabled", stringValue = "true")
public interface BaseMongoService<T extends BaseMongoEntity>
        extends BaseService<T, ObjectId> {

}
