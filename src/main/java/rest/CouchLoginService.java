package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import dbService.DBException;
import dbService.DBService;
import main.SetupObjects;
import model.IdsPair;
import JWTHelper.*;

import java.util.HashMap;
import java.util.Set;

@Path(CouchLoginService.url)
public class CouchLoginService {
    public static final String url = "/login";
    private final DBService dbService = SetupObjects.getDbService();
    private final HashMap<Long, String> couchesLongToString = SetupObjects.getCouchesLongToString();
    private final HashMap<String, Long> couchesStringToLong = SetupObjects.getCouchesStringToLong();

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response authorizeUser(@FormParam("login") String login, @FormParam("password") String password) {
        System.err.println("Login attempt with login = " + login + ", password = " + password);

        boolean valid = false;

        try {
            valid = dbService.checkUser(new IdsPair(login, password));
        } catch (DBException e) {
            e.printStackTrace();
            return Response.status(Response.Status.FORBIDDEN)
                    .entity(valid).build();
        }

        //if (!couchesStringToLong.containsKey(login))


        String privateKey = JsonWebTokenHelper.getInstance().generatePrivateKey(login, password);

        Response.ResponseBuilder builder = Response
                .status(Response.Status.OK)
                .cookie(new NewCookie("privateKey", privateKey))
                .entity(valid);            // whether username and password exists or not

        return builder.build();
    }
}
