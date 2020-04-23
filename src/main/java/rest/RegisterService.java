package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dbService.DBException;
import dbService.InvalidSymbolsException;
import main.SetupObjects;
import model.Login;
import dbService.DBService;

@Path(RegisterService.url)
public class RegisterService {
    public static final String url = "/signup";
    private final DBService dbService = SetupObjects.getDbService();

    @PUT
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccount(@FormParam("login") String login, @FormParam("password") String password) {
        boolean valid = false;

        try {
            valid = dbService.addUser(new Login(login, password)) != -1;
        } catch (DBException e) {
            e.printStackTrace();
            return Response.status(Response.Status.FORBIDDEN)
                            .entity(valid).build();
        }

        return Response.status(Response.Status.ACCEPTED)
                        .entity(valid).build();
    }
}
