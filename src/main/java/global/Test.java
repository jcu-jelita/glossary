package global;

/**
 * Created by Papi on 4. 7. 2017.
 */
public interface Test {
    String getNext();

    boolean verify(String answer);

    String getAnswer();

    int getCorrectAnswers();

    int getWrongAnswers();

    int getMark();

}
