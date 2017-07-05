package glossary.gui;

import glossary.global.CardList;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Papi on 4. 7. 2017.
 */
public class CardListRenderer implements ListCellRenderer<CardList>{
    Frame frame;

    public CardListRenderer(Frame frame) {
        this.frame = frame;
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends CardList> list, CardList value, int index, boolean isSelected, boolean cellHasFocus) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new JLabel(value.getName()));
        JButton startTest = new JButton("Test");
        JButton editList = new JButton("Edit");
        JButton eraseList = new JButton("Erase");

        panel.add(startTest);
        panel.add(editList);
        panel.add(eraseList);

        startTest.addActionListener(e -> frame.startTest());
        editList.addActionListener(e-> frame.editList());
        eraseList.addActionListener(e-> frame.eraseList());
        return panel;
    }
}
