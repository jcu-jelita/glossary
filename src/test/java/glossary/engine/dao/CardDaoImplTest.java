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
    }

    public void testRemove() throws Exception {
    }

    public void testCountByCardListId() throws Exception {
    }

    public void testPickForTest() throws Exception {
    }

}