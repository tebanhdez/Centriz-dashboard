package cr.centriz.api;

import java.util.List;

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
import javax.ws.rs.core.Response;

import cr.centriz.entities.User;
import cr.centriz.entities.UserRole;
import cr.centriz.utils.UserRequest;

@Path("v1/user")
public class UserResource {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setFullName(userRequest.getFullName());
        user.setRole(em.find(UserRole.class, userRequest.getUserRoleId()));
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Response.ok("{\"msg \": \"User created correctly\"}", MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        em.getTransaction().begin();
        List<User> usersObjects = (List<User>) em.createQuery("select u from User").getResultList();
        em.getTransaction().commit();
        return usersObjects;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public User getUserById(@PathParam("userId") int userId) {
        em.getTransaction().begin();
        User userObject = (User) em.createQuery("select u from User u where u.id = ?1").setParameter(1, userId)
                .getSingleResult();
        em.getTransaction().commit();
        return userObject;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setFullName(userRequest.getFullName());
        user.setRole(em.find(UserRole.class, userRequest.getUserRoleId()));
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Response.ok("{\"msg \": \"User updated correctly\"}", MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(User user) {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        return Response.ok("{\"msg \": \"User deleted correctly\"}", MediaType.APPLICATION_JSON).build();
    }
}
