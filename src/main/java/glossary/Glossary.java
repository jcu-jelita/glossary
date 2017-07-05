package glossary;


import glossary.engine.GlossaryEngine;
import glossary.global.exception.DatabaseException;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public class Glossary {

    public static void main(String[] args) {
        try {
            GlossaryEngine engine = new GlossaryEngine();
            //Gui gui = new Gui(engine);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
