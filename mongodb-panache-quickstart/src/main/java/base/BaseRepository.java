package base;

import io.smallrye.mutiny.Uni;


public interface BaseRepository<T extends BaseEntity<ID>, ID> {
    Uni<T> create(T t);

    Uni<T> get(ID id);

}
