package cr.centriz.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;
import javax.ws.rs.core.Response;

import cr.centriz.services.UserService;
import cr.centriz.utils.UserObjectData;

@Path("v1/user")
public class UserResource {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();
    UserService userService = new UserService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserObjectData userObjectData) {
        return userService.createUser(userObjectData);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public UserObjectData getUserById(@PathParam("userId") int userId) throws NoContentException {
        return userService.getSimplifiedUserById(userId);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(UserObjectData userObjectData) {
        return userService.updateUser(userObjectData);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response deleteUser(@PathParam("userId") int userId) {
        return userService.deleteUserById(userId);
    }
}
