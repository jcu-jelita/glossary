package glossary.gui;

import glossary.engine.GlossaryEngine;
import glossary.engine.facade.WritingTestFacade;
import glossary.engine.model.CardList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Papi on 6. 7. 2017.
 */
public class testSettingsDialog {
    WritingTestFacade facade = null;

    public WritingTestFacade createTest(CardList cardList, GlossaryEngine engine) {

        JLabel title = new JLabel("Setting up new test of "+ cardList.getName());
        JLabel description = new JLabel("Set amount of test questions");
        JTextField wordCountField = new JTextField();
        JButton runWritingTest = new JButton("Run writing");

        runWritingTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = (wordCountField.getText()==null)?"":wordCountField.getText();
                if (!text.isEmpty()){
                    int wordCount = 0;
                    try{
                        wordCount = parseToInt(text);
                    } catch(NumberFormatException ex ){
                        JOptionPane.showMessageDialog(null, "Please set valid number greater than 0");
                        wordCountField.setText("");
                        return;
                    }

                    if (wordCount>0){
                        facade = engine.startWritingTest(wordCount, cardList.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Please set valid number greater than 0");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No number has been given");
                    return;
                }
                JButton button = (JButton) e.getSource();
                SwingUtilities.getWindowAncestor(button).dispose();
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                SwingUtilities.getWindowAncestor(button).dispose();
            }
        });


        JPanel buttons = new JPanel(new BorderLayout());
        buttons.setPreferredSize(new Dimension(200,50));
        buttons.add(runWritingTest,BorderLayout.WEST);
        buttons.add(cancelButton, BorderLayout.EAST);

        JPanel userSettings = new JPanel(null);
        title.setBounds(0,0,300,30);
        userSettings.add(title);
        description.setBounds(0,50,200,30);
        userSettings.add(description);
        wordCountField.setBounds(200,50,50,30);
        userSettings.add(wordCountField);



        JPanel content = new JPanel(new BorderLayout(8, 8));
        content.add(userSettings, BorderLayout.CENTER);
        content.add(buttons, BorderLayout.SOUTH);

        JDialog dialog = new JDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setSize(300,200);
        dialog.setTitle("Setting test");
        dialog.getContentPane().add(content);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        return facade;
    }
    private int parseToInt(String text) throws NumberFormatException{
                  return Integer.parseInt(text);

    }
}