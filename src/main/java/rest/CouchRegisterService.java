package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dbService.DBException;
import dbService.InvalidSymbolsException;
import main.SetupObjects;
import model.Login;
import dbService.DBService;

@Path(CouchRegisterService.url)
public class CouchRegisterService {
    public static final String url = "/couch_register";
    private final DBService dbService = SetupObjects.getDbService();

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerAccount(@FormParam("surname") String surname, @FormParam("name") String name, @FormParam("fathersName") String fathersName,
                                    @FormParam("email") String login, @FormParam("password") String password, @FormParam("radio") boolean isSub) {
        System.err.println("Register attempt with login = " + login + ", password = " + password);

        try {
            dbService.addUser(new Login(login, password, name, surname, fathersName, isSub));
        } catch (DBException e) {
            e.printStackTrace();
            return Response.status(Response.Status.FORBIDDEN)
                    .entity(false).build();
        }

        return Response.status(Response.Status.OK)
                .entity(true).build();
    }
}
