package glossary.engine.facade;

import glossary.engine.dao.CardDao;
import glossary.mock.CardDaoMock;
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
        assertNull(writingTestFacade.getNext());

        assertTrue(false);
    }

    public void testVerify() throws Exception {
        CardDao cardDao = new CardDaoMock();
        WritingTestFacadeImpl writingTestFacade = new WritingTestFacadeImpl(2, 0, cardDao);
        assertFalse(writingTestFacade.verify(null));

        // curent is null
        assertFalse(writingTestFacade.verify("Ahoj"));

        // move to first card
        writingTestFacade.getNext();
        // TODO
       // assertTrue(writingTestFacade.verify("Ahoj"));
       // assertFalse(writingTestFacade.verify("Voda"));
    }

    public void testGetAnswer() throws Exception {
        assertTrue(false);
    }

    public void testGetCorrectAnswers() throws Exception {
        assertTrue(false);
    }

    public void testGetWrongAnswers() throws Exception {
        assertTrue(false);
    }

    public void testGetMark() throws Exception {
        assertTrue(false);
    }

}