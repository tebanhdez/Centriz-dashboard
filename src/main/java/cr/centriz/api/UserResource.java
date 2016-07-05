package cr.centriz.api;

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
    
    UserService userService = new UserService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserObjectData objectData) {
        return userService.createUser(objectData);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public UserObjectData getUserById(@PathParam("id") int id) throws NoContentException {
        return userService.getSimplifiedUserById(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(UserObjectData objectData) {
        return userService.updateUser(objectData);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        return userService.deleteUserById(id);
    }
}