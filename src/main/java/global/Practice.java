package global;

/**
 * Created by Papi on 4. 7. 2017.
 */
public interface Practice {
    String getNext();
    String getAnswer();
    void setDifficulty(Difficulty difficulty);
    void quit();
}
