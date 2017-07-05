package glossary.engine.dao;

import glossary.engine.model.Card;
import glossary.engine.model.CardList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public class CardListDaoImpl extends BaseDaoImpl implements CardListDao {
    private final CardDao cardDao;

    public CardListDaoImpl(Connection connection, CardDao cardDao) {
        super(connection);
        this.cardDao = cardDao;
    }

    @Override
    public List<CardList> findAll() {
        ArrayList<CardList> list = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();

            String sql = "SELECT * FROM list ORDER BY id";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CardList cardList = new CardList(rs.getInt("id"), rs.getString("name"));
                list.add(cardList);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public CardList save(CardList cardList, List<Card> cards) {
        try {
            if (cardList.getName().isEmpty() || cards == null) {
                return null;
            }

            // Start transaction
            connection.setAutoCommit(false);

            CardList cardListSaved = saveCardList(cardList);
            if (cardListSaved == null) {
                return null;
            }

            for (Card card : cards) {
                card.setCardListId(cardListSaved.getId());
                if (cardDao.save(card) == null) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return null;
                }
            }

            // Comit transaction
            connection.commit();
            return cardListSaved;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException excep) {
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                // End trasaction
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public boolean remove(int listId) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM list WHERE id = ?");

            stmt.setInt(1, listId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    private CardList saveCardList(CardList cardList) {
        try {

            PreparedStatement stmt;
            if (cardList.getId() > 0) {
                stmt = connection.prepareStatement("UPDATE list SET name = ? WHERE id = ?");
                stmt.setInt(2, cardList.getId());
            } else {
                stmt = connection.prepareStatement("INSERT INTO list(name) VALUES(?)");
            }

            stmt.setString(1, cardList.getName());
            stmt.executeUpdate();

            if (cardList.getId() == 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                cardList.setId(rs.getInt(1));
            }

            return cardList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
