package glossary.global;

import glossary.engine.model.Card;

/**
 * Created by Papi on 4. 7. 2017.
 */
public interface WritingTest {
    Card getNext();

    boolean verify(String answer);

    String getAnswer();

    int getCorrectAnswers();

    int getWrongAnswers();

    int getMark();

}
