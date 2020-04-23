package AccountDAO;

import dbService.Executor;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class AccountDAO<ID> {
    Executor executor;

    public AccountDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public abstract void insertUser(ID IdKeys) throws SQLException, AccException;

    public abstract <T> int getUserNumberId(T IdKeys) throws SQLException;
}
