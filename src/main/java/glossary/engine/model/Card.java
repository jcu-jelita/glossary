package glossary.engine.model;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public class Card {
    private int id;
    private int cardListId;

    private String word1;
    private String word2;

    public Card(int id, int cardListId, String word1, String word2) {
        this.id = id;
        this.cardListId = cardListId;
        this.word1 = word1;
        this.word2 = word2;
    }

    public Card(String word1, String word2){
        this.word1 = word1;
        this.word2 = word2;
    }

    public int getId() {
        return id;
    }

    public int getCardListId() {
        return cardListId;
    }

    public String getWord1() {
        return word1;
    }

    public String getWord2() {
        return word2;
    }
}
