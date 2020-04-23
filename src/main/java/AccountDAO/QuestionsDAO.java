package AccountDAO;

import model.Week;
import dbService.*;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class QuestionsDAO<ID> {
    Executor executor;

    public QuestionsDAO(Connection connection) {
        executor = new Executor(connection);
    }

    public abstract Week getWeek(ID id) throws SQLException;
}
