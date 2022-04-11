package base;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.util.List;


public interface BaseRepository<T extends BaseEntity<ID>, ID> {
    Uni<T> create(T t);

    Multi<T> getByIds(List<String> ids);

}
