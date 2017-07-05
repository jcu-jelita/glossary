package glossary.engine.dao;

import glossary.engine.model.Card;
import glossary.engine.model.CardList;

import java.util.List;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public class CardListDaoMock implements CardListDao {

    @Override
    public Card findByCardListId(int listId) {
      /*  HashMap<Integer, String[]> words = new HashMap<>();
        words.put(0, new String[]{"Ice", "Led"});
        words.put(1, new String[]{"and", "a"});
        words.put(2, new String[]{"Fire", "ohěň"});

        return new CardList(0, "GoT", words);*/
        return null;
    }

    @Override
    public List<Card> findAll() {
        return null;
    }

    @Override
    public CardList save(CardList cardList, List<Card> cards) {
        return null;
    }

    @Override
    public boolean remove(int listId) {
        return false;
    }
}
