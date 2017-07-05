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
     * TESTING MOCK OBJECT
     * Mock object of getting all Cards by List ID
     *
     * @param listId ID of List
     * @return a Card List
     */
    @Override
    public List<Card> findAllByCardListId(int listId) {
        List<Card> al = new ArrayList<>();

        Card card1 = new Card(1, 2, "Hello", "Ahoj");
        Card card2 = new Card(2, 1, "Car", "Auto");
        Card card3 = new Card(3, 2, "Phone", "Telefon");
        Card card4 = new Card(4, 1, "Cell", "Buňka");
        al.add(card1);
        al.add(card2);
        al.add(card3);
        al.add(card4);

        return al;
    }

    /**
     * TESTING MOCK OBJECT
     * Method save for saving a Card
     * @param card Card for saving
     * @return true always for testing purposes
     */
    @Override
    public boolean save(Card card) {
        return true;
    }

    /**
     * TESTING MOCK OBJECT
     * Removing Card by its ID
     * @param cardId ID of card we want to remove
     * @return true always for testing purposes
     */
    @Override
    public boolean remove(int cardId) {
        return true;
    }

    /**
     * TESTING MOCK OBJECT
     * Method returning number of Cards included in one List
     * @param listId ID of List we want to know number of cards
     * @return a integer of number of cards
     */
    @Override
    public int countByCardListId(int listId) {
        return 2;
    }

    /**
     * TESTING MOCK OBJECT
     * Method for picking up specific test
     * @param wordCount number of words in test
     * @param cardListId Selected List for testing
     * @return specific List of Cards we want to test/practise
     */
    @Override
    public List<Card> pickForTest(int wordCount, int cardListId) {
        List<Card> al = new ArrayList<>();
        Card card1 = new Card(1, 1, "Apple", "Jablko");
        Card card2 = new Card(2, 1, "Pear", "Hruška");
        Card card3 = new Card(3, 2, "Windows", "Okna");
        Card card4 = new Card(4, 1, "Pineapple", "Ananas");
        al.add(card1);
        al.add(card2);
        al.add(card3);
        al.add(card4);
        // TODO Pája review / What should be done in this method
        return al;
    }
}
