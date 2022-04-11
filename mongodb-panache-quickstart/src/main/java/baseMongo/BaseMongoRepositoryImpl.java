package baseMongo;

import base.BaseRepository;
import base.BaseRepositoryImpl;
import io.quarkus.mongodb.FindOptions;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseMongoRepositoryImpl<T extends BaseMongoEntity>
        extends BaseRepositoryImpl<T, ObjectId>
        implements BaseMongoRepository<T> {

    public Uni<T> create(T t) {
        return this.persist(t);
    }

    public Multi<T> getByIds(List<String> ids) {

        Document filter = new Document()
                .append("_id", new Document("$in", ids.stream().map(ObjectId::new).collect(Collectors.toList())));

        FindOptions findOptions = new FindOptions();

        return this.mongoCollection().find(filter, findOptions);
    }



}
