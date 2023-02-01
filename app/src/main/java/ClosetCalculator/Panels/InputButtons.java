package ClosetCalculator.Panels;

import javax.swing.*;
import java.awt.*;

public class InputButtons {
    // Buttons
    public static final AbstractButton ADD = new JButton("Add");
    public static final AbstractButton DELETE = new JButton("Delete");
    public static final AbstractButton clear = new JButton("Clear Table");


    public static void closetButtons(GridBagConstraints constraints, JPanel buttonPanel, JButton button, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        buttonPanel.add(button, constraints);
    }

    public static JPanel createInputButtons() {
        // JPanel
        JPanel panel = new JPanel(new GridBagLayout());

        // Constraints
        GridBagConstraints constraints = new GridBagConstraints();

        closetButtons(constraints, panel, (JButton) ADD, 0, 0);
        closetButtons(constraints, panel, (JButton) DELETE, 1, 0);

        constraints.insets = new Insets(20, 10, 10, 10);
        constraints.gridwidth = 2;
        closetButtons(constraints, panel, (JButton) clear, 0, 1);

        return panel;
    }
}
