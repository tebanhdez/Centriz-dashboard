package cr.centriz.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cr.centriz.entities.User;
import cr.centriz.utils.HibernateUtil;

/**
 * Root resource (exposed at "user" path)
 */
@Path("user")
public class UserResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        return Response.status(201).entity("Created successfully").build();
    }
}