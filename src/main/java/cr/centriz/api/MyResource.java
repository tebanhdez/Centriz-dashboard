package cr.centriz.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cr.centriz.entities.UserRole;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	UserRole userRole = new UserRole();
    	userRole.setName("ADMIN");
    	em.persist(userRole);
    	em.getTransaction().commit();
        return "Hello, Heroku!";
    }
}