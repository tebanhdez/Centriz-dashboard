package cr.centriz.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cr.centriz.entities.User;
import cr.centriz.entities.UserRole;
import cr.centriz.utils.UserObjectData;

public class UserService {
    private static final Log LOGGER = LogFactory.getLog(UserService.class);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();

    public Response createUser(UserObjectData objectData) {
        User user = new User();
        user.setEmail(objectData.getEmail());
        user.setPassword(objectData.getPassword());
        user.setFullName(objectData.getFullName());
        user.setRole(em.find(UserRole.class, objectData.getUserRoleId()));
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Response.ok("{\"msg \": \"User created correctly\"}", MediaType.APPLICATION_JSON).build();
    }

    private User getUserById(int id) {
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.getTransaction().commit();
        return user;
    }

    public UserObjectData getSimplifiedUserById(int id) throws NoContentException {
        User user = getUserById(id);
        if (user == null) {
            LOGGER.error("User not found");
            throw new NoContentException("\"Error \": \"User not found\"");
        }
        UserObjectData userObjectData = new UserObjectData();
        userObjectData.setEmail(user.getEmail());
        userObjectData.setFullName(user.getFullName());
        userObjectData.setPassword(user.getPassword());
        userObjectData.setUserRoleId(user.getRole().getUserRoleId());
        return userObjectData;
    }

    public Response updateUser(UserObjectData objectData) {
        User user = new User();
        user.setEmail(objectData.getEmail());
        user.setPassword(objectData.getPassword());
        user.setFullName(objectData.getFullName());
        user.setRole(em.find(UserRole.class, objectData.getUserRoleId()));
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Response.ok("{\"msg \": \"User updated correctly\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response deleteUserById(int id) {
        User user = getUserById(id);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        return Response.ok("{\"msg \": \"User deleted correctly\"}", MediaType.APPLICATION_JSON).build();
    }
}