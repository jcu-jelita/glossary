package glossary.engine.dao;

import glossary.engine.model.Card;

import java.util.List;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public class CardDaoMock implements CardDao {
    @Override
    public List<Card> findAllByCardListId(int listId) {
        return null;
    }

    @Override
    public boolean save(Card card) {
        return false;
    }

    @Override
    public boolean remove(int cardId) {
        return false;
    }
}
