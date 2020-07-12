package rest;

import dbService.DBException;
import dbService.DBService;
import main.SetupObjects;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path(GetDayService.url + "/{id}" + "/{date}")
public class GetDayService {
    public static final String url = "/get_day";
    private final DBService daysDBService = SetupObjects.getDbService();

    /*@GET
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDay(@PathParam("id") Integer id, @PathParam("date") String date) {
        try {
            String day = daysDBService.getDay("COUCH_NAME", id, date);

            return Response.status(Response.Status.OK).entity(day).build();
        } catch (DBException e) {
            e.printStackTrace();

            return Response.status(Response.Status.BAD_REQUEST).entity("error").build();
        }
    }*/

    @GET
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDays(@PathParam("id") Integer id) {
        try {
            ArrayList<String> day = daysDBService.getAllDays("COUCH_NAME", id);

            return Response.status(Response.Status.OK).entity(day).build();
        } catch (DBException e) {
            e.printStackTrace();

            return Response.status(Response.Status.BAD_REQUEST).entity("error").build();
        }
    }
}