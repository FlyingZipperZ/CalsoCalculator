package ClosetCalculator.Components;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Table {

    /**
     * @param dtm DefaultTableModel imported to create the table and hold data
     * @param header Header of the JTable
     * @return jTable back to ClosetGUI
     */
    public static JTable getJTable(DefaultTableModel dtm, String[] header) {

        Object[] defaultData = {"4", "", "81.375", "15.875", "u", "",
                "", "BDRM Left/Vera", "2067 mm, Angled", "White", false, true};

        Object[] defaultData1 = {"1", "80.875","", "15.875", "b", "",
                "", "BDRM Left/Vera", "", "PB", false, true};

        Object[] defaultData2 = {"1", "81 1/16", "", "12", "t", "",
                "", "BDRM Left/Vera", "", "White", false, true};

        Object[] defaultData3 = {"6", "24", "", "15 7/8", "s", "",
                "", "BDRM Left/Vera", "Euro", "White", false, true};

        Object[] defaultData4 = {"1", "20", "", "15 7/8", "s", "1",
                "", "BDRM Left/Vera", "", "White", false, true};

        Object[] defaultData5 = {"1", "34 1/16", "", "15 7/8", "s", "2",
                "", "BDRM Left/Vera", "1 euro", "White", false, true};

        Object[] defaultData6 = {"4", "", "81.375", "15.875", "u", "",
                "", "BDRM Right/Vera", "", "White", false, true};

        Object[] defaultData7 = {"1", "76.875", "", "15.875", "b", "",
                "", "BDRM Right/Vera", "", "PB", false, true};

        Object[] defaultData8 = {"1", "77 1/16", "", "12", "t", "",
                "", "BDRM Right/Vera", "Euro", "White", false, true};

        Object[] defaultData9 = {"6", "24", "", "15 7/8", "s", "",
                "", "BDRM Right/Vera", "1 Euro", "White", false, true};

        Object[] defaultData10 = {"1", "18", "", "15 7/8", "s", "1",
                "", "BDRM Right/Vera", "Euro", "White", false, true};

        Object[] defaultData11 = {"1", "32 1/16", "", "15 7/8", "s", "2",
                "", "BDRM Right/Vera", "Euro", "White", false, true};

        Object[] defaultData12 = {"4", "", "81.875", "15 7/8", "u", "",
                "", "Master/Vera", "2067 mm, Angled", "White", false, true};

        Object[] defaultData13 = {"1", "73.875", "", "15.875", "b", "",
                "", "Master/Vera", "Edge 2 Sides", "PB", false, true};

        Object[] defaultData14 = {"1", "74", "", "12", "t", "",
                "", "Master/Vera", "Edge 2 Sides Right", "White", false, true};

        Object[] defaultData15 = {"6", "18", "", "15.875", "b", "",
                "", "Master/Vera", "1 euro", "PB", false, true};

        Object[] defaultData16 = {"1", "24", "", "15.875", "s", "1",
                "", "Master/Vera", "", "White", false, true};

        Object[] defaultData17 = {"1", "29", "", "15.875", "s", "2",
                "", "Master/Vera", "euro", "White", false, true};

        Object[] defaultData18 = {"1", "29 9/16", "", "2.5", "t", "",
                "", "Laundry/1215 Serif", "", "White", false, true};

        Object[] defaultData19 = {"1", "11.125", "", "2.5", "t", "",
                "", "Laundry/1215 Serif", "Fit F Right", "White", false, true};

        Object[] defaultData20 = {"1", "23", "", "2.5", "t", "",
                "", "Laundry/1215 Serif", "Fit M Left", "White", false, true};

        Object[] defaultData21 = {"3","22", "", "15.875", "s", "1",
                "", "Walk/Mongs", "Edge 2 sides Left", "White", false, true};

        JTable jTable = new JTable(dtm) {
            /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };



        dtm.setColumnIdentifiers(header);
//        jTable.setModel(dtm);
        dtm.addRow(defaultData);
        dtm.addRow(defaultData1);
        dtm.addRow(defaultData2);
        dtm.addRow(defaultData3);
        dtm.addRow(defaultData4);
        dtm.addRow(defaultData5);
        dtm.addRow(defaultData6);
        dtm.addRow(defaultData7);
        dtm.addRow(defaultData8);
        dtm.addRow(defaultData9);
        dtm.addRow(defaultData10);
        dtm.addRow(defaultData11);
        dtm.addRow(defaultData12);
        dtm.addRow(defaultData13);
        dtm.addRow(defaultData14);
        dtm.addRow(defaultData15);
        dtm.addRow(defaultData16);
        dtm.addRow(defaultData17);
//        dtm.addRow(defaultData18);
//        dtm.addRow(defaultData19);
//        dtm.addRow(defaultData20);
//        dtm.addRow(defaultData21);
        jTable.getTableHeader().setOpaque(false);
        jTable.getTableHeader().setBackground(Color.ORANGE);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );

        jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        jTable.getColumnModel().getColumn(1).setPreferredWidth(35);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(35);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(35);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        jTable.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        jTable.getColumnModel().getColumn(5).setPreferredWidth(10);
        jTable.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        jTable.getColumnModel().getColumn(6).setPreferredWidth(30);
        jTable.getColumnModel().getColumn(7).setPreferredWidth(90);
        jTable.getColumnModel().getColumn(8).setPreferredWidth(90);
        jTable.getColumnModel().getColumn(9).setPreferredWidth(90);
        jTable.getColumnModel().getColumn(10).setPreferredWidth(10);
        jTable.getColumnModel().getColumn(11).setPreferredWidth(10);

        return jTable;
    }
}
