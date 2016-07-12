package cr.centriz.api;

import java.text.ParseException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cr.centriz.services.MetricService;

@Path("v1/metric")
public class MetricResource {

    MetricService metricService = new MetricService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{sd}/{ed}")
    public Response getMetrics(@PathParam("sd") String sd, @PathParam("ed") String ed) throws ParseException {
        return Response.ok().entity(metricService.getMetricsByDate(sd, ed)).header("Access-Control-Allow-Origin", "*").build();
    }

}