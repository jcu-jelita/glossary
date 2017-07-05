package glossary.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.net.URL;

/**
 * Created by Papi on 5. 7. 2017.
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {




    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
          setForeground(table.getSelectionForeground());
          setBackground(table.getSelectionBackground());
        } else {
          setForeground(table.getForeground());
          setBackground(UIManager.getColor("Button.background"));
        }

        if (hasFocus)
        {
            this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2, true) );
        }
        else
        {
            this.setBorder(null);
        }

        try {
            this.setIcon(new ImageIcon(this.getClass().getResource("/Icon/"+(String)value)));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return this;
    }

    public ButtonRenderer() {
        setOpaque(true);
    }
}
