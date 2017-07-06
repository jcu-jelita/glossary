package glossary.gui;

import glossary.engine.facade.WritingTestFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Papi on 6. 7. 2017.
 */
public class WritingTestPanel extends JPanel{

    private JTextField translation;
    private JLabel  word;
    public WritingTestPanel(LayoutManager layout) {
        super(layout);
    }

    public void init(){
        word = new JLabel("WORD");
        JLabel lAnswer = new JLabel("Your answer is:");
        translation = new JTextField("CUSTOM TRANSLATION");
        JButton buttonNext = new JButton("Next");
        Dimension dim;
        Rectangle rec;


        dim = new Dimension(400, 150);
        rec = new Rectangle(100, 100, dim.width, dim.height);
        word.setBounds(rec);
        setFontSize(word, dim);

        dim = new Dimension(400, 100);
        rec = new Rectangle(100,300 , dim.width, dim.height);
        setFontSize(lAnswer, dim);
        lAnswer.setBounds(rec);



        dim = new Dimension(400, 100);
        rec = new Rectangle(100, 450, dim.width, dim.height);
        translation.setBounds(rec);
        add(word);
        add(translation);
        add(lAnswer);

        buttonNext.addActionListener((ActionEvent e) -> {

        });
    }

    public void startTest(WritingTestFacade facade){

    }

    private void setFontSize(JLabel label, Dimension labelSize) {
        Font labelFont = label.getFont();
        String labelText = label.getText();
        int componentWidth;
        int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
        if (labelSize == null) {
            componentWidth = label.getWidth();
        } else {
            componentWidth = labelSize.width;
        }
        double widthRatio = (double) componentWidth / (double) stringWidth;
        int newFontSize = (int) (labelFont.getSize() * widthRatio);
        int componentHeight;
        if (labelSize == null) {
            componentHeight = label.getHeight();
        } else {
            componentHeight = labelSize.height;
        }
        int fontSizeToUse = Math.min(newFontSize, componentHeight);
        label.setFont(new Font("ComicSans", Font.PLAIN, fontSizeToUse));
    }
}
