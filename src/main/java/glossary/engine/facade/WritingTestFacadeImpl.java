package glossary.engine.facade;

import glossary.engine.dao.CardDao;
import glossary.engine.model.Card;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public class WritingTestFacadeImpl implements WritingTestFacade {

    public WritingTestFacadeImpl(int wordCount, int cardListId, CardDao cardDao) {

    }

    @Override
    public Card getNext() {
        return null;
    }

    @Override
    public boolean verify(String answer) {
        return false;
    }

    @Override
    public String getAnswer() {
        return null;
    }

    @Override
    public int getCorrectAnswers() {
        return 0;
    }

    @Override
    public int getWrongAnswers() {
        return 0;
    }

    @Override
    public int getMark() {
        return 0;
    }
}
