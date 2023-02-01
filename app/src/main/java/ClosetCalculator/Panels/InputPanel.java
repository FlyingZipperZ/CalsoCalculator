package ClosetCalculator.Panels;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    public static JPanel createInputPanel() {
        // JPanel
        JPanel panel = new JPanel(new GridBagLayout());

        // Constraints
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(5, 10, 5, 10);

        constraints.gridy++;
        panel.add(Radios.createRadios(), constraints);
        constraints.gridy++;
        panel.add(InputsLabelTxt.createInputLabelTxt(), constraints);
        constraints.gridy++;
        panel.add(InputButtons.createInputButtons(), constraints);

        return panel;
    }
}
