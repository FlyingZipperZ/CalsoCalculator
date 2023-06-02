package ClosetCalculator.Panels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static ClosetCalculator.Components.Jlabel.*;
import static ClosetCalculator.Components.JtextField.*;
import static ClosetCalculator.Components.Radios.*;

public class InputsLabelTxt {
    private static void closetInputComponents(GridBagConstraints constraints, JPanel newPanel, JLabel label,
                                              JTextField textField, int xGrid, int yGrid) {
        constraints.gridx = xGrid;
        constraints.gridy = yGrid;
        newPanel.add(label, constraints);
        constraints.gridx = 1;
        newPanel.add(textField, constraints);
    }

    public static JPanel createInputLabelTxt() {
        // JPanel
        JPanel panel = new JPanel(new GridBagLayout());

        // Constraints
        GridBagConstraints constraints = new GridBagConstraints();

        // Labels

        int gridy = 0;

        constraints.insets = new Insets(5, 0, 5, 0);
        constraints.anchor = GridBagConstraints.WEST;



        // add components to the panel
        closetInputComponents(constraints, panel, client, clientTxt,0,gridy++);
        closetInputComponents(constraints, panel, room, roomTxt,0,gridy++);
        closetInputComponents(constraints, panel, color, colorTxt,0,gridy++);
        closetInputComponents(constraints, panel, rodColor, colorRodTxt,0,gridy++);
        rodModTxt.setText("1/4");
        closetInputComponents(constraints, panel, rodMod, rodModTxt,0,gridy++);
        closetInputComponents(constraints, panel, numPiece, numPiecesTxt,0,gridy++);
        closetInputComponents(constraints, panel, width, widthTxt,0,gridy++);
        closetInputComponents(constraints, panel, height, heightTxt,0,gridy++);
        closetInputComponents(constraints, panel, depth, depthTxt,0,gridy++);
        closetInputComponents(constraints, panel, type, typeTxt,0,gridy++);
        closetInputComponents(constraints, panel, numRod, rodsTxt,0,gridy++);
        closetInputComponents(constraints, panel, numShelve, numShelvesTxt,0,gridy++);
        closetInputComponents(constraints, panel, notes, notesTxt,0,gridy++);

        return panel;
    }

    public static void addToTable(JTable jTable, DefaultTableModel dtm) {
        if(numPiecesTxt.getText().isEmpty()) {
            System.out.println("NumPieces is null");
        } else {
            jTable.setGridColor(Color.BLACK);
            String type = typeTxt.getText().trim().toLowerCase();
            boolean top = false;
            if (topYesRadio.isSelected()) {
                top = true;
            } else if (topNoRadio.isSelected()){
                top = false;
            }
            boolean bot = true;
            if (bottomYesRadio.isSelected()) {
                bot = true;
            } else if (bottomNoRadio.isSelected()){
                bot = false;
            }
            dtm.addRow(new Object[]{numPiecesTxt.getText().trim(), widthTxt.getText().trim(),
                    heightTxt.getText().trim(), depthTxt.getText().trim(), type,
                    rodsTxt.getText().trim(), numShelvesTxt.getText().trim(),
                    roomTxt.getText().trim() + "/" + clientTxt.getText().trim(),
                    notesTxt.getText().trim(), colorTxt.getText().trim(), top, bot}
            );

            // Add an unseen panel that holds if that particular cell has a bottom or not

            numPiecesTxt.setText(null);
            widthTxt.setText(null);
            heightTxt.setText(null);
            typeTxt.setText(null);
            rodsTxt.setText(null);
            numShelvesTxt.setText(null);
            notesTxt.setText(null);
        }
    }
}
