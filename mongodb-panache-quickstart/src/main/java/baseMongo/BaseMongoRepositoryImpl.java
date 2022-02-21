package baseMongo;

import base.BaseRepositoryImpl;
import io.quarkus.mongodb.FindOptions;
import io.smallrye.mutiny.Uni;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.bson.BsonDocument;
import org.bson.BsonObjectId;
import org.bson.types.ObjectId;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseMongoRepositoryImpl<T extends BaseMongoEntity>
        extends BaseRepositoryImpl<T, ObjectId>
        implements BaseMongoRepository<T> {

    public Uni<T> create(T t) {
        return this.persist(t);
    }


    public Uni<T> get(ObjectId id) {

        BsonDocument filter = new BsonDocument()
                .append("_id", new BsonObjectId(id));

        FindOptions findOptions = new FindOptions().limit(1);

        return Uni.createFrom().multi(this.mongoCollection().find(filter, findOptions));

    }

}
