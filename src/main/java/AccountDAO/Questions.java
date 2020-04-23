package AccountDAO;

import model.Week;

import java.sql.Connection;
import java.sql.SQLException;

// todo : form the structure of the table
public class Questions extends QuestionsDAO<Integer> {
    public Questions(Connection connection) {
        super(connection);
    }

    // todo: override method after negotiation on week information

    @Override
    public Week getWeek(Integer id) throws SQLException {
        return executor.execQuery("select * from questions where id='" + id + "'", result -> {
            //if (result.next())

            return new Week(1, "");
        });
    }

    public void createTable() throws SQLException {             // structure of the table
        executor.execUpdate("create table if not exists questions (id int, user_name varchar(256), pass varchar(256), primary key (id))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table questions");
    }
}
