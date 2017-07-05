package glossary.engine.dao;

import glossary.engine.model.Card;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public class CardDaoImpl extends BaseDaoImpl implements CardDao {


    public CardDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Card> findAllByCardListId(int listId) {
        ArrayList<Card> list = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM card WHERE id_list = ? ORDER BY id");
            stmt.setInt(1, listId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Card card = new Card(rs.getInt("id"), listId, rs.getString("word_1"), rs.getString("word_2"));
                list.add(card);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Card save(Card card) {

        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO card(id_list, word_1, word_2) VALUES(?, ?, ?)");
            stmt.setInt(1, card.getCardListId());
            stmt.setString(2, card.getWord1());
            stmt.setString(3, card.getWord2());
            if (stmt.executeUpdate() > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                card.setId(rs.getInt(1));

                return card;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remove(int cardId) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM card WHERE id = ?");
            stmt.setInt(1, cardId);
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public int countByCardListId(int listId) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(c.id) AS cardCount FROM card AS c WHERE c.id_list = ?");
            stmt.setInt(1, listId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("cardCount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Card> pickForTest(int wordCount, int cardListId) {
        ArrayList<Card> list = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM card WHERE id_list = ? ORDER BY RANDOM() LIMIT ?");
            stmt.setInt(1, cardListId);
            stmt.setInt(2, wordCount);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Card card = new Card(rs.getInt("id"), cardListId, rs.getString("word_1"), rs.getString("word_2"));
                list.add(card);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
