package user;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Multi;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jboss.resteasy.reactive.RestStreamElementType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@ApplicationScoped
@Path("/v1/users")
public class UserResource {

    @Inject
    protected UserService service;

    @POST
    public void create() {
        List<String> ids = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            UserEntity user = UserEntity.builder()
                    .name("test")
                    .build();

            service.create(user)
                    .invoke(user1 -> ids.add(user1.getId().toString()))
                    .await().indefinitely();
        }
        Log.info("UserIds :" + ids);
    }

    @POST
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    @Path("/ids")
    public Multi<UserEntity> getByIds(List<String> ids) {
        return service.getByIds(ids);
    }
}
