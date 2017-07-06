package glossary.engine.model;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */

/**
 * Class CardList which represents List of Cards
 */
public class CardList {
    /**
     * unique ID of a CardList
     */
    private int id;
    /**
     * name of CardList, basically topic of all words
     */
    private String name;

    /**
     * Full Constructor for CardList
     * @param id ID of a List
     * @param name Name (Topic) of a List
     */
    public CardList(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Constructor only with name of a List
     * @param name Name (Topic) of a List
     */
    public CardList(String name){
        this.name = name;
    }

    /**
     * Getter of List's ID
     * @return ID of a List
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for List's name
     * @return name of a List
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of ID for a List
     * @param id new ID for a List
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter of name (topic for a List
     * @param name new name (topic) for a List
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Overridden String method toString
     * @return name of a List
     */
    public String toString(){
        return name;
    }
}
