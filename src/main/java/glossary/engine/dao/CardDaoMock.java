package glossary.engine.dao;

import glossary.engine.model.Card;
import glossary.engine.model.CardList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public class CardDaoMock implements CardDao {
    /**
     *  Get all Cards by List ID
     * @param listId ID of List
     * @return a Card List
     */
    @Override
    public List<Card> findAllByCardListId(int listId) {
        CardList cl = new CardList();
        List<Card> al = new ArrayList<>();
        al.get(cl.getId());
        return al;
    }

    @Override
    public boolean save(Card card) {
        return true;
    }

    @Override
    public boolean remove(int cardId) {
        return true;
    }

    @Override
    public int countByCardListId(int listId) {
        return 5;
    }

    @Override
    public int countByCardListId(int listId) {
        return 0;
    }
}
