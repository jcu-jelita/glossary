/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glossary.gui;

import glossary.engine.dao.CardListDao;
import glossary.global.CardList;
import glossary.global.TestService;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * @author Papi
 */
public class Frame extends JFrame {

    private final CardListDao cardListDao;
    private final TestService testService;

    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 600;
    private final String CARD_MENU = "menu";
    private final String CARD_CREATE = "create";
    private final String CARD_CHOOSER = "choose";
    private final String CARD_WRITING = "write";
    private final String CARD_PRACTISING = "practise";
    private final String CARD_RESULTS = "result";
    private JPanel jPanel_cards;
    private CardLayout cardLayout;

    public Frame(CardListDao cardListDao, TestService testService) {
        this.testService = testService;
        this.cardListDao = cardListDao;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.yellow);
        setPanels();
    }

    private void setPanels() {
        cardLayout = new CardLayout();
        jPanel_cards = new JPanel(cardLayout);
        jPanel_cards.setBackground(Color.red);
        jPanel_cards.add(createPanelMenu(), CARD_MENU);
        jPanel_cards.add(createPanelCreate(), CARD_CREATE);
        jPanel_cards.add(createPanelChooser(), CARD_CHOOSER);
        jPanel_cards.add(createPanelPractising(), CARD_PRACTISING);
        jPanel_cards.add(createPanelWriting(), CARD_WRITING);
        jPanel_cards.add(createPanelResults(), CARD_RESULTS);
        getContentPane().add(jPanel_cards);
        cardLayout.show(jPanel_cards, CARD_MENU);
    }

    private JPanel createPanelMenu() {
        JPanel panel = new JPanel(null);
        JLabel s_programName = new JLabel("Anki vocabulary");
        JLabel s_list = new JLabel("Custom lists:");
        JButton bt_addList = new JButton("Add list");
        JButton bt_exit = new JButton("Exit");
        JList<CardList> cardNamesList = new JList<>(cardListDao.getLitOverview());
        cardNamesList.setCellRenderer(new CardListRenderer(this));

        JScrollPane sc_List = new JScrollPane(cardNamesList);

        Dimension dim;
        Rectangle rec;

        dim = new Dimension(200, 100);
        rec = new Rectangle(300, 0, dim.width, dim.height);
        s_programName.setBounds(rec);
        setFontSize(s_programName, dim);

        dim = new Dimension(150, 50);
        rec = new Rectangle(100, 50, dim.width, dim.height);
        s_list.setBounds(rec);
        setFontSize(s_list, dim);

        dim = new Dimension(600, 350);
        rec = new Rectangle(100, 100, dim.width, dim.height);
        sc_List.setBounds(rec);

        dim = new Dimension(200, 50);
        rec = new Rectangle(100, 470, dim.width, dim.height);
        bt_addList.setBounds(rec);

        dim = new Dimension(200, 50);
        rec = new Rectangle(500, 470, dim.width, dim.height);
        bt_exit.setBounds(rec);

        panel.add(s_programName);
        panel.add(s_list);
        panel.add(sc_List);
        panel.add(bt_addList);
        panel.add(bt_exit);

        bt_addList.addActionListener((ActionEvent e) -> cardLayout.show(jPanel_cards, CARD_CREATE));

        bt_exit.addActionListener((ActionEvent e) -> System.exit(0));

        return panel;
    }

    private JPanel createPanelCreate() {
        JPanel panel = new JPanel(null);

        Dimension dim;
        Rectangle rec;
        JLabel s_createList = new JLabel("Create new list", SwingConstants.CENTER);
        JLabel s_listName = new JLabel("CardList Name:");
        JTextField tf_listName = new JTextField();
        JTable t_Cards = new JTable();
        JScrollPane sp_Cards = new JScrollPane(t_Cards);
        JButton bt_confirm = new JButton("Confirm");
        JButton bt_cancel = new JButton("Cancel");

        dim = new Dimension(600, 50);
        rec = new Rectangle(100, 0, dim.width, dim.height);
        setFontSize(s_createList, dim);
        s_createList.setBounds(rec);


        dim = new Dimension(200, 50);
        rec = new Rectangle(100, 50, dim.width, dim.height);
        setFontSize(s_listName, dim);
        s_listName.setBounds(rec);

        dim = new Dimension(400, 30);
        rec = new Rectangle(300, 70, dim.width, dim.height);
        tf_listName.setBounds(rec);

        dim = new Dimension(600, 350);
        rec = new Rectangle(100, 100, dim.width, dim.height);
        sp_Cards.setBounds(rec);

        dim = new Dimension(200, 50);
        rec = new Rectangle(100, 470, dim.width, dim.height);
        bt_confirm.setBounds(rec);

        dim = new Dimension(200, 50);
        rec = new Rectangle(500, 470, dim.width, dim.height);
        bt_cancel.setBounds(rec);


        panel.add(s_createList);
        panel.add(s_listName);
        panel.add(tf_listName);
        panel.add(sp_Cards);
        panel.add(bt_confirm);
        panel.add(bt_cancel);

        bt_cancel.addActionListener((ActionEvent e) -> cardLayout.show(jPanel_cards, CARD_MENU));


        return panel;
    }

    private JPanel createPanelPractising() {
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.black);
        return panel;
    }

    private JPanel createPanelChooser() {
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.black);
        return panel;
    }

    private JPanel createPanelWriting() {
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.black);
        return panel;
    }

    private JPanel createPanelResults() {
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.black);
        return panel;
    }

    private void setFontSize(JLabel label, Dimension labelSize) {
        Font labelFont = label.getFont();
        String labelText = label.getText();
        int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth;
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

    protected void startTest() {
    }

    protected void editList() {
    }

    protected void eraseList() {
    }
}
