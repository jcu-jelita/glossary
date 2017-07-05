package glossary.engine.facade;

import glossary.engine.dao.CardDao;
import glossary.engine.model.Card;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public class WritingTestFacadeImpl implements WritingTestFacade {


    private List<Card> cards;
    private ListIterator<Card> iterator;

    private Card current;

    private int correctAnswers = 0;
    private int incorrectAnswers = 0;

    public WritingTestFacadeImpl(int wordCount, int cardListId, CardDao cardDao) {
        cards = cardDao.pickForTest(wordCount, cardListId);
        iterator = cards.listIterator();
    }

    @Override
    public Card getNext() {
        if (iterator.hasNext()) {
            current = iterator.next();
        } else {
            current = null;
        }
        return current;
    }

    @Override
    public boolean verify(String answer) {
        if (current == null) {
            return false;
        }

        boolean status = current.getWord2().equals(answer);
        if (status) {
            correctAnswers++;
        } else {
            incorrectAnswers++;
        }
        return status;
    }

    @Override
    public String getAnswer() {
        return current.getWord2();
    }

    @Override
    public int getCorrectAnswers() {
        return correctAnswers;
    }

    @Override
    public int getWrongAnswers() {
        return incorrectAnswers;
    }

    @Override
    public int getMark() {
        double percent = cards.size() / correctAnswers * 100;
        if (percent > 90) {
            return 1;
        } else if (percent > 75) {
            return 2;
        } else if (percent > 50) {
            return 3;
        } else if (percent > 30) {
            return 4;
        } else {
            return 5;
        }
    }
}
