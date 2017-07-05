package glossary;


import glossary.engine.GlossaryEngine;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public class Glossary {

    public static void main(String[] args) {
        GlossaryEngine engine = new GlossaryEngine();

        engine.getCardListDao().getLitOverview();

       // Gui gui = new Gui(engine.getCardListDao(), engine.getTestService());

        engine.close();
    }
}
