package ClosetCalculator.Panels;

import javax.swing.*;
import java.awt.*;

import static ClosetCalculator.Components.Buttons.*;

public class TopButtons {
    public static JPanel createTopPanel() {
        // JPanel
        JPanel panel = new JPanel(new GridBagLayout());

        // Constraints
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(0, 10, 10, 10);

        InputButtons.closetButtons(constraints, panel, (JButton) legend, 0, 0);
        InputButtons.closetButtons(constraints, panel, (JButton) codes, 1, 0);

        constraints.insets = new Insets(0, 120, 10, 20);
        JButton calc = (JButton)calculate;

        calc.setBackground(Color.CYAN);
        calc.setOpaque(true);
        calc.setBorderPainted(false);
        InputButtons.closetButtons(constraints, panel, calc, 2, 0);

        return panel;
    }
}
