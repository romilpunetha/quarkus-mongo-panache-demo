package base;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseRepositoryImpl<T extends BaseEntity<ID>, ID> implements BaseRepository<T, ID> {

}
