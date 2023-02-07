package ClosetCalculator.Panels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InputsLabelTxt {

    static int column = 5;

    // TextField
    static JTextField clientTxt = new JTextField(15);
    public static JTextField colorTxt = new JTextField(15);
    public static JTextField colorRodTxt = new JTextField(15);
    static JTextField roomTxt = new JTextField(15);
    public static JTextField rodModTxt = new JTextField(column);
    public static JTextField numPiecesTxt = new JTextField(column);
    public static JTextField widthTxt = new JTextField(column);
    public static JTextField heightTxt = new JTextField(column);
    public static JTextField depthTxt = new JTextField(column);
    public static JTextField typeTxt = new JTextField(column);
    public static JTextField rodsTxt = new JTextField(column);
    static JTextField numShelvesTxt = new JTextField(column);
    static JTextField shelveDepthTxt = new JTextField(column);
    static JTextField notesTxt = new JTextField(15);


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
        JLabel client = new JLabel("Client: ");
        JLabel color = new JLabel("Color: ");
        JLabel rodColor = new JLabel("Rod Color: ");
        JLabel room = new JLabel("Room: ");
        JLabel rodMod = new JLabel("Rods Modifier: ");
        JLabel numPiece = new JLabel("# Pieces: ");
        JLabel height = new JLabel("Height: ");
        JLabel width = new JLabel("Width: ");
        JLabel depth = new JLabel("Depth: ");
        JLabel type = new JLabel("Type: ");
        JLabel numRod = new JLabel("# Rods: ");
        JLabel numShelve = new JLabel("# Shelves: ");
        JLabel shelveDepth = new JLabel("Shelves Depth: ");
        JLabel notes = new JLabel("Notes: ");

        int gridy = 0;

        constraints.insets = new Insets(5, 0, 5, 0);
        constraints.anchor = GridBagConstraints.WEST;
        // add components to the panel
        closetInputComponents(constraints, panel, client, clientTxt,0,gridy++);
        closetInputComponents(constraints, panel, room, roomTxt,0,gridy++);
        closetInputComponents(constraints, panel, color, colorTxt,0,gridy++);
        closetInputComponents(constraints, panel, rodColor, colorRodTxt,0,gridy++);
        closetInputComponents(constraints, panel, rodMod, rodModTxt,0,gridy++);
        closetInputComponents(constraints, panel, numPiece, numPiecesTxt,0,gridy++);
        closetInputComponents(constraints, panel, width, widthTxt,0,gridy++);
        closetInputComponents(constraints, panel, height, heightTxt,0,gridy++);
        closetInputComponents(constraints, panel, depth, depthTxt,0,gridy++);
        closetInputComponents(constraints, panel, type, typeTxt,0,gridy++);
        closetInputComponents(constraints, panel, numRod, rodsTxt,0,gridy++);
        closetInputComponents(constraints, panel, numShelve, numShelvesTxt,0,gridy++);
        closetInputComponents(constraints, panel, shelveDepth, shelveDepthTxt,0,gridy++);
        closetInputComponents(constraints, panel, notes, notesTxt,0,gridy++);

        return panel;
    }

    public static void addToTable(JTable jTable, DefaultTableModel dtm) {
        if(numPiecesTxt.getText().isEmpty()) {
            System.out.println("NumPieces is null");
        } else {
            jTable.setGridColor(Color.BLACK);
            String type = typeTxt.getText().trim().toLowerCase();
            dtm.addRow(new Object[]{numPiecesTxt.getText().trim(), widthTxt.getText().trim(),
                    heightTxt.getText().trim(), depthTxt.getText().trim(), type,
                    rodsTxt.getText().trim(), numShelvesTxt.getText().trim(), shelveDepthTxt.getText().trim(),
                    roomTxt.getText().trim() + "/" + clientTxt.getText().trim(),
                    notesTxt.getText().trim(), colorTxt.getText().trim()}
            );
            numPiecesTxt.setText(null);
            widthTxt.setText(null);
            heightTxt.setText(null);
            rodsTxt.setText(null);
            numShelvesTxt.setText(null);
            shelveDepthTxt.setText(null);
        }
    }
}
