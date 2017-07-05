package glossary.engine.service;

import junit.framework.TestCase;

/**
 * Created by LeM on 05.07.2017.
 */
public class TestDAOTest extends TestCase {

    public void testGetWordCount() throws Exception {
        TestDAO testDAO = new TestDAO();

        assertEquals(0, testDAO.getWordCount(-1));

        // TODO vytvořit seznam a ID uložit do idList
        int idList = 1;
        assertEquals(10, testDAO.getWordCount(idList));
    }

    public void testGetRandomWords() throws Exception {
        TestDAO testDAO  = new TestDAO();

        //assertEquals(10, testDAO.getRandomWords(-1));
    }

    public void testCreateWritingTest() throws Exception {
        TestDAO testDAO = new TestDAO();

        //assertEquals(10, testDAO.(-1));

    }

    public void testCretePracticeTest() throws Exception {
        TestDAO testDAO = new TestDAO();

       // assertEquals(testCretePracticeTest(););
    }

}