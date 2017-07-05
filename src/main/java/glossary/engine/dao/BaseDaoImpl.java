package glossary.engine.dao;


import java.sql.Connection;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
abstract class BaseDaoImpl {
    final Connection connection;

    BaseDaoImpl(Connection connection) {
        this.connection = connection;
    }
}
