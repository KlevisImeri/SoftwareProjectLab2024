package mainstring.dev.UI.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mainstring.dev.Players.PlayersCollection;
import mainstring.dev.Players.Plumber;
import mainstring.dev.Players.Saboteur;

public class PlayersCollectionGUI extends JComponent {
    private PlayersCollection playersCollection;
    private JTextArea plumbersArea, saboteursArea;
    private JButton addPlumberButton, addSaboteurButton;

    public PlayersCollectionGUI(PlayersCollection playersCollection) {
        this.playersCollection = playersCollection;
        setupGUI();
    }

    private void setupGUI() {
        setLayout(new GridLayout(1, 2)); // Divides the screen into two equal halves

        JPanel plumbersPanel = new JPanel(new BorderLayout());
        JPanel saboteursPanel = new JPanel(new BorderLayout());

        // Title labels for each section
        JLabel plumbersLabel = new JLabel("Plumbers", SwingConstants.CENTER);
        JLabel saboteursLabel = new JLabel("Saboteurs", SwingConstants.CENTER);
        plumbersPanel.add(plumbersLabel, BorderLayout.NORTH);
        saboteursPanel.add(saboteursLabel, BorderLayout.NORTH);

        // Text area to add player names
        plumbersArea = new JTextArea(10, 20);
        JScrollPane plumbersScrollPane = new JScrollPane(plumbersArea);
        saboteursArea = new JTextArea(10, 20);
        JScrollPane saboteursScrollPane = new JScrollPane(saboteursArea);
        plumbersPanel.add(plumbersScrollPane, BorderLayout.CENTER);
        saboteursPanel.add(saboteursScrollPane, BorderLayout.CENTER);

        // Add buttons for each section
        addPlumberButton = new JButton("Add Plumbers");
        addPlumberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] names = plumbersArea.getText().split("\\n");
                for (String name : names) {
                    if (!name.trim().isEmpty()) {
                        playersCollection.add(new Plumber(name.trim()));
                    }
                }
                plumbersArea.setText("");
            }
        });
        addSaboteurButton = new JButton("Add Saboteurs");
        addSaboteurButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] names = saboteursArea.getText().split("\\n");
                for (String name : names) {
                    if (!name.trim().isEmpty()) {
                        playersCollection.add(new Saboteur(name.trim()));
                    }
                }
                saboteursArea.setText("");
            }
        });
        plumbersPanel.add(addPlumberButton, BorderLayout.SOUTH);
        saboteursPanel.add(addSaboteurButton, BorderLayout.SOUTH);

        add(plumbersPanel);
        add(saboteursPanel);

        // Continue button
        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener((e) -> {
            // Here you can add code to proceed with the collected players
        });
        add(continueButton, BorderLayout.SOUTH);
    }
}
