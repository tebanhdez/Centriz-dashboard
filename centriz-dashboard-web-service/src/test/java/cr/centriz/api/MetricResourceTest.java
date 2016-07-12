package cr.centriz.api;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;


public class MetricResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(MetricResource.class);
    }

    @Test
    public void getBrandResourceTest() {
        String metric = target().path("v1/metric/20161001/20160201").request().get(String.class);
        Assert.assertNotNull("Metric not found", metric);
    };
}
