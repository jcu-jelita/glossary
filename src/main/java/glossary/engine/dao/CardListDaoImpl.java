package glossary.engine.dao;

import glossary.engine.model.Card;
import glossary.engine.model.CardList;

import java.util.List;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public class CardListDaoImpl extends BaseDaoImpl implements CardListDao {
    @Override
    public Card findByCardListId(int listId) {
        return null;
    }

    @Override
    public List<Card> findAll() {
        return null;
    }

    @Override
    public CardList save(CardList cardList) {
        return null;
    }

    @Override
    public boolean remove(int listId) {
        return false;
    }


    /*
    @Override
    public List<CardList> getLitOverview() {
        ArrayList<CardList> list = new ArrayList<>();

        try {
            Statement stmt = database.getConnection().createStatement();

            String sql = "SELECT * FROM list ORDER BY id";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CardList cardList = new CardList(rs.getInt("id"), rs.getString("name"));
                list.add(cardList);
            }
            rs.close();
        } catch (SQLException | DatabaseException e) {
            e.printStackTrace();
        }

        return list;
    }



    @Override
    public CardList save(CardList cardList) {
        try {
            PreparedStatement stmt = database.getConnection().prepareStatement("INSERT INTO list(name) VALUES(?)");

            stmt.setString(1, cardList.getName());
            stmt.executeUpdate();

            // TODO zíkat ID listu

            HashMap<Integer, String[]> wordMap = cardList.getWordMap();
            wordMap.forEach((integer, strings) -> {
                try {
                    // todo jiný foreach aby nebylo dvakrát zachytávání
                    String insert = "INSERT INTO card('word_1', 'word_2') VALUES('" + strings[0] + "', '" + strings[1] + "')";
                    stmt.executeUpdate(insert);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            });
        } catch (SQLException | DatabaseException e) {
            e.printStackTrace();
            return null;
        }

        return getLitDetail(cardList.getId());
    }

    @Override
    public boolean remove(int listId) {
        return false;
    }*/
}
