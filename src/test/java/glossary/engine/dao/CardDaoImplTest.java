package glossary.engine.dao;

import glossary.engine.model.Card;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public class CardDaoImplTest extends DatabaseTestCase {

    public void testFindAllByCardListId() throws Exception {
        CardDaoImpl cardDao = new CardDaoImpl(testConnection);

        // empty list
        assertEquals(0, cardDao.findAllByCardListId(1).size());

        // one Card in list 1
        Card list1 = new Card("ice", "led");
        list1.setCardListId(1);
        cardDao.save(list1);
        assertEquals(1, cardDao.findAllByCardListId(1).size());

        // add card to differetn list
        Card list2 = new Card("and", "a");
        list2.setCardListId(2);
        cardDao.save(list2);
        assertEquals(1, cardDao.findAllByCardListId(1).size()); // list 1
        assertEquals(1, cardDao.findAllByCardListId(2).size()); // list 2

        // add second card to list 1
        cardDao.save(list1);
        assertEquals(2, cardDao.findAllByCardListId(1).size()); // list 1
        assertEquals(1, cardDao.findAllByCardListId(2).size()); // list 2
    }

    public void testSave() throws Exception {
        CardDaoImpl cardDao = new CardDaoImpl(testConnection);

        // save new Card without CardList.id
        Card card = new Card("ice", "led");
        assertNull(cardDao.save(card));

        // new Card with CardList.id
        card.setCardListId(1);
        assertNotNull(cardDao.save(card));

        // update exiting card;
        card.setWord2("ledovec");
        int origianlId = card.getId();
        cardDao.save(card);
        assertEquals(origianlId, card.getId());

        // empty word1
        Card emptyWord1 = new Card("", "led");
        emptyWord1.setCardListId(1);
        assertNull(cardDao.save(emptyWord1));

        // empty word2
        Card emptyWord2 = new Card("Ice", "");
        emptyWord2.setCardListId(1);
        assertNull(cardDao.save(emptyWord2));
    }

    public void testRemove() throws Exception {
    }

    public void testCountByCardListId() throws Exception {
        CardDaoImpl cardDao = new CardDaoImpl(testConnection);

        assertEquals(0, cardDao.countByCardListId(1));

        Card card = new Card("ice", "led");
        card.setCardListId(1);
        cardDao.save(card);

        assertEquals(1, cardDao.countByCardListId(1));
        assertEquals(0, cardDao.countByCardListId(2));

        Card card2 = new Card("ice", "led");
        card2.setCardListId(1);
        cardDao.save(card2);
        assertEquals(2, cardDao.countByCardListId(1));
        assertEquals(0, cardDao.countByCardListId(2));

    }

    public void testPickForTest() throws Exception {
        CardDaoImpl cardDao = new CardDaoImpl(testConnection);

        // pick from empty list
        assertEquals(0, cardDao.pickForTest(10, 1).size());


        Card card = new Card("ice", "led");
        card.setCardListId(1);
        cardDao.save(card);
        Card card2 = new Card("snow", "snih");
        card2.setCardListId(1);
        cardDao.save(card2);
        Card card3 = new Card("sun", "slunce");
        card3.setCardListId(1);
        cardDao.save(card3);
        //pick one card from list (ID 1) for testing
        assertEquals(1, cardDao.pickForTest(1, 1).size());
        //pick two cards from list (ID 1) for testing
        assertEquals(2, cardDao.pickForTest(2, 1).size());
        //pick three cards from list (ID 1) for testing
        assertEquals(3, cardDao.pickForTest(3, 1).size());
        //pick four cards from list (ID1) for testing - expected 3 only
        assertEquals(3, cardDao.pickForTest(4, 1).size());
    }

}