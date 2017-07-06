package glossary.gui;

import glossary.engine.facade.WritingTestFacade;
import glossary.engine.model.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Papi on 6. 7. 2017.
 */
public class WritingTestPanel extends JPanel {

    private final Frame frame;
    private String rightAnswer = "";
    private JTextField translation;
    private JLabel word;
    private JLabel hint;
    private WritingTestFacade facade;

    public WritingTestPanel(LayoutManager layout, Frame frame) {
        super(layout);
        this.frame = frame;
    }


    public void init() {
        word = new JLabel("WORD");
        JLabel lAnswer = new JLabel("Your answer is:");
        translation = new JTextField("CUSTOM TRANSLATION");
        JButton buttonNext = new JButton("Next");
        hint = new JLabel("HINT");
        Dimension dim;
        Rectangle rec;


        dim = new Dimension(400, 100);
        rec = new Rectangle(100, 100, dim.width, dim.height);
        word.setBounds(rec);
        word.setFont(new Font("Arial", Font.BOLD, 30));

        dim = new Dimension(600, 80);
        rec = new Rectangle(100, 240, dim.width, dim.height);
        lAnswer.setFont(new Font("Arial", Font.BOLD, 20));
        lAnswer.setBounds(rec);

        dim = new Dimension(600, 50);
        rec = new Rectangle(100, 350, dim.width, dim.height);
        translation.setBounds(rec);

        dim = new Dimension(200, 80);
        rec = new Rectangle(500, 400, dim.width, dim.height);
        buttonNext.setBounds(rec);

        dim = new Dimension(400, 100);
        rec = new Rectangle(100, 400, dim.width, dim.height);
        hint.setFont(new Font("Arial", Font.BOLD, 15));
        hint.setBounds(rec);


        add(word);
        add(translation);
        add(lAnswer);
        add(buttonNext);
        add(hint);

        hint.setVisible(false);
        buttonNext.addActionListener((ActionEvent e) -> {
            continueTest();
        });
    }

    public void startTest(WritingTestFacade facade) {
        this.facade = facade;
        prepareQuestion();
    }

    public void continueTest() {
        String customAnswer = translation.getText();
        if (hint.isVisible()){
            if (verify(customAnswer, rightAnswer)){
                hint.setVisible(false);
                prepareQuestion();
            }
        } else {
            if (facade.verify(customAnswer)) {
                prepareQuestion();
            } else {
                hint.setText("HINT: " + facade.getAnswer());
                rightAnswer = facade.getAnswer();
                hint.setVisible(true);
            }
        }

    }

    private void prepareQuestion() {
        Card card = facade.getNext();
        if (card == null) {
            finish();
            frame.showMenu();
            return;
        }
        word.setText(card.getWord1());
        translation.setText("");
    }

    private boolean verify(String custom, String right){
        return custom.equals(right);
    }

    private void finish() {
        JOptionPane.showMessageDialog(this, "Your score:\nRight answers: " +
                facade.getCorrectAnswers() + "\nWrong answers: " + facade.getWrongAnswers() +
                "\nYour mark: "+facade.getMark());
    }


}
