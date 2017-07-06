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
        assertEquals(1, writingTestFacade.getNext().getId());
        assertEquals(2, writingTestFacade.getNext().getId());
        assertNull(writingTestFacade.getNext());
    }

    public void testVerify() throws Exception {
        CardDao cardDao = new CardDaoMock();
        WritingTestFacadeImpl writingTestFacade = new WritingTestFacadeImpl(2, 2, cardDao);
        assertFalse(writingTestFacade.verify(null));

        // curent is null
        assertFalse(writingTestFacade.verify("translated_0"));

        // move to first card
        writingTestFacade.getNext();
        assertFalse(writingTestFacade.verify("word_0"));
        assertTrue(writingTestFacade.verify("translated_0"));
        assertTrue(writingTestFacade.verify("TRANSLATED_0"));

        writingTestFacade.getNext();
        assertFalse(writingTestFacade.verify("translated_0"));
        assertTrue(writingTestFacade.verify("translated_1"));
    }

    public void testGetAnswer() throws Exception {
        CardDao cardDao = new CardDaoMock();
        WritingTestFacadeImpl writingTestFacade = new WritingTestFacadeImpl(1, 2, cardDao);

        try {
            writingTestFacade.getAnswer();
            fail("expected: " + NullPointerException.class);
        } catch (NullPointerException e) {

        }

        writingTestFacade.getNext();
        assertEquals("translated_0", writingTestFacade.getAnswer());

        writingTestFacade.getNext();
        try {
            writingTestFacade.getAnswer();
            fail("expected: " + NullPointerException.class);
        } catch (NullPointerException e) {

        }

    }

    public void testGetCorrectAnswers() throws Exception {
        CardDao cardDao = new CardDaoMock();
        WritingTestFacadeImpl writingTestFacade = new WritingTestFacadeImpl(2, 2, cardDao);

        assertEquals(0, writingTestFacade.getCorrectAnswers());

        writingTestFacade.getNext();
        writingTestFacade.verify("bad answer");
        assertEquals(0, writingTestFacade.getCorrectAnswers());

        writingTestFacade.verify("translated_0");
        assertEquals(1, writingTestFacade.getCorrectAnswers());
    }

    public void testGetWrongAnswers() throws Exception {
        CardDao cardDao = new CardDaoMock();
        WritingTestFacadeImpl writingTestFacade = new WritingTestFacadeImpl(2, 2, cardDao);

        assertEquals(0, writingTestFacade.getWrongAnswers());

        writingTestFacade.getNext();

        writingTestFacade.verify("wrong answer");
        assertEquals(1, writingTestFacade.getWrongAnswers());

        writingTestFacade.verify("translated_0");
        assertEquals(1, writingTestFacade.getWrongAnswers());
    }

    public void testGetMark() throws Exception {
        CardDao cardDao = new CardDaoMock();
        WritingTestFacadeImpl writingTestFacade = new WritingTestFacadeImpl(2, 2, cardDao);
        assertEquals(5, writingTestFacade.getMark());

        writingTestFacade.getNext();
        writingTestFacade.verify("translated_0");
        assertEquals(1, writingTestFacade.getMark()); // 100%

        // Test >30% = 4
        writingTestFacade = new WritingTestFacadeImpl(2, 2, cardDao);
        writingTestFacade.getNext();
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("bad answer");
        writingTestFacade.verify("bad answer");
        writingTestFacade.verify("bad answer");
        writingTestFacade.verify("bad answer");
        writingTestFacade.verify("bad answer");
        writingTestFacade.verify("bad answer");
        writingTestFacade.verify("bad answer");
        assertEquals(5, writingTestFacade.getMark()); // 30%
        writingTestFacade.verify("translated_0");
        assertEquals(4, writingTestFacade.getMark()); // >30%

        // Test >50% = 3
        writingTestFacade = new WritingTestFacadeImpl(2, 2, cardDao);
        writingTestFacade.getNext();
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("bad answer");
        assertEquals(4, writingTestFacade.getMark()); // 50%
        writingTestFacade.verify("translated_0");
        assertEquals(3, writingTestFacade.getMark()); // >50%

        // Test >80% = 2
        writingTestFacade = new WritingTestFacadeImpl(2, 2, cardDao);
        writingTestFacade.getNext();
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("bad answer");
        assertEquals(3, writingTestFacade.getMark()); // 80%
        writingTestFacade.verify("translated_0");
        assertEquals(2, writingTestFacade.getMark()); // >80%

        // Test >90% = 1
        writingTestFacade = new WritingTestFacadeImpl(2, 2, cardDao);
        writingTestFacade.getNext();
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("translated_0");
        writingTestFacade.verify("bad answer");
        assertEquals(2, writingTestFacade.getMark()); // 90%
        writingTestFacade.verify("translated_0");
        assertEquals(1, writingTestFacade.getMark()); // >90%
    }

}