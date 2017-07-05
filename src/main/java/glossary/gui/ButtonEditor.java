package glossary.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Papi on 5. 7. 2017.
 */
public class ButtonEditor extends DefaultCellEditor {

    private Frame frame;
    protected JButton button;


    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox, Frame frame) {
        super(checkBox);
        this.frame = frame;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        isPushed = true;
        return button;
    }

    public Object getCellEditorValue() {
        if (isPushed) {
            //TO DO here
            //An action can be written here
        }
        isPushed = false;
        return "";
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();
        System.out.println("FireEdditingStopped");
    }


}
