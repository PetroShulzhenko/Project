package DaysDAO;

import model.Day;
import dbService.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public abstract class DaysDAO {
    Executor executor;

    public DaysDAO(Connection connection) {
        executor = new Executor(connection);
    }

    public abstract String getDay(String date, Integer id) throws SQLException;

    public abstract void addDay(String date, String exercises, Integer id) throws SQLException;
}
