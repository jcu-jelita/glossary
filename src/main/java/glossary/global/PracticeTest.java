package glossary.global;

import glossary.engine.model.Card;

/**
 * Created by Papi on 4. 7. 2017.
 */
public interface PracticeTest {

    Card getNext();
    void setDifficulty(Difficulty difficulty);
    void quit();
}
