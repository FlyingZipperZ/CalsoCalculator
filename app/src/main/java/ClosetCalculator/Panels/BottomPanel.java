package ClosetCalculator.Panels;

import javax.swing.*;
import java.awt.*;

public class BottomPanel {
    public static final AbstractButton calculate = new JButton("Calculate");
    public static JPanel createCalculateButton() {
        // JPanel
        JPanel panel = new JPanel(new GridBagLayout());

        // Constraints
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(30, 10, 10, 10);

        JButton calc = (JButton)calculate;

        calc.setBackground(Color.CYAN);
        calc.setOpaque(true);
        calc.setBorderPainted(false);

        InputButtons.closetButtons(constraints, panel, calc, 0, 0);

        return panel;
    }
}
