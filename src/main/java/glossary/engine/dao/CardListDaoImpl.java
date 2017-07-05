package glossary.engine.dao;

import glossary.engine.model.Card;
import glossary.engine.model.CardList;
import glossary.global.exception.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public class CardListDaoImpl extends BaseDaoImpl implements CardListDao {
    private CardDao cardDao;

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
        //TODO transaction
        CardList cardListSaved = saveCardList(cardList);


        for (Card card : cards) {
            if (!cardDao.save(card)) {
                // TODO revert transaction and print error
            }
        }

        return cardListSaved;
    }

    @Override
    public boolean remove(int listId) {
        try {
            //TODO update
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM list WHERE id = ?");

            stmt.setInt(1, listId);
            if (stmt.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    private CardList saveCardList(CardList cardList) {
        try {
            //TODO update
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO list(name) VALUES(?)");

            stmt.setString(1, cardList.getName());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            cardList.setId(rs.getInt("id"));

            return cardList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
