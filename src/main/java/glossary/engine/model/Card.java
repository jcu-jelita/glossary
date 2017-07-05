package glossary.engine.model;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public class Card {
    private int id;
    private CardList cardList;

    private String word1;
    private String word2;

    public int getId() {
        return id;
    }

    public CardList getCardList() {
        return cardList;
    }

    public String getWord1() {
        return word1;
    }

    public String getWord2() {
        return word2;
    }
}
