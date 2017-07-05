package glossary.engine.facade;

import glossary.engine.dao.CardDao;
import glossary.engine.dao.CardDaoMock;
import glossary.engine.model.Card;
import junit.framework.TestCase;

/**
 * Created by LeM on 05.07.2017.
 */
public class WritingTestFacadeImplTest extends TestCase {
    public void testGetNext() throws Exception {
        CardDao cardDao = new CardDaoMock();
        WritingTestFacadeImpl writingTestFacade = new WritingTestFacadeImpl(2, 0, cardDao);
        assertEquals(1,writingTestFacade.getNext().getId());
        assertEquals(2,writingTestFacade.getNext().getId());
        assertEquals(3,writingTestFacade.getNext().getId());
        assertEquals(4,writingTestFacade.getNext().getId());
        assertNotNull(writingTestFacade.getNext());

    }

    public void testVerify() throws Exception {

    }

    public void testGetAnswer() throws Exception {

    }

    public void testGetCorrectAnswers() throws Exception {

    }

    public void testGetWrongAnswers() throws Exception {

    }

    public void testGetMark() throws Exception {

    }

}