package cr.centriz.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;
import javax.ws.rs.core.Response;

import cr.centriz.services.BrandService;
import cr.centriz.utils.BrandObjectData;

@Path("v1/brand")
public class BrandResource {

    BrandService brandService = new BrandService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBrand(BrandObjectData objectData) {
        return brandService.createBrand(objectData);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public BrandObjectData getUserById(@PathParam("id") int id) throws NoContentException {
        return brandService.getSimplifiedBrandById(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(BrandObjectData objectData) {
        return brandService.updateBrand(objectData);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        return brandService.deleteBrandById(id);
    }
}
