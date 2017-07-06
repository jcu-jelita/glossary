package glossary.engine.model;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */

/**
 *  Class Card which represents one Card where are located word and its translation
 */
public class Card {
    /**
     * ID of each Card
     */
    private int id;
    /**
     * ID of List into which this card belong
     */
    private int cardListId;
    /**
     * Word1 which user enters
     */
    private String word1;
    /**
     * Word2 is translation of word1 which user enters
     */
    private String word2;

    /**
     * Constructor of Card
     * @param id ID of this Card
     * @param cardListId ID of List into which this card belong
     * @param word1 user enters
     * @param word2 is translation of word1 which user enters
     */
    public Card(int id, int cardListId, String word1, String word2) {
        this.id = id;
        this.cardListId = cardListId;
        this.word1 = word1;
        this.word2 = word2;
    }

    /**
     * Constructor with only words set - for creation of a new Card
     * @param word1 first word user enters
     * @param word2 is translation of word1 which user enters
     */
    public Card(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
    }

    /**
     * Getter for ID of a Card
     * @return id of a Card
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for ID of a List into this card belongs
     * @return ID of a List into this card belongs
     */
    public int getCardListId() {
        return cardListId;
    }

    /**
     * Getter for first word
     * @return First word user enters
     */
    public String getWord1() {
        return word1;
    }

    /**
     * Getter for second word - translation
     * @return translation of a first word.
     */
    public String getWord2() {
        return word2;
    }

    /**
     * Setter for ID of a List into this card should belong
     * @param cardListId ID of a List we want to this card should belong
     */
    public void setCardListId(int cardListId) {
        this.cardListId = cardListId;
    }

    /**
     * Setter for ID of a card
     * @param id set an ID of a Card
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter for word1
     * @param word1 set a new string for word1
     */
    public void setWord1(String word1) {
        this.word1 = word1;
    }

    /**
     * Setter for word2
     * @param word2 set a new string for word2
     */
    public void setWord2(String word2) {
        this.word2 = word2;
    }
}
