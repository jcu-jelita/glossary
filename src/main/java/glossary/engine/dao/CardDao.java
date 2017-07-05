package glossary.engine.dao;

import glossary.engine.model.Card;
import glossary.engine.model.CardList;

import java.util.List;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public interface CardDao {

    List<Card> findAllByCardListId(int listId);

    boolean save(Card card);

    boolean remove(int cardId);
}
