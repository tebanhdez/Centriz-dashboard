package cr.centriz.api;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cr.centriz.entities.DefaultUserRole;
import cr.centriz.utils.UserRequest;

public class UserResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(UserResource.class);
    }

    UserRequest adminUser = new UserRequest();

    @Before
    public void createAdminUserTest() {
        adminUser.setEmail("admin@user.com");
        adminUser.setFullName("Admin User");
        adminUser.setPassword("centriz");
        adminUser.setUserRoleId(DefaultUserRole.ADMIN.getId());
    }

    @Test
    public void createUserResourceTest() {
        final Response confirmationResponse = target().path("v1/user").request().post(Entity.json(adminUser));
        assertEquals(200, confirmationResponse.getStatus());
    }
    
    @Test
    public void getUserResourceTest() {
        adminUser.setFullName("Admin User updated");
        final Response confirmationResponse = target().path("v1/user/1").request().get();
        assertEquals(200, confirmationResponse.getStatus());
    }
    
    @Test
    public void updateUserResourceTest() {
        adminUser.setFullName("Admin User updated");
        final Response confirmationResponse = target().path("v1/user").request().put(Entity.json(adminUser));
        assertEquals(200, confirmationResponse.getStatus());
    }

}
