package cr.centriz.api;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cr.centriz.entities.DefaultUserRole;
import cr.centriz.entities.User;
import cr.centriz.entities.UserRole;
import cr.centriz.utils.LoginRequest;

public class AuthenticationResourceTest extends JerseyTest{

    @Override
    protected Application configure() {
        return new ResourceConfig(AuthenticationResource.class);      
    }   
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
	EntityManager em = emf.createEntityManager();
    User adminUser = new User();
    UserRole adminUserRole = new UserRole();
    
    @Before
    public void createTestUser(){

        adminUserRole.setName(DefaultUserRole.ADMIN.getName());
        adminUserRole.setDescription(DefaultUserRole.ADMIN.getDescription());
        
        adminUserRole.setName(DefaultUserRole.ADMIN.getName());
        adminUserRole.setDescription(DefaultUserRole.ADMIN.getDescription());

        adminUser.setFullName("Test user");
        adminUser.setEmail("test2@test.cr");
        adminUser.setPassword("test");
        adminUser.setRole(adminUserRole);
        
        em.getTransaction().begin();
    	em.persist(adminUserRole);
    	em.persist(adminUser);
    	em.getTransaction().commit();
    }

    @Test
    public void testCreateCompanyAdminUser() {
    	Assert.assertNotNull("Admin user role not found", adminUserRole);
    	Assert.assertNotNull("Admin user not found", adminUser);

        LoginRequest credentials = new LoginRequest();
        credentials.setEmail(adminUser.getEmail());
        credentials.setPassword(adminUser.getPassword());
        
        final Response confirmationResponse = target().path("v1/auth/login").request().post(Entity.json(credentials));
        assertEquals(200, confirmationResponse.getStatus());

        String jsonResponseString = confirmationResponse.readEntity(String.class);
        JsonReader jsonReader = Json.createReader(new StringReader(jsonResponseString));
        JsonObject object = jsonReader.readObject();
        jsonReader.close();
        Assert.assertEquals("OK", object.getString("status"));
        Assert.assertEquals(DefaultUserRole.ADMIN.getName(), object.getString("RoleIdentifier"));
    }

    @After
    public void deleteTestUsers(){
    	em.getTransaction().begin();
        em.remove(adminUser);
        em.remove(adminUserRole);
        em.getTransaction().commit();
    }
}

