package ClosetCalculator.Frames;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class LegendFrame extends JFrame {

    public LegendFrame() {
        JPanel panel = new JPanel(new GridBagLayout());

        String[] header = {"Code", "Meaning"};
        String[][] data = {
                {"u", "Upright"},
                {"s", "Shelves"},
                {"r", "Rods"},
                {"b", "Base"},
                {"t", "Top"},
                {"f", "Filler"},
                {"d32", "Drawer Cabinet"},
                {"ds32", "Drawer Box"},
                {"fx23", "Full Extension 23.5"},
                {"fx24", "Full Extension 24.5"},
                {"kar23", "Full Extension 23.5"},
                {"kar24", "Full Extension 24.5"},
                {"vas23", "Full Extension 23.5"},
                {"vas24", "Full Extension 24.5"},};

        JTable jTable = new JTable(data, header){
            public Component prepareRenderer
                    (TableCellRenderer renderer, int Index_row, int Index_col) {
                Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
                //even index, selected or not selected
                if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
                    comp.setBackground(Color.lightGray);
                }
                else {
                    comp.setBackground(Color.white);
                }
                return comp;
            }
        };
        jTable.setEnabled(false);
        setLocationRelativeTo(null);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;

        JLabel client = new JLabel("Type Codes");
        panel.add(client);

        constraints.gridx = 0;
        constraints.gridy = 1;

        JScrollPane js = new JScrollPane(jTable);
        js.setPreferredSize(new Dimension(250,275));
        panel.add(js, constraints);
        add(panel);
        pack();
        setTitle("Legend");
        setVisible(true);
    }
}
