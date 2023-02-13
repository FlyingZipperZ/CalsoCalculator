package examples;

import javax.swing.*;
import javax.swing.table.*;

public class TableCheckBox extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;

    public TableCheckBox() {
        Object[] columnNames = {"Type", "Company", "Shares", "Price", "Boolean"};
        Object[][] data = {
                {"Buy", "IBM", 1000, 80.50, false},
                {"Sell", "MicroSoft", 2000, 6.25, true},
                {"Sell", "Apple", 3000, 7.35, true},
                {"Buy", "Nortel", 4000, 20.00, false}
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model) {

            private static final long serialVersionUID = 1L;

            /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Integer.class;
                    case 3:
                        return Double.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                TableCheckBox frame = new TableCheckBox();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocation(150, 150);
                frame.setVisible(true);
            }
        });
    }
}