package glossary.engine.dao;

import glossary.engine.model.Card;

import java.util.List;

/**
 * Provide data access to Card storage
 */
public interface CardDao {
    /**
     * Find all cards in given CardList id
     *
     * @param listId CardList id
     * @return List is empty when listId doesn't exists
     */
    List<Card> findAllByCardListId(int listId);

    /**
     * Save new or existing Card
     * If Card.id is null, then new Card is created, otherwise update existing Card by id.
     *
     * @param card Card to save
     * @return NULL on error
     */
    Card save(Card card);

    /**
     * @param cardId Card id to remove
     * @return true on succes
     */
    boolean remove(int cardId);

    /**
     * Count total number of Cards in given list
     *
     * @param listId CardList id
     * @return number or cards, 0 if CardList is empty, or not found
     */
    int countByCardListId(int listId);

    /**
     * Randomly pick given number of Cards from list
     *
     * @param wordCount  Number of Cards to pick
     * @param cardListId CardList id
     * @return List of Cards, can by empty if CardList not found
     */
    List<Card> pickForTest(int wordCount, int cardListId);
}
