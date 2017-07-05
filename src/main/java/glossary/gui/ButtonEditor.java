package glossary.gui;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Papi on 5. 7. 2017.
 */
public class ButtonEditor extends DefaultCellEditor {

    private Frame frame;
    protected JButton button;
    private String label;
    private int row, column;

    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox, Frame frame) {
        super(checkBox);
        this.frame = frame;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (column){
                    case 1:
                        frame.startTest(row);
                        break;
                    case 2:
                        frame.editList(row);
                        break;
                    case 3:
                        frame.eraseList(row);
                        break;
                }
                fireEditingStopped();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
           button.setBackground(UIManager.getColor("Button.background"));
        }
        try {
            button.setIcon(new ImageIcon(this.getClass().getResource("/Icon/"+(String)value)));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.row = row;
        this.column = column;
        label = (value == null) ? "" : value.toString();
        isPushed = true;
        return button;
    }

    public Object getCellEditorValue() {
        if (isPushed) {
        }
        isPushed = false;
        return new String(label);
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();

    }


}
