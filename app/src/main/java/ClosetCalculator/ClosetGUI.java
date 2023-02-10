package ClosetCalculator;

import ClosetCalculator.Panels.*;
import ClosetCalculator.Frames.ConverterFrame;
import ClosetCalculator.Frames.LegendFrame;

import javax.swing.*;
import java.awt.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import static ClosetCalculator.Components.Buttons.*;
import static ClosetCalculator.Components.JtextField.*;

public class ClosetGUI extends JFrame {
    public ClosetGUI() {
        String[] header = {"No. Pieces","Width","Height", "Depth", "Type", "No. Rods", "No. Shel",
                "Shel Dep", "Client", "Notes", "Color"};

        String[] defaultData1 = {"7","","90 1/2", "15 7/8", "u", "", "",
                "", "Left/Vernieri", "CNC", "White"};

        String[] defaultData2 = {"3","","80 1/2", "15 7/8", "u", "", "",
                "", "Right/Vernieri", "CNC", "White"};

        String[] defaultData3 = {"1","65 7/8","", "15 7/8", "t", "", "",
                "", "Right/Vernieri", "", "White"};

        String[] defaultData4 = {"1","40 15/16","", "12", "s", "1", "",
                "", "Right/Vernieri", "", "White"};

        String[] defaultData5 = {"1","24","", "15 7/8", "fx23", "", "",
                "", "Master/Vernieri", "", "White"};

        String[] defaultData6 = {"1","24","", "15 7/8", "kar23", "", "",
                "", "Master/Vernieri", "", "White"};

        String[] defaultData7 = {"2","24","8 3/4", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        String[] defaultData8 = {"2","24","7 1/2", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        String[] defaultData9 = {"2","23","6 1/4", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        String[] defaultData10 = {"2","24","5", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        String[] defaultData11 = {"2","24","10", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        String[] defaultData12 = {"2","23","8 3/4", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        String[] defaultData13 = {"2","23","7 1/2", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        String[] defaultData14 = {"2","24","6 1/4", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        String[] defaultData15 = {"2","23","5", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};

        String[] defaultData16 = {"2","23","10", "16", "ds23", "", "",
                "", "Test/Vernieri", "", "White"};


        // Create JTable to allow data to flow through the app
        JTable jTable = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        dtm.setColumnIdentifiers(header);
        jTable.setModel(dtm);
//        dtm.addRow(defaultData1);
//        dtm.addRow(defaultData2);
//        dtm.addRow(defaultData3);
//        dtm.addRow(defaultData4);
//        dtm.addRow(defaultData5);
//        dtm.addRow(defaultData6);
        dtm.addRow(defaultData7);
        dtm.addRow(defaultData8);
//        dtm.addRow(defaultData9);
//        dtm.addRow(defaultData10);
//        dtm.addRow(defaultData11);
//        dtm.addRow(defaultData12);
//        dtm.addRow(defaultData13);
//        dtm.addRow(defaultData14);
//        dtm.addRow(defaultData15);
//        dtm.addRow(defaultData16);
        jTable.getTableHeader().setOpaque(false);
        jTable.getTableHeader().setBackground(Color.ORANGE);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );

        jTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        jTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTable.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        jTable.getColumnModel().getColumn(5).setPreferredWidth(30);
        jTable.getColumnModel().getColumn(6).setPreferredWidth(30);
        jTable.getColumnModel().getColumn(7).setPreferredWidth(30);
        jTable.getColumnModel().getColumn(8).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(9).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(10).setPreferredWidth(100);

        // Main Panel the houses everything
        JPanel mainPanel = new JPanel(new GridBagLayout());
        setMinimumSize(new Dimension(1200, 825));
        JLabel topLabel = new JLabel("Closet Calculator");
        topLabel.setFont(new Font("Droid Sans Mono", Font.PLAIN, 20));

        // Main Constraints that move everything around
        GridBagConstraints mainConstraints = new GridBagConstraints();
        mainConstraints.anchor = GridBagConstraints.CENTER;
        mainConstraints.insets = new Insets(10, 10, 10, 10);
        mainConstraints.gridx = 0;
        mainConstraints.gridy = 0;
        mainPanel.add(topLabel, mainConstraints);

        // create a new panel with GridBagLayout manager
        mainConstraints.gridx = 0;
        mainConstraints.gridy = 1;
        mainPanel.add(InputPanel.createInputPanel(), mainConstraints);

        // Calculate, legend and file director
        mainConstraints.gridx = 1;
        mainConstraints.gridy = 0;
        mainPanel.add(TopButtons.createTopPanel(), mainConstraints);

        mainConstraints.gridx = 1;
        mainConstraints.gridy = 1;
        mainConstraints.insets = new Insets(600,10,10,10);
        mainPanel.add(BottomPanel.createCalculateButton(), mainConstraints);


        // JTable add
        JScrollPane js = new JScrollPane(jTable);
        js.setPreferredSize(new Dimension(800,600));
        mainConstraints.gridx = 1;
        mainConstraints.gridy = 0;
        mainConstraints.gridheight = 4;
        mainConstraints.insets = new Insets(10,10,10,10);
        mainPanel.add(js, mainConstraints);

        // add the panel to this frame
        add(mainPanel);
        setTitle("Closet Calculator");

        pack();
        setLocationRelativeTo(null);

        ADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = typeTxt.getText().trim().toLowerCase();
                if (numPiecesTxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Number of pieces is empty");
                } else if (typeTxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No Type detected");
                } else if (Objects.equals(type, "u")) {
                    if (heightTxt.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Height is empty");
                    } else if (depthTxt.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Depth is empty");
                    } else {
                        InputsLabelTxt.addToTable(jTable, dtm);
                    }
                } else if (Objects.equals(type, "s") || Objects.equals(type, "t")) {
                    if (widthTxt.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Width is empty");
                    } else if (depthTxt.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Depth is empty");
                    } else {
                        InputsLabelTxt.addToTable(jTable, dtm);
                    }
                } else if (Objects.equals(type, "ds23") || Objects.equals(type, "ds24")) {
                    if (widthTxt.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Width is empty");
                    } else if (heightTxt.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Height is empty");
                    }else if (depthTxt.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Depth is empty");
                    } else {
                        InputsLabelTxt.addToTable(jTable, dtm);
                    }
                } else if (Objects.equals(type, "fx23") ||
                        Objects.equals(type, "fx24") ||
                        Objects.equals(type, "kar23") ||
                        Objects.equals(type, "kar24")) {
                    if (widthTxt.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Width is empty");
                    } else if (depthTxt.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Depth is empty");
                    } else {
                        InputsLabelTxt.addToTable(jTable, dtm);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Type");
                }
            }
        });

        DELETE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jTable.getSelectedRow() != -1) {
                    // remove selected row from the model
                    dtm.removeRow(jTable.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while(dtm.getRowCount() > 0)
                {
                    dtm.removeRow(0);
                }
            }
        });

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count= jTable.getModel().getRowCount();
                if (count !=0) {
                    CalculateClosets.calculate(dtm);
                } else {
                    JOptionPane.showMessageDialog(null, "Table is empty");
                }
            }
        });

        legend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LegendFrame();
            }
        });

        codes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConverterFrame();
            }
        });
    }
}
