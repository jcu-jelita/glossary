package glossary.global;

/**
 * Created by Papi on 4. 7. 2017.
 */
public interface TestService {
    int getWordCount(int listId);
    WritingTest createWritingTest(int wordCount);
    PracticeTest cretePracticeTest(int wordCount);
}
