package glossary.engine;

import glossary.engine.dao.*;
import glossary.engine.facade.WritingTestFacade;
import glossary.engine.facade.WritingTestFacadeImpl;
import glossary.engine.factory.DatabaseFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public class GlossaryEngine {
    static private final String DB_FILE_NAME = "glossary.db";

    private final Connection connection;


    public GlossaryEngine() {
        connection = DatabaseFactory.craete(DB_FILE_NAME);
    }

    public CardListDao getCardListDao() {
        return new CardListDaoImpl(connection, getCardDao());
    }

    public CardDao getCardDao() {
        return new CardDaoImpl(connection);
    }


    public WritingTestFacade startWritingTest(int wordCount, int cardlistId) {
        return new WritingTestFacadeImpl(wordCount, cardlistId, getCardDao());
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
