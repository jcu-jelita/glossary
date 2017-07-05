package glossary.engine.service;

import glossary.global.PracticeTest;
import glossary.global.WritingTest;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public class TestDAO implements glossary.global.TestService {
    @Override
    public int getWordCount(int listId) {
        return 0;
    }

    protected void getRandomWords(int listId){

    }

    @Override
    public WritingTest createWritingTest(int listId, int wordCount) {
        getRandomWords(listId);
        return null;
    }

    @Override
    public PracticeTest cretePracticeTest(int listId, int wordCount) {
        getRandomWords(listId);
        return null;
    }
}
