package ClosetCalculator.Frames;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ConverterFrame extends JFrame {

    public ConverterFrame() {
        JPanel panel = new JPanel(new GridBagLayout());

        String[] header = {"MM", "Inch", "Typed in"};
        String[][] data = {
                {"1971", "77.625", "80.125"},
                {"2067", "81 3/8", "84"},
                {"2099", "82 5/8", "85 1/4"},
                {"2131", "84 1/8", "86 1/2"},
                {"2163", "84 1/8", "87 5/8"},
                {"2195", "86 3/8", "89"},
                {"2227", "87 5/8", "90 1/4"},
                {"2259", "89 1/8", "91 1/2"},
                {"2291", "90 3/8", "92 7/8"},
                {"2323", "91 1/2", "94 1/16"},
                {"2355", "92 7/8", "95 1/4"},
                {"2387", "94 1/8", "96 1/2"}};
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

        JScrollPane js = new JScrollPane(jTable);
        js.setPreferredSize(new Dimension(250,275));
        panel.add(js, constraints);
        add(panel);
        pack();
        setTitle("Converter");

        setVisible(true);
    }
}
