package rest;

import dbService.DBException;
import dbService.DBService;
import main.SetupObjects;

import javax.ws.rs.*;

@Path(WriteDayService.url + "/{id}" + "/{date}")
public class WriteDayService {
    public static final String url = "/write_date";
    private final DBService daysDBService = SetupObjects.getDbService();

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void postDay(@PathParam("id") Integer id, @PathParam("date") String date, String json) {
        try {
            daysDBService.addDays("COUCH_NAME", id, date, json);
        } catch (DBException e) {
            e.printStackTrace();

            throw new WebApplicationException(e);
        }
    }
}
