/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glossary.gui;

import glossary.engine.GlossaryEngine;
import glossary.engine.model.Card;
import glossary.engine.model.CardList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author Papi
 */
public class Frame extends JFrame {

    private final GlossaryEngine engine;
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
    private DefaultTableModel dm;
    private JTextField tf_listName;
    private JTable table;

    public Frame(GlossaryEngine engine) {
        this.engine = engine;
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
        JScrollPane sc_List = new JScrollPane(createLibrariesTable());


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

    private JTable createLibrariesTable() {
        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(getDataVector(), new Object[]{"Name", "Run", "Edit", "Delete"});

        JTable table = new JTable(dm);
        table.setShowGrid(false);
        table.setFont(new Font("Arial", Font.BOLD, 40));
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(renderer);
        table.getColumnModel().getColumn(0).setMinWidth(375);
        table.getColumnModel().getColumn(1).setPreferredWidth(75);
        table.getColumnModel().getColumn(2).setPreferredWidth(75);
        table.getColumnModel().getColumn(3).setPreferredWidth(75);
        table.setRowHeight(75);
        table.getColumn("Run").setCellRenderer(new ButtonRenderer());
        table.getColumn("Run").setCellEditor(new ButtonEditor(new JCheckBox(), this));
        table.getColumn("Edit").setCellRenderer(new ButtonRenderer());
        table.getColumn("Delete").setCellRenderer(new ButtonRenderer());
        return table;
    }

    private JPanel createPanelCreate() {
        JPanel panel = new JPanel(null);
        Dimension dim;
        Rectangle rec;
        JLabel s_createList = new JLabel("Create new list", SwingConstants.CENTER);
        JLabel s_listName = new JLabel("List Name:");
        tf_listName = new JTextField();
        dm = new DefaultTableModel();
        table = createLibraryTable(dm);
        JScrollPane spCards = new JScrollPane(table);

        JButton bt_addWord = new JButton("Add new word");
        spCards.add(bt_addWord);
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

        dim = new Dimension(600, 320);
        rec = new Rectangle(100, 100, dim.width, dim.height);
        spCards.setBounds(rec);

        JButton addRow = new JButton("Add new row");
        dim = new Dimension(600, 30);
        rec = new Rectangle(100, 420, dim.width, dim.height);
        addRow.setBounds(rec);

        dim = new Dimension(200, 50);
        rec = new Rectangle(100, 470, dim.width, dim.height);
        bt_confirm.setBounds(rec);

        dim = new Dimension(200, 50);
        rec = new Rectangle(500, 470, dim.width, dim.height);
        bt_cancel.setBounds(rec);


        panel.add(s_createList);
        panel.add(s_listName);
        panel.add(tf_listName);
        panel.add(spCards);
        panel.add(addRow);
        panel.add(bt_confirm);
        panel.add(bt_cancel);

        bt_cancel.addActionListener((ActionEvent e) -> {
            if (dm.getRowCount() > 0 || tf_listName.getText().equals("")) {
                Object[] options = {"Delete",
                        "Cancel"};
                int n = JOptionPane.showOptionDialog(this,
                        "You are about to delete all your changes. Do you want to proceed?",
                        "Delete your changes",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);
                if (n == 1) {
                    return;
                }
            }
            clearPanelCreate();
            cardLayout.show(jPanel_cards, CARD_MENU);
        });
        addRow.addActionListener((ActionEvent e) -> {
            dm.addRow(new Object[]{"", ""});
        });
        bt_confirm.addActionListener((ActionEvent e) -> {
            if (tf_listName.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Library name is empty");
                return;
            }
            CardList cardList = new CardList(tf_listName.getText());
            ArrayList<Card> cards = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            sb.append("Can not save your list\nMissing full pairs:\n");
            boolean missingPairs = false;
            if (dm.getRowCount() > 0) {

                for (int i = 0; i < dm.getRowCount(); i++) {
                    String word = (String) dm.getValueAt(i, 0);
                    String translation = (String) dm.getValueAt(i, 1);
                    System.out.println(word);
                    System.out.println(translation);
                    if (!word.equals("") && !translation.equals("")) {
                        System.out.println("Neprázdný řádek");
                        Card card = new Card(word, translation);
                        cards.add(card);
                    } else {
                        System.out.println("Něco prázdného");
                        if (!(word.equals("")&&translation.equals(""))){
                            System.out.println("Prázdný jen jeden");
                            missingPairs = true;
                            sb.append("Row no. ").append(i+1).append("\n");
                        }

                    }
                }
            }
            if(missingPairs){
                JOptionPane.showMessageDialog(this, sb.toString());
            } else {
               // engine.getCardListDao().save(cardList, cards);
                clearPanelCreate();
            }
        });
        return panel;
    }

    private void clearPanelCreate() {
        dm.setRowCount(0);
        tf_listName.setText("");
    }

    private JTable createLibraryTable(DefaultTableModel dm) {
        dm.setDataVector(new Object[][]{}, new Object[]{"Word", "Translation"});
        JTable table = new JTable(dm);
        table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        return table;


    }

    private JPanel createPanelPractising() {
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.black);
        return panel;
    }

    private JPanel createPanelChooser() {
        JPanel frame = new JPanel(null);
        frame.setBackground(Color.black);
        return frame;
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

    public Object[][] getDataVector() {
        int columnCount = 4;
        java.util.List<CardList> cards = engine.getCardListDao().findAll();
        Object[][] vector = new Object[cards.size()][columnCount];
        for (int i = 0; i < cards.size(); i++) {
            vector[i][0] = cards.get(i).getName();
            vector[i][1] = "run.png";
            vector[i][2] = "edit.png";
            vector[i][3] = "delete.png";
        }

        return vector;

    }
}
