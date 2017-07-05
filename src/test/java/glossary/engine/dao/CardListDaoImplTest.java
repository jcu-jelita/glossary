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
        cardListDao.save(new CardList(0, "Test list"), cardDaoMock.findAllByCardListId(1));
        // TODO call findAll() = expected size = 1 -- CHECK&DELETE ME
        assertEquals(1,cardListDao.findAll().size());

    }

    public void testSave() throws Exception {
        CardDao cardDaoMock = new CardDaoMock();
        List<Card> cards = cardDaoMock.findAllByCardListId(1);
        CardListDao cardListDao = new CardListDaoImpl(testConnection, cardDaoMock);

        // save new list with mock Cards
        CardList cardList = new CardList("Test list");
        assertNotNull(cardListDao.save(cardList, cards));

        // TODO assert carList ID is not NULL -- CHECK&DELETE ME
        assertNotNull(cardList.getId());
        // TODO save new list with "" as second param = expected NULL -- CHECK&DELETE ME
        CardList cardList1 = new CardList("");
        assertNull(cardListDao.save(cardList1, cards)); //Wrong?
        // TODO save new list with NULL on third param = expected NULL -- CHECK&DELETE ME
        // TO CHECK -- Where is the third param?

        cardList.setName("New list name");
        int cardListIdOrig = cardList.getId();
        //TODO save and test if cardList id is same -- CHECK&DELETE ME
        CardList cl = cardListDao.save(cardList, cards);
        assertEquals(cardListIdOrig, cl.getId());

    }

    public void testRemove() throws Exception {
        // TODO create new list and remove it = expected true -- CHECK&DELETE ME
        CardDao cardDaoMock = new CardDaoMock();
        List<Card> cards = cardDaoMock.findAllByCardListId(1);
        CardListDao cardListDao = new CardListDaoImpl(testConnection, cardDaoMock);

        CardList cl = new CardList(5,"House of Cards");
        cardListDao.save(cl,cards);
        assertTrue(cardListDao.remove(5)); // Wrong?
        //TODO try remove non existing list by ID = expected false -- CHECK&DELETE ME
        assertFalse(cardListDao.remove(100));
    }


}