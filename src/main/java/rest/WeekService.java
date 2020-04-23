package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;

import dbService.DBException;
import dbService.DBService;
import dbService.InvalidSymbolsException;
import main.SetupObjects;
import model.Login;
import model.Week;

@Path(WeekService.url)
public class WeekService {
    public static final String url = "/week";
    private final DBService dbService = SetupObjects.getDbService();

    @GET
    @Path("/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Week getWeek(@PathParam("number") int number, @QueryParam("header") String header) {
        Week result = new Week(number, header);

        // todo : business logic

        return result;
    }
}
