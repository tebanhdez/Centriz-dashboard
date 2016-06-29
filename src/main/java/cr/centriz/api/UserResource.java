package cr.centriz.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cr.centriz.entities.User;

@Path("user")
public class UserResource {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
	EntityManager em = emf.createEntityManager();
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return Response.status(200).entity("Created correctly").build();
    }
}
