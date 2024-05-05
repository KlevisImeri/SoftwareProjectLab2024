package mainstring.dev.Players.PlayersCollection;

import mainstring.dev.Players.Plumber;
import mainstring.dev.Players.Saboteur;
import mainstring.dev.Players.Player.*;
import javax.swing.*;
import java.awt.*;

public class PlayersCollectionView extends JPanel {
  PlayersCollection players;
  PlayersCollectionController controller;

  public JPanel plumberPanel = new JPanel(new BorderLayout());
  public JPanel plumbersPanel = new JPanel();
  public JLabel plumberLabel = new JLabel("Plumbers", SwingConstants.CENTER);
  public JButton addPlumberButton = new JButton("Add Plumber");

  public JPanel saboteurPanel = new JPanel(new BorderLayout());
  public JPanel saboteursPanel = new JPanel();
  public JLabel saboteurLabel = new JLabel("Saboteurs", SwingConstants.CENTER);
  public JButton addSaboteurButton = new JButton("Add Saboteur");

  public JButton backButton = new JButton("Back");

  public PlayersCollectionView(PlayersCollection players) {
    this.players = players;
    
    controller = new PlayersCollectionController(players, this);

    plumberPanel.setBackground(new Color(173, 216, 230)); // Light blue background color
    plumberLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
    plumberLabel.setForeground(Color.BLACK); // Set font color to black
    plumbersPanel.setLayout(new BoxLayout(plumbersPanel, BoxLayout.Y_AXIS));
    plumberPanel.add(plumberLabel, BorderLayout.NORTH); // Align label to center
    plumberPanel.add(plumbersPanel, BorderLayout.CENTER);
    plumberPanel.add(addPlumberButton, BorderLayout.SOUTH);


    saboteurPanel.setBackground(new Color(173, 216, 230)); // Light blue background color
    saboteurLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
    saboteurLabel.setForeground(Color.BLACK); // Set font color to black
    saboteursPanel.setLayout(new BoxLayout(saboteursPanel, BoxLayout.Y_AXIS));
    saboteurPanel.add(saboteurLabel, BorderLayout.NORTH); // Align label to center
    saboteurPanel.add(saboteursPanel, BorderLayout.CENTER);
    saboteurPanel.add(addSaboteurButton, BorderLayout.SOUTH);

    addPlumberButton.addActionListener(e -> controller.addPlumber());
    addSaboteurButton.addActionListener(e -> controller.addSaboteur());
    
    for (Player player : players.getPlayers()) {
      if (player instanceof Plumber) {  
        plumbersPanel.add(new PlayerTextFieldView(player));
      } else if (player instanceof Saboteur) {
        saboteursPanel.add(new PlayerTextFieldView(player));
      }
    }


    setLayout(new GridLayout(1, 2));
    add(plumberPanel);
    add(saboteurPanel);
    // add(backButton);
  }
}
