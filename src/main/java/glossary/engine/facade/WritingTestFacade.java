package glossary.engine.facade;

import glossary.engine.model.Card;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public interface WritingTestFacade {

    /**
     * Get next Card for testing
     *
     * @return NULL if there is no Card for testing
     */
    Card getNext();

    /**
     * Check if answer is correct
     *
     * @param answer User answer to compare agains Card translation
     * @return true if word2 match word1
     */
    boolean verify(String answer) throws NullPointerException;

    /**
     * @return Correct answer for current card
     */
    String getAnswer() throws NullPointerException;

    /**
     * @return number of correct answers
     */
    int getCorrectAnswers();

    /**
     * @return number of incorrect answers
     */
    int getWrongAnswers();

    /**
     * @return return mark by percetige of succes over 90% is 1; 80% is 2; 50% = 3; 30% = 4; otherwise 5
     */
    int getMark();
}
