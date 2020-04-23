package AccountDAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dbService.Executor;
import model.Login;

import javax.print.DocFlavor;

public class Account extends AccountDAO<Login> {
    public Account(Connection connection) {
        super(connection);
    }

    @Override
    public void insertUser(Login IdKeys) throws SQLException, AccException {
        if (getUserNumberId(IdKeys) != -1) {
            throw new AccException("already exists");
        }

        executor.execUpdate("insert into users (user_name, pass) values ('" + IdKeys.getLogin() + "', '" +
                IdKeys.getPassword() + "')");
    }

    /*@Override
    public int getUserNumberId(Login IdKeys) throws SQLException {
        return executor.execQuery("select * from users where user_name='" + IdKeys.getLogin() + "' and pass='" +
                IdKeys.getPassword() + "'", result -> {
            if (result.next())
                return result.getInt(1);
            return -1;
        });
    }*/

    @Override
    public <T> int getUserNumberId(T IdKeys) throws SQLException {
        String query;
        if (IdKeys instanceof String)
            query = "select * from users where user_name='" + IdKeys + "'";
        else if (IdKeys instanceof Login) {
            Login id = (Login) IdKeys;
            query = "select * from users where user_name='" + id.getLogin() + "' and pass='" +
                    id.getPassword() + "'";
        } else
            return -1;

        return executor.execQuery(query,
                result -> {
                    if (result.next())
                        return result.getInt(1);
                    return -1;
                });
    }

    public Login getLogin(int id) throws SQLException {
        return executor.execQuery("select * from users where id=" + id, result -> {
            result.next();
            return new Login(result.getString(2), result.getString(3));            // build a table;
        });
    }

    public void updatePassword(Login IdKeys) throws SQLException {
        executor.execUpdate("update users set pass='" + IdKeys.getPassword() + "' where user_name='" + IdKeys.getLogin() + "'");
    }

    public void createTable() throws SQLException {             // structure of the table
        executor.execUpdate("create table if not exists users (id int auto_increment, user_name varchar(256), pass varchar(256), primary key (id))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }
}
