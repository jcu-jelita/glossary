package glossary.engine.dao;

import glossary.engine.model.Card;
import glossary.engine.model.CardList;

import java.util.List;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public class CardListDaoMock implements CardListDao {

    @Override
    public List<CardList> findAll() {
        return null;
    }

    @Override
    public CardList save(CardList cardList, List<Card> cards) {
        return null;
    }
    //Udělat konstruktor
    @Override
    public boolean remove(int listId) {
        return false;
    }
}
