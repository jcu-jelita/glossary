package glossary.engine.service;

import glossary.global.CardList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public class ListDAO implements glossary.global.ListService {

    DatabaseService database;

    public ListDAO(DatabaseService database) {
        this.database = database;
    }

    @Override
    public CardList[] getLitOverview() {
        try {
            Statement stmt = database.getConnection().createStatement();

            String sql = "SELECT * FROM list";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + name);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new CardList[]{
                new CardList(0, "Počasí"),
                new CardList(3, "Podstatná jména"),
                new CardList(5, "Biznis"),
        };

    }

    @Override
    public CardList getLitDetail(int id) {
        HashMap<Integer, String[]> words = new HashMap<>();
        words.put(0, new String[]{"Ice", "Led"});
        words.put(1, new String[]{"and", "a"});
        words.put(2, new String[]{"Fire", "ohěň"});

        return new CardList(0, "GoT", words);
    }

    @Override
    public CardList save(CardList cardList) {
        try {
            PreparedStatement stmt = database.getConnection().prepareStatement("INSERT INTO list('name') VALUES(?)");

            stmt.setString(0, cardList.getName());
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getLitDetail(cardList.getId());
    }

    @Override
    public boolean remove(int listId) {
        return false;
    }
}
