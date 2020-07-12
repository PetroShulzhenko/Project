package AccountDAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dbService.Executor;
import model.IdsPair;
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

        StringBuilder firstCommand = new StringBuilder();
        firstCommand.append("insert into users (user_name, pass) values ('").
                append(IdKeys.getLogin()).
                append("', '").
                append(IdKeys.getPassword()).
                append("')");
        executor.execUpdate(firstCommand.toString());

        StringBuilder secondCommand = new StringBuilder();
        secondCommand.append("insert into extended_users (name, surname, fathers_name, is_sub) values ").
                append(IdKeys.getAccountInforamtion());
        executor.execUpdate(secondCommand.toString());
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
        StringBuilder query = new StringBuilder();
        if (IdKeys instanceof String)
            query.append("select * from users where user_name='" + IdKeys + "'");
        else if (IdKeys instanceof IdsPair) {
            IdsPair id = (IdsPair) IdKeys;
            query.append("select * from users where user_name='").
                    append(id.getLogin()).
                    append("' and pass='").
                    append(id.getPassword()).
                    append("'");
        } else if (IdKeys instanceof Login) {
            Login id = (Login) IdKeys;
            query.append("select * from users where user_name='").
                    append(id.getLogin()).
                    append("' and pass='").
                    append(id.getPassword()).
                    append("'");
        } else
            return -1;

        return executor.execQuery(query.toString(),
                result -> {
                    if (result.next())
                        return result.getInt(1);
                    return -1;
                });
    }

    public IdsPair getLogin(int id) throws SQLException {
        return executor.execQuery("select * from users where id=" + id, result -> {
            result.next();
            return new IdsPair(result.getString(2), result.getString(3));            // build a table;
        });
    }

    public void updatePassword(IdsPair IdKeys) throws SQLException {
        executor.execUpdate(new StringBuilder().append("update users set pass='").
                append(IdKeys.getPassword()).
                append("' where user_name='").
                append(IdKeys.getLogin()).
                append("'").toString());
    }

    public void createTables() throws SQLException {             // structure of the table
        executor.execUpdate("create table if not exists users (id int auto_increment, user_name varchar(50), pass varchar(20), primary key (id))");
        executor.execUpdate("create table if not exists extended_users (id int auto_increment, name varchar(20), surname varchar(20), " +
                "fathers_name varchar(20), is_sub tinyint(1), primary key (id))");
    }

    public void dropTables() throws SQLException {
        executor.execUpdate("drop table users");
        executor.execUpdate("drop table extended_users");
    }
}
