package glossary;


import glossary.engine.GlossaryEngine;
import glossary.engine.service.DatabaseService;
import glossary.global.CardList;

import java.util.HashMap;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public class Glossary {

    public static void main(String[] args) {
        GlossaryEngine engine = new GlossaryEngine();

        engine.getListService().getLitOverview();

      /*  HashMap<Integer, String[]> words = new HashMap<>();
        words.put(0, new String[]{"Ice", "Led"});
        words.put(1, new String[]{"and", "a"});
        words.put(2, new String[]{"Fire", "ohěň"});

        CardList cardList = new CardList(0, "Test", words);
        engine.getListService().save(cardList);*/

        //Gui gui = new Gui(engine.getListService(), engine.getTestService());

        engine.close();
    }
}
