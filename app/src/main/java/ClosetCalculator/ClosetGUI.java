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
import javax.swing.table.DefaultTableModel;

import static ClosetCalculator.Components.Buttons.*;
import static ClosetCalculator.Components.JtextField.*;
import static ClosetCalculator.Components.Table.getJTable;

public class ClosetGUI extends JFrame {
    public ClosetGUI() {
//        List da = new ArrayList();
        String[] header = {"Pieces", "Width", "Height", "Depth", "Type", "Rod", "No. Shel",
                "Client", "Notes", "Color", "Top", "Bot"};

        // Create JTable to allow data to flow through the app
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        JTable jTable = getJTable(dtm, header);

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
                boolean slashCheck = false;
                if (widthTxt.getText().contains(" ") ) {
                    if (!widthTxt.getText().contains("/")) {
                        JOptionPane.showMessageDialog(null, "Missing Width Slash");
                        slashCheck = true;
                    }
                } else if (heightTxt.getText().contains(" ")) {
                    if (!heightTxt.getText().contains("/")) {
                        JOptionPane.showMessageDialog(null, "Missing Height Slash");
                        slashCheck = true;
                    }
                } else if (depthTxt.getText().contains(" ")) {
                    System.out.println("Running?");
                    if (!depthTxt.getText().contains("/")) {
                        JOptionPane.showMessageDialog(null, "Missing Depth Slash");
                        slashCheck = true;
                    }
                }
                if (!slashCheck) {
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
                    }
                    // Shelves
                    else if (Objects.equals(type, "s") || Objects.equals(type, "t")) {
                        if (widthTxt.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Width is empty");
                        } else if (depthTxt.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Depth is empty");
                        } else {

                            InputsLabelTxt.addToTable(jTable, dtm);
                        }
                    } else if (Objects.equals(type, "ds32") || Objects.equals(type, "d32")) {
                        if (widthTxt.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Width is empty");
                        } else if (heightTxt.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Height is empty");
                        } else if (depthTxt.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Depth is empty");
                        } else {
                            InputsLabelTxt.addToTable(jTable, dtm);
                        }
                    } else if (Objects.equals(type, "fx23") ||
                            Objects.equals(type, "fx24") ||
                            Objects.equals(type, "kar23") ||
                            Objects.equals(type, "kar24") ||
                            Objects.equals(type, "vas23") ||
                            Objects.equals(type, "vas24")) {
                        if (widthTxt.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Width is empty");
                        } else if (depthTxt.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Depth is empty");
                        } else {
                            InputsLabelTxt.addToTable(jTable, dtm);
                        }
                    } else if (Objects.equals(type, "f")) {
                        if (heightTxt.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Height is empty");
                        } else if (widthTxt.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Width is empty");
                        } else {
                            InputsLabelTxt.addToTable(jTable, dtm);
                        }
                    } else if (Objects.equals(type, "r")) {
                        if (widthTxt.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Width is empty");
                        } else {
                            InputsLabelTxt.addToTable(jTable, dtm);
                        }
                    } else if (Objects.equals(type, "b")) {
                        if (depthTxt.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Depth is empty");
                        } else if (widthTxt.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Width is empty");
                        } else {
                            InputsLabelTxt.addToTable(jTable, dtm);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Type");
                    }
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
