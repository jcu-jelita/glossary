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
        // TODO call findAll() = expected size = 1

    }

    public void testSave() throws Exception {
        CardDao cardDaoMock = new CardDaoMock();
        List<Card> cards = cardDaoMock.findAllByCardListId(1);
        CardListDao cardListDao = new CardListDaoImpl(testConnection, cardDaoMock);

        // save new list with mock Cards
        CardList cardList = new CardList("Test list");
        assertNotNull(cardListDao.save(cardList, cards));
        // TODO assert carList ID is not NULL

        // TODO save new list with "" as second param = expected NULL

        // TODO save new list with NULL on third param = expected NULL


        cardList.setName("New list name");
        int carListIdOrig = cardList.getId();
        //TODO save and test if cardList id is same


    }

    public void testRemove() throws Exception {
        // TODO create new list and remove it = expected true

        //TODO try remove non existing list by ID = expected false
    }


}