package ClosetCalculator.Panels;

import javax.swing.*;
import java.awt.*;

import static ClosetCalculator.Components.Buttons.ADD;
import static ClosetCalculator.Components.Buttons.DELETE;

public class InputButtons {
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

        return panel;
    }
}
