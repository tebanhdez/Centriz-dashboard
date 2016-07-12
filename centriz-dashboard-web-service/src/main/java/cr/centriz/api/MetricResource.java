package cr.centriz.api;

import java.text.ParseException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cr.centriz.services.MetricService;

@Path("v1/metric")
public class MetricResource {

    MetricService metricService = new MetricService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{sd}/{ed}")
    public String getMetrics(@PathParam("sd") String sd, @PathParam("ed") String ed) throws ParseException {
        return metricService.getMetricsByDate(sd, ed);
    }

}