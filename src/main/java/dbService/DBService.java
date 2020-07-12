package dbService;

import java.sql.*;
import java.util.ArrayList;

import AccountDAO.*;
import DaysDAO.Days;
import model.IdsPair;
import model.Login;

public class DBService {
    private final Connection connection;

    public DBService() {
        connection = getMySQLConnection();
    }

    public void addDays(String couch, Integer id, String date, String exercises) throws DBException {
        try {
            connection.setAutoCommit(false);
            Days dao = new Days(connection, couch);
            dao.createTable(id);

            dao.addDay(date, exercises, id);

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {}
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {}
        }
    }

    public String getDay(String couch, Integer id, String date) throws DBException {
        try {
            connection.setAutoCommit(false);
            Days dao = new Days(connection, couch);
            dao.createTable();

            String result = dao.getDay(date, id);

            connection.commit();

            return result;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {}
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {}
        }
    }

    public ArrayList<String> getAllDays(String couch, Integer id) throws DBException {
        try {
            connection.setAutoCommit(false);
            Days dao = new Days(connection, couch);
            dao.createTable();

            ArrayList<String> result = dao.getAllDays(id);

            connection.commit();

            return result;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {}
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {}
        }
    }

    public int getUserId(String login) throws DBException {
        int result = 0;

        try {
            connection.setAutoCommit(false);
            Account dao = new Account(connection);
            dao.createTables();

            result = dao.getUserNumberId(login);

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {}
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {}
        }

        return result;
    }

    public int addUser(Login id) throws DBException {
        /*if (id.getLogin().isEmpty() || id.getPassword().isEmpty())
            throw new InvalidSymbolsException("zero");
        if (isRussian(id.getLogin()) || isRussian(id.getPassword()))
            throw new InvalidSymbolsException("");*/

        try {
            connection.setAutoCommit(false);
            Account dao = new Account(connection);
            dao.createTables();
            try {
                dao.insertUser(id);
            } catch (AccException e) {
                throw new DBException(e);
            }
            connection.commit();

            return dao.getUserNumberId(id);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {}
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {}
        }
    }

    public void updatePassword(IdsPair id) throws DBException {
        try {
            connection.setAutoCommit(false);
            Account dao = new Account(connection);

            dao.updatePassword(id);

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {}
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {}
        }
    }

    // Returns true if the user exists, false otherwise
    public <T> boolean checkUser(T id) throws DBException {
        /*if (id.getLogin().isEmpty() || id.getPassword().isEmpty())
            throw new InvalidSymbolsException("zero");
        if (isRussian(id.getLogin()) || isRussian(id.getPassword()))
            throw new InvalidSymbolsException("");*/

        try {
            connection.setAutoCommit(false);
            Account dao = new Account(connection);
            dao.createTables();

            int resultId = dao.getUserNumberId(id);

            connection.commit();

            return resultId != -1;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {}
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {}
        }
    }

    private static Connection getMySQLConnection() {
        try {
            //DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();
            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("logindb?").             //db name
                    append("useUnicode=true&").     //unicode
                    append("serverTimezone=UTC");   //timezone
                    String name = "denis";          //login
                    String password = "7185kLM]";   //password

            System.err.println("URL: " + url + "\n");

            return DriverManager.getConnection(url.toString(), name, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public void cleanUp() throws DBException {
        Account accountDao = new Account(connection);

        try {
            accountDao.dropTables();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}
