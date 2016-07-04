package cr.centriz.api;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cr.centriz.utils.BrandObjectData;

public class BrandResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(BrandResource.class);
    }

    BrandObjectData budget = new BrandObjectData();

    @Before
    public void createBrandTest() {
        budget.setName("Budget");
    }

    @Test
    public void createBrandResourceTest() {
        final Response confirmationResponse = target().path("v1/brand").request().post(Entity.json(budget));
        assertEquals(200, confirmationResponse.getStatus());
    }

    @Ignore
    @Test
    public void getBrandResourceTest() {
        BrandObjectData brand = target().path("v1/brand/1").request().get(BrandObjectData.class);
        Assert.assertNotNull("Brand not found", brand);
    }

    @Ignore
    @Test
    public void updateBrandResourceTest() {
        budget.setName("Budget name updated");
        final Response confirmationResponse = target().path("v1/brand").request().put(Entity.json(budget));
        assertEquals(200, confirmationResponse.getStatus());
    }
    
    @After
    public void deleteBrandResourceTest() {
        final Response confirmationResponse = target().path("v1/brand/1").request().delete();
        assertEquals(200, confirmationResponse.getStatus());
    }

}
