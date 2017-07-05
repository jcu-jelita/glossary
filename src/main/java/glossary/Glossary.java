package glossary;


import glossary.engine.GlossaryEngine;
import glossary.global.exception.DatabaseException;
import glossary.gui.Frame;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public class Glossary {

    public static void main(String[] args) {
        try {
            GlossaryEngine engine = new GlossaryEngine();
            Frame frame = new Frame(engine);
            frame.setVisible(true);
            engine.close();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
