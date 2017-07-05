package glossary.engine.dao;


import java.sql.Connection;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public abstract class BaseDaoImpl {
    Connection connection;

    public BaseDaoImpl(Connection connection) {
        this.connection = connection;
    }
}
