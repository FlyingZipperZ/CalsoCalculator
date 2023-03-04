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

        Object[] defaultData = {"1","30 15/16","", "12", "s", "1",
                "", "Right/Vernieri", "", "White", false, true};

        Object[] defaultData1 = {"1","30 15/16","", "12", "s", "1",
                "", "Right/Vernieri", "", "Black", false, true};

        Object[] defaultData2 = {"1","24","", "15 7/8", "s", "",
                "", "Right/Vernieri", "", "Orange", false, false};

        Object[] defaultData3 = {"1","24","", "15 7/8", "fx23", "",
                "", "Right/Vernieri", "", "Black", false, false};

        Object[] defaultData4 = {"1","24","", "15 7/8", "s", "",
                "", "Right/Vernieri", "", "Latitude North", false, false};

        Object[] defaultData5 = {"1","24","", "15 7/8", "s", "",
                "", "Right/Vernieri", "", "Latitude East", false, false};

        Object[] defaultData6 = {"1","40 15/16","", "12", "t", "",
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
//        dtm.addRow(defaultData6);
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
