package glossary.engine;

import glossary.global.Difficulty;
import glossary.global.PracticeTest;
import glossary.global.WritingTest;

import java.util.HashMap;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public class BasicTest implements PracticeTest, WritingTest {
    HashMap<Integer, String[]> words;
    int pointer;
    int correctAnswers = 0;
    int wrongAnswers = 0;

    @Override
    public String getNext() {
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

    @Override
    public void setDifficulty(Difficulty difficulty) {

    }

    @Override
    public void quit() {

    }
}
