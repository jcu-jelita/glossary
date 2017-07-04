package glossary.global;

import java.util.HashMap;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public class CardList {

    private int id;
    private String name;
    private HashMap<Integer, String[]> wordMap;

    public CardList(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CardList(int id, String name, HashMap<Integer, String[]> wordMap) {
        this.id = id;
        this.name = name;
        this.wordMap = wordMap;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<Integer, String[]> getWordMap() {
        return wordMap;
    }
}
