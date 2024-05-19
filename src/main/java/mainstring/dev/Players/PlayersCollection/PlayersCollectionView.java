package mainstring.dev.Players.PlayersCollection;

import mainstring.dev.Players.Player.*;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Saboteur.Saboteur;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PlayersCollectionView extends JPanel {
  PlayersCollection players;
  PlayersCollectionController controller;
  ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/desertBackground.png"));

  public JPanel plumbersPanel = new JPanel(){{
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setOpaque(false); 
  }};
  public JLabel plumberLabel = new JLabel("Plumbers", SwingConstants.CENTER){{
    setFont(new Font("Arial", Font.BOLD, 30)); 
    setForeground(Color.BLUE); 
  }};
  public JButton addPlumberButton = new JButton("Add Plumber") {{
    setBackground(Color.gray);
  }};
  public JPanel plumberPanel = new JPanel(new BorderLayout()) {{
    setBackground(new Color(173, 216, 230)); 
    setForeground(Color.BLACK); 
    add(plumberLabel, BorderLayout.NORTH); 
    add(plumbersPanel, BorderLayout.CENTER);
    add(addPlumberButton, BorderLayout.SOUTH);
    setOpaque(false); 
  }};

  public JPanel saboteursPanel = new JPanel(){{
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setOpaque(false); 
  }};
  public JLabel saboteurLabel = new JLabel("Saboteurs", SwingConstants.CENTER){{
    setFont(new Font("Arial", Font.BOLD, 30)); 
    setForeground(Color.RED); 
  }};
  public JButton addSaboteurButton = new JButton("Add Saboteur"){{
    setBackground(Color.gray);
  }};
  public JPanel saboteurPanel = new JPanel(new BorderLayout()){{
    setBackground(new Color(255, 192, 203)); 
    setForeground(Color.BLACK); 
    add(saboteurLabel, BorderLayout.NORTH); 
    add(saboteursPanel, BorderLayout.CENTER);
    add(addSaboteurButton, BorderLayout.SOUTH);
    setOpaque(false); 
  }};
  
  public JPanel teamsPanel = new JPanel(new GridLayout(1, 2)) {{
    add(plumberPanel);
    add(saboteurPanel);
    setOpaque(false); 
  }};
  
  public JButton backButton = new JButton("Back"){{
    setBackground(new Color(247, 154, 96));
  }};

  public class PlayerField extends JPanel {
    public PlayerTextFieldView textField;
    public JButton xButton = new JButton("X") {{
      setBackground(new Color(245, 69, 69));
    }};
    public PlayerField(Player player) {
        textField = new PlayerTextFieldView(player);
        textField.setBackground(Color.DARK_GRAY); 
        textField.setForeground(Color.WHITE); 
        textField.setBorder(new LineBorder(Color.BLACK, 1)); 
        setLayout(new BorderLayout());
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); 
        xButton.addActionListener(e -> controller.removePlayer(this));
        add(textField, BorderLayout.CENTER);
        add(xButton,BorderLayout.EAST);
        setOpaque(false); 
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
    
    JPanel backgroundPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
      };
      backgroundPanel.setLayout(new BorderLayout());
      backgroundPanel.add(teamsPanel, BorderLayout.CENTER);
      backgroundPanel.add(backButton, BorderLayout.SOUTH);
      
      add(backgroundPanel);
  }
}
