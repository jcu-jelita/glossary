package glossary.engine.facade;

import glossary.engine.model.Card;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public interface WritingTestFacade {

    Card getNext();

    boolean verify(String answer);

    String getAnswer();

    int getCorrectAnswers();

    int getWrongAnswers();

    int getMark();
}
