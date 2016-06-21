package cr.centriz.api;

import java.io.IOException;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cr.centriz.entities.User;
import cr.centriz.entities.UserRole;
import cr.centriz.services.AuthenticationService;
import cr.centriz.utils.LoginRequest;
import cr.centriz.utils.ResourceManager;

@Path("v1/auth")
public class AuthenticationResource {

    private static final Log LOGGER = LogFactory.getLog(AuthenticationResource.class);

    private static Properties properties = null;

    static{
        properties = new Properties();
        try {
                properties.load(ResourceManager.getResourceAsInputStream("centriz.properties"));
            } catch (IOException exception) {
                LOGGER.error("Error loading properties file", exception);
            }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response authenticate(LoginRequest credentials) {

        String response = "{\"RoleIdentifier\": \"%s\", \"status\":\"%s\"}";
        
        AuthenticationService authService = new AuthenticationService();
        User user = authService.findUserByEmail(credentials.getEmail());
        LOGGER.info("Filter test");
        if (user == null)
            return Response.status(Status.UNAUTHORIZED).entity(javax.ws.rs.client.Entity.json("{\"Error \": \"User not found \"}")).build();
        
        UserRole userRole = user.getRole();
        if(userRole == null)
            return Response.status(Status.NO_CONTENT).entity(javax.ws.rs.client.Entity.json("{\"Error \": \"UserRole not found \"}")).build();
        switch (userRole.getName()) {
		    case "ADMIN":
		        response = String.format(response, user.getRole().getName(), "OK");
		        break;
		    case "WRITE":
		        response = String.format(response, user.getRole().getName(), "OK");
		        break;
		    case "READ":
		        response = String.format(response, user.getRole().getName(), "OK");
		        break;
		    default:
		        response = String.format(response, "", "OK");
		        break;
		    }
		response = String.format(response, user.getRole().getName(), "OK");
        return Response.status(200).entity(response).build();
    }
}