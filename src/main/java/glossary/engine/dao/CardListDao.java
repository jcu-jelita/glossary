package glossary.engine.dao;

import glossary.engine.model.Card;
import glossary.engine.model.CardList;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public interface CardListDao {

    List<Card> findAll();

    CardList save(CardList cardList, List<Card> cards);

    boolean remove(int listId);
}
