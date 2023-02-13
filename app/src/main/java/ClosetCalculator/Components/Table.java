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

        Object [] defaultData1 = {"7","","90.5", "15.875", "u", "", "",
                "", "Left/Vernieri", "CNC", "White"};

        Object[] defaultData2 = {"3","","80 1/2", "15 7/8", "u", "", "",
                "", "Right/Vernieri", "CNC", "White"};

        Object[] defaultData3 = {"1","65 7/8","", "15 7/8", "t", "", "",
                "", "Right/Vernieri", "", "White"};

        Object[] defaultData4 = {"1","40 15/16","", "12", "s", "1",
                "", "Right/Vernieri", "", "White", false, true};

        Object[] defaultData5 = {"1","40 15/16","", "12", "fx23", "",
                "", "Right/Vernieri", "", "White", false, true};

        Object[] defaultData6 = {"1","24","6.25", "15.875", "ds23", "", "",
                "", "Master/Vernieri", "", "White"};

        Object[] defaultData7 = {"2","24","8 3/4", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        Object[] defaultData8 = {"2","24","7 1/2", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        Object[] defaultData9 = {"2","23","6 1/4", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        Object[] defaultData10 = {"2","24","5", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        Object[] defaultData11 = {"2","24","10", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        Object[] defaultData12 = {"2","23","8 3/4", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        Object[] defaultData13 = {"2","23","7 1/2", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        Object[] defaultData14 = {"2","24","6 1/4", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        Object[] defaultData15 = {"2","23","5", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        Object[] defaultData16 = {"1","24","6.25", "15 7/8", "ds23", "",
                "", "Right/Vernieri", "", "White", false, false};
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
//                    case 10:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };



        dtm.setColumnIdentifiers(header);
//        jTable.setModel(dtm);
//        dtm.addRow(defaultData1);
//        dtm.addRow(defaultData2);
//        dtm.addRow(defaultData3);
//        dtm.addRow(defaultData4);
//        dtm.addRow(defaultData5);
//        dtm.addRow(defaultData6);
//        dtm.addRow(defaultData7);
//        dtm.addRow(defaultData8);
//        dtm.addRow(defaultData9);
//        dtm.addRow(defaultData10);
//        dtm.addRow(defaultData11);
//        dtm.addRow(defaultData12);
//        dtm.addRow(defaultData13);
//        dtm.addRow(defaultData14);
//        dtm.addRow(defaultData15);
        dtm.addRow(defaultData16);
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
