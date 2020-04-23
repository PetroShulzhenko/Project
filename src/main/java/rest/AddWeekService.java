package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import dbService.DBException;
import dbService.InvalidSymbolsException;
import main.SetupObjects;
import model.Week;
import dbService.DBService;

@Path(AddWeekService.url)
public class AddWeekService {
    public static final String url = "/add_week";
    private final DBService dbService = SetupObjects.getDbService();

    @PUT
    @Consumes("application/json")
    public void addWeek(Week week) {

    }
}
