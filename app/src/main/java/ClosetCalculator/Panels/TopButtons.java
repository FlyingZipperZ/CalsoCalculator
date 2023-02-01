package ClosetCalculator.Panels;

import javax.swing.*;
import java.awt.*;

public class TopButtons {
    // Buttons
    public static final AbstractButton legend = new JButton("Type Codes Key");
    public static final AbstractButton codes = new JButton("Legend mm-in");

    public static JPanel createTopPanel() {
        // JPanel
        JPanel panel = new JPanel(new GridBagLayout());

        // Constraints
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(30, 10, 10, 10);

        InputButtons.closetButtons(constraints, panel, (JButton) legend, 0, 0);
        InputButtons.closetButtons(constraints, panel, (JButton) codes, 1, 0);

        return panel;
    }
}
