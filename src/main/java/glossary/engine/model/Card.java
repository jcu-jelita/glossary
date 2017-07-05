package glossary.engine.model;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public class Card {
    private int id;
    private int cardList;

    private String word1;
    private String word2;

    public Card(int id, int cardList, String word1, String word2) {
        this.id = id;
        this.cardList = 0;
        this.word1 = word1;
        this.word2 = word2;
    }

    public int getId() {
        return id;
    }

    public int getCardList() {
        return 0;
    }

    public String getWord1() {
        return word1;
    }

    public String getWord2() {
        return word2;
    }
}
