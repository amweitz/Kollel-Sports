package org.kollel;

import javax.swing.*;
import java.awt.*;
import javax.swing.SpinnerNumberModel;

public class TopPanel extends JPanel {
    private JPanel topPanel = new JPanel(new GridBagLayout());
    private JSpinner slotsSpinner;
    private JSpinner schedSpinner;
    private JSpinner basketballTeamsSpinner;
    private JSpinner hockeyTeamsSpinner;

    public TopPanel() {
        GridBagConstraints gbcTop = new GridBagConstraints();
        gbcTop.fill = GridBagConstraints.HORIZONTAL; // Allow the component to grow horizontally
        gbcTop.gridx = 0; // Column 0
        gbcTop.gridy = 0; // Row 0
        gbcTop.insets = new Insets(10, 10, 10, 10); // Add some padding

        JLabel schedLabel = new JLabel("Number of schedules to print");
        schedSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 50, 1)); // Initial value, min, max, step

        // Add labels and spinners to the top panel
        gbcTop.gridy++;
        topPanel.add(schedLabel, gbcTop);
        gbcTop.gridx++;
        topPanel.add(schedSpinner, gbcTop);

        // Create labels and spinners for input
        JLabel slotsLabel = new JLabel("Number of slots to play:");
        slotsSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

        // Add labels and spinners to the top panel
        gbcTop.gridx = 0; // Reset gridx
        gbcTop.gridy++;
        topPanel.add(slotsLabel, gbcTop);

        gbcTop.gridx++;
        topPanel.add(slotsSpinner, gbcTop);

        JLabel basketballTeamsLabel = new JLabel("Number of basketball teams per slot:");
        basketballTeamsSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

        gbcTop.gridx = 0; // Reset gridx
        gbcTop.gridy++;
        topPanel.add(basketballTeamsLabel, gbcTop);

        gbcTop.gridx++;
        topPanel.add(basketballTeamsSpinner, gbcTop);

        JLabel hockeyTeamsLabel = new JLabel("Number of hockey teams per slot:");
        hockeyTeamsSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

        gbcTop.gridx = 0; // Reset gridx
        gbcTop.gridy++;
        topPanel.add(hockeyTeamsLabel, gbcTop);

        gbcTop.gridx++;
        topPanel.add(hockeyTeamsSpinner, gbcTop);
    }

    public JPanel getPanel() {
        return this.topPanel;
    }

    // Getter methods for retrieving spinner values
    public int getSlotsSpinnerValue() {
        return (int) slotsSpinner.getValue();
    }

    public int getBasketballPerSlotSpinnerValue() {
        return (int) basketballTeamsSpinner.getValue();
    }

    public int getHockeyPerSlotSpinnerValue() {
        return (int) hockeyTeamsSpinner.getValue();
    }

    public int getSchedSpinnerValue() {
        return (int) schedSpinner.getValue();
    }
}
