package mainstring.dev.Players.PlayersCollection;

import mainstring.dev.Players.Plumber;
import mainstring.dev.Players.Saboteur;
import mainstring.dev.Players.Player.*;
import javax.swing.*;
import java.awt.*;

public class PlayersCollectionView extends JPanel {
  PlayersCollection players;
  PlayersCollectionController controller;

  public JPanel plumbersPanel = new JPanel(){{
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }};
  public JLabel plumberLabel = new JLabel("Plumbers", SwingConstants.CENTER){{
    setFont(new Font("Arial", Font.BOLD, 30)); // Set font and size
  }};
  public JButton addPlumberButton = new JButton("Add Plumber") {{
    setBackground(Color.gray);
  }};
  public JPanel plumberPanel = new JPanel(new BorderLayout()) {{
    setBackground(new Color(173, 216, 230)); // Light blue background color
    setForeground(Color.BLACK); // Set font color to black
    add(plumberLabel, BorderLayout.NORTH); // Align label to center
    add(plumbersPanel, BorderLayout.CENTER);
    add(addPlumberButton, BorderLayout.SOUTH);
  }};


  public JPanel saboteursPanel = new JPanel(){{
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }};
  public JLabel saboteurLabel = new JLabel("Saboteurs", SwingConstants.CENTER){{
    setFont(new Font("Arial", Font.BOLD, 30)); // Set font and size
  }};
  public JButton addSaboteurButton = new JButton("Add Saboteur"){{
    setBackground(Color.gray);
  }};
  public JPanel saboteurPanel = new JPanel(new BorderLayout()){{
    setBackground(new Color(255, 192, 203)); // Light red background color
    setForeground(Color.BLACK); // Set font color to black
    add(saboteurLabel, BorderLayout.NORTH); // Align label to center
    add(saboteursPanel, BorderLayout.CENTER);
    add(addSaboteurButton, BorderLayout.SOUTH);
  }};
  
  public JPanel teamsPanel = new JPanel(new GridLayout(1, 2)) {{
    add(plumberPanel);
    add(saboteurPanel);
  }};
  
  public JButton backButton = new JButton("Back"){{
    setBackground(new Color(144, 238, 144));
  }};

  public class PlayerField extends JPanel {
    public PlayerTextFieldView textField;
    public JButton xButton = new JButton("X") {{
      setBackground(new Color(245, 69, 69));
    }};
    public PlayerField(Player player) {
      textField = new PlayerTextFieldView(player);
      setLayout(new BorderLayout());
      setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); 
      xButton.addActionListener(e -> controller.removePlayer(this));
      add(textField, BorderLayout.CENTER);
      add(xButton,BorderLayout.EAST);
    }
  }

  public PlayersCollectionView(PlayersCollection players) {
    this.players = players;
    
    controller = new PlayersCollectionController(players, this);

    addPlumberButton.addActionListener(e -> controller.addPlumber());
    addSaboteurButton.addActionListener(e -> controller.addSaboteur());
    
    for (var player : players.getPlayers()) {
      if (player instanceof Plumber) {  
        plumbersPanel.add(new PlayerField(player));
      } else if (player instanceof Saboteur) {
        saboteursPanel.add(new PlayerField(player));
      }
    }

    setLayout(new BorderLayout());
    add(teamsPanel, BorderLayout.CENTER);
    add(backButton, BorderLayout.SOUTH);
  }
}
