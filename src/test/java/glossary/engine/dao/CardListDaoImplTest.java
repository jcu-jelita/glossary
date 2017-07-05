package glossary.engine.dao;

import glossary.engine.model.Card;
import glossary.engine.model.CardList;
import glossary.mock.CardDaoMock;

import java.util.List;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public class CardListDaoImplTest extends DatabaseTestCase {

    public void testFindAll() throws Exception {
        CardDao cardDaoMock = new CardDaoMock();
        CardListDao cardListDao = new CardListDaoImpl(testConnection, cardDaoMock);

        // empty list return 0 results
        assertEquals(0, cardListDao.findAll().size());

        // add new list
        cardListDao.save(new CardList("Test list"), cardDaoMock.findAllByCardListId(1));
        assertEquals(1, cardListDao.findAll().size());
    }

    public void testSave() throws Exception {
        CardDao cardDaoMock = new CardDaoMock();
        List<Card> cards = cardDaoMock.findAllByCardListId(1);
        CardListDao cardListDao = new CardListDaoImpl(testConnection, cardDaoMock);

        // save new list with mock Cards
        CardList cardList = new CardList("Test list");
        assertNotNull(cardListDao.save(cardList, cards));
        assertTrue(cardList.getId() != 0);

        CardList cardList1 = new CardList("");
        assertNull(cardListDao.save(cardList1, cards));

        CardList cardList2 = new CardList("GoT");
        assertNull(cardListDao.save(cardList2, null));

        cardList.setName("New list name");
        int cardListIdOrig = cardList.getId();
        CardList cl = cardListDao.save(cardList, cards);
        assertEquals(cardListIdOrig, cl.getId());
    }

    public void testRemove() throws Exception {
        CardDao cardDaoMock = new CardDaoMock();
        List<Card> cards = cardDaoMock.findAllByCardListId(1);
        CardListDao cardListDao = new CardListDaoImpl(testConnection, cardDaoMock);

        // create new list and remove it
        CardList cl = new CardList("House of Cards");
        cardListDao.save(cl, cards);
        assertTrue(cardListDao.remove(cl.getId()));

        // remove non existing list
        assertFalse(cardListDao.remove(100));
    }


}