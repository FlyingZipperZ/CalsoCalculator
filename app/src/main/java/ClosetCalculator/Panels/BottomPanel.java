package ClosetCalculator.Panels;

import javax.swing.*;
import java.awt.*;

import static ClosetCalculator.Components.Buttons.DELETE;
import static ClosetCalculator.Components.Buttons.clear;
import static ClosetCalculator.Panels.InputButtons.closetButtons;

public class BottomPanel {
    public static JPanel createCalculateButton() {
        // JPanel
        JPanel panel = new JPanel(new GridBagLayout());

        // Constraints
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(10, 20, 10, 60);
        closetButtons(constraints, panel, (JButton) DELETE, 0, 0);
        closetButtons(constraints, panel, (JButton) clear, 1, 0);

        return panel;
    }
}
