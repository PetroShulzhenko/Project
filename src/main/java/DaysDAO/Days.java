package DaysDAO;

import model.Day;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


// todo : form the structure of the table
public class Days extends DaysDAO {
    private final String couch;

    public Days(Connection connection, String couch) {
        super(connection);
        this.couch = couch;
    }

    // todo: override method after negotiation on week information

    public ArrayList<ClientsStatus> getAllClients() throws SQLException {
        return executor.execQuery("select * from " + couch + "_clients", result -> {
            ArrayList<ClientsStatus> array = new ArrayList<>();
            while (result.next())
                array.add(new ClientsStatus(result.getString(1), result.getInt(2)));
            return array;
        });
    }

    @Override
    public String getDay(String date, Integer id) throws SQLException {
        return executor.execQuery("select * from " + couch + "_days_" + id + " where day='" + date + "'", result -> {
            result.next();
            return result.getString(2);
        });
    }

    @Override
    public void addDay(String date, String exercises, Integer id) throws SQLException {
        executor.execUpdate("insert into " + couch + "_days_" + id + " (day, exercises) values ('" + date + "', '" +
                            exercises + "')");
    }

    public String getDay(String date, String login) throws SQLException {
        return getDay(date, getIntegerId(login));
    }

    public ArrayList<String> getAllDays(String login) throws SQLException {
        return getAllDays(getIntegerId(login));
    }

    public ArrayList<String> getAllDays(Integer id) throws SQLException {
        return executor.execQuery("select * from " + couch + "_days_" + id, result -> {
            ArrayList<String> array = new ArrayList<>();
            while (result.next())
                array.add(result.getString(2));
            return array;
        });
    }

    public int getIntegerId(String login) throws SQLException {
        return executor.execQuery("select * from " + couch + "_clients where client='" + login + "'", result -> {
            result.next();
            return result.getInt(1) - 1;
        });
    }

    public void createTable(Integer id) throws SQLException {             // structure of the table
        executor.execUpdate("create table if not exists " + couch + "_days_" + id + " (day date, exercises varchar(500), primary key (day))");
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists " + couch + "_clients (id int auto_increment, client varchar(20), status int, primary key (client))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table " + couch + "_clients");
    }
}
