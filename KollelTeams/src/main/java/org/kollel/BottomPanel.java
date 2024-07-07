package org.kollel;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class BottomPanel extends JPanel {
    private JRadioButton basketballRadioButton;
    private JRadioButton hockeyRadioButton;
    private JTextArea playersTextArea;
    private JTextArea captainTextArea;

    private JPanel bottomPanel = new JPanel(new GridBagLayout());

    public BottomPanel(int num) {
        GridBagConstraints gbcBottom = new GridBagConstraints();
        gbcBottom.fill = GridBagConstraints.BOTH; // Allow the component to grow both horizontally and vertically
        gbcBottom.gridx = 0; // Column 0
        gbcBottom.gridy = 0; // Row 0
        gbcBottom.weightx = 1.0; // Weight for horizontal resizing
        gbcBottom.weighty = 1.0; // Weight for vertical resizing
        gbcBottom.insets = new Insets(10, 10, 10, 10); // Add some padding

        // Create a titled border for the bottom panel
        TitledBorder titledBorder = BorderFactory.createTitledBorder("New Team " + num);
        bottomPanel.setBorder(titledBorder);

        // Create a JLabel for the title "What Sport"
        JLabel sportLabel = new JLabel("What Sport?");

        // Add the sport label to the bottom panel
        bottomPanel.add(sportLabel, gbcBottom);

        // Create a JPanel for the box with circles
        JPanel circlePanel = new JPanel(new GridLayout(1, 2)); // 1 row, 2 columns

        // Create JRadioButtons for basketball and hockey
        basketballRadioButton = new JRadioButton("Basketball");
        hockeyRadioButton = new JRadioButton("Hockey");

        // Group the radio buttons together
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(basketballRadioButton);
        buttonGroup.add(hockeyRadioButton);

        // Add radio buttons to the circle panel
        circlePanel.add(basketballRadioButton);
        circlePanel.add(hockeyRadioButton);

        // Add the circle panel to the bottom panel
        gbcBottom.gridy++; // Move to the next row
        bottomPanel.add(circlePanel, gbcBottom);

        // Create a JLabel for the title "Enter your players:"
        JLabel titleLabel = new JLabel("Enter your players (One Player Per Line) :");

        // Add the title label to the bottom panel
        gbcBottom.gridy++; // Move to the next row
        bottomPanel.add(titleLabel, gbcBottom);

        // Create a JTextArea with fewer rows and columns
        playersTextArea = new JTextArea(9, 20); // 5 rows, 20 columns
        JScrollPane playersScrollPane = new JScrollPane(playersTextArea);

        // Add the players text area to the bottom panel
        gbcBottom.gridy++; // Move to the next row
        gbcBottom.weighty = 1.0; // Allow the players text area to grow vertically
        bottomPanel.add(playersScrollPane, gbcBottom);

        // Create a JLabel for the title "Write your captain:"
        JLabel captainLabel = new JLabel("Write your captain:");

        // Add the captain label to the bottom panel
        gbcBottom.gridy++; // Move to the next row
        gbcBottom.weighty = 0.0; // Reset weighty
        bottomPanel.add(captainLabel, gbcBottom);

        // Create a JTextArea for writing the captain
        captainTextArea = new JTextArea(2, 20); // 2 rows, 20 columns
        JScrollPane captainScrollPane = new JScrollPane(captainTextArea);

        // Add the captain text area to the bottom panel
        gbcBottom.gridy++; // Move to the next row
        bottomPanel.add(captainScrollPane, gbcBottom);
    }

    public JPanel getPanel() {
        return this.bottomPanel;
    }

    public ArrayList<String> getplayers() {
        ArrayList<String> play = new ArrayList<>();
        String players = playersTextArea.getText();
        String[] playerLines = players.split("\\n");
        for (String line : playerLines) {
            if(!line.isBlank()){
                String[] name = line.split(" ");
                String add;
                if(name.length > 1){
                    add = name[0] + " " + name[1];
                }
                else{
                    add = name[0];
                }
                play.add(add);
            }
        }
        return play;
    }
    public String getCaptain(){
        String captain = captainTextArea.getText();
        return captain;
    }
    public int getSport(){
        int sport = -1;
        if(basketballRadioButton.isSelected()){
            sport = 1;
        }
        else if (hockeyRadioButton.isSelected()){
            sport = 0;
        }
        return sport;
    }
}
