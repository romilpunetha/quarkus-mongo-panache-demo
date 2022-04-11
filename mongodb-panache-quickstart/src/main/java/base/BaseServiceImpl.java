package base;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseServiceImpl<T extends BaseEntity<ID>, ID>
        implements BaseService<T, ID> {

    BaseRepository<T, ID> repository;

    public BaseServiceImpl(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

}
