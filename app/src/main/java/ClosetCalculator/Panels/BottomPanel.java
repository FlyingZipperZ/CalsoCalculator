package ClosetCalculator.Panels;

import javax.swing.*;
import java.awt.*;

import static ClosetCalculator.Components.Buttons.clear;

public class BottomPanel {
    public static JPanel createCalculateButton() {
        // JPanel
        JPanel panel = new JPanel(new GridBagLayout());

        // Constraints
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(10, 20, 10, 60);

        InputButtons.closetButtons(constraints, panel, (JButton) clear, 0, 0);

        return panel;
    }
}
