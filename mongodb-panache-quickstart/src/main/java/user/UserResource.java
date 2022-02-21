package user;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.concurrent.ExecutionException;

@FieldDefaults(level = AccessLevel.PRIVATE)
@ApplicationScoped
@Path("/v1/users")
public class UserResource {

    @Inject
    protected UserService service;
    
    @POST
    public Uni<UserEntity> create() {
        UserEntity user = UserEntity.
                builder().name("test5").build();
        return service.create(user);
    }

    @GET
    @Path("/{id}")
    public Uni<UserEntity> get(@PathParam("id") String id) {
        return service.get(id);
    }


}
