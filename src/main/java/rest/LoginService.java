package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import dbService.DBException;
import dbService.DBService;
import main.SetupObjects;
import model.Login;
import JWTHelper.*;

// todo : handle all exceptions properly

@Path(LoginService.url)
public class LoginService {
    public static final String url = "/login";
    private final DBService dbService = SetupObjects.getDbService();

    // todo : cookie params in response

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response authorizationService(@FormParam("login") String login, @FormParam("password") String password) {
        System.err.println("Login attempt with login = " + login + ", password = " + password);

        boolean valid = false;

        try {
            valid = dbService.checkUser(new Login(login, password));
        } catch (DBException e) {
            e.printStackTrace();
            return Response.status(Response.Status.FORBIDDEN)
                            .entity(valid).build();
        }

        String privateKey = JsonWebTokenHelper.getInstance().generatePrivateKey(login, password);

        Response.ResponseBuilder builder = Response
                .status(Response.Status.ACCEPTED)
                .cookie(new NewCookie("privateKey", privateKey))
                .entity(valid);            // whether username and password exists or not

        return builder.build();
    }

    @GET
    @Consumes()
    @Produces(MediaType.TEXT_PLAIN)
    public String doGet() {
        return "Testing";
    }
}
