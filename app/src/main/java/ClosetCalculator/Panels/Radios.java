package ClosetCalculator.Panels;

import javax.swing.*;
import java.awt.*;

import static ClosetCalculator.Components.Radios.*;

public class Radios {
    public static JPanel createRadios() {
        // JPanel
        JPanel panel = new JPanel(new GridBagLayout());

        // GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;

        /**
        Tops
         */
        JLabel topsLabel = new JLabel("Tops?: ");

        // Bottoms Radio Button 1 Yes

        topYesRadio.setText("Yes");

        // Bottoms Radio Button 2 No

        topNoRadio.setText("No");

        topNoRadio.setSelected(true);

        /**
         Bottoms
         */
        // Label
        JLabel bottomsLabel = new JLabel("Bottoms?: ");

        // Tops Radio Button 1 Yes

        bottomYesRadio.setText("Yes");

        bottomYesRadio.setSelected(true);

        // Tops Radio Button 2 No

        bottomNoRadio.setText("No");


        /**
         * Groups
         */
        // Group radio buttons
        ButtonGroup topsGroup = new ButtonGroup();
        topsGroup.add(topYesRadio);
        topsGroup.add(topNoRadio);

        // Group radio buttons
        ButtonGroup bottomsGroup = new ButtonGroup();
        bottomsGroup.add(bottomYesRadio);
        bottomsGroup.add(bottomNoRadio);

        gbc.insets = new Insets(5, 10, 5, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(topsLabel, gbc);

        gbc.gridx++;
        panel.add(topYesRadio, gbc);

        gbc.gridx++;
        panel.add(topNoRadio, gbc);

        gbc.gridx = 0;

        gbc.gridy++;
        panel.add(bottomsLabel, gbc);

        gbc.gridx++;
        panel.add(bottomYesRadio, gbc);

        gbc.gridx++;
        panel.add(bottomNoRadio, gbc);
        return panel;
    }
}
