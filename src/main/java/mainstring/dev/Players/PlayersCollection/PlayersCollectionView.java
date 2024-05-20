package mainstring.dev.Players.PlayersCollection;

import mainstring.dev.Players.Player.*;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Saboteur.Saboteur;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * The PlayersCollectionView class extends JPanel to provide a user interface
 * for managing the collection of players. It displays panels for plumbers and saboteurs,
 * allows adding and removing players, and handles layout and background image.
 */
public class PlayersCollectionView extends JPanel {
  // The PlayersCollection instance being represented by this view.
  PlayersCollection players;

  // The controller for handling interactions between the model and the view.
  PlayersCollectionController controller;

  // Background image for the view.
  ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/desertBackground.png"));

  // Panel to hold plumbers.
  public JPanel plumbersPanel = new JPanel(){{
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setOpaque(false); 
  }};

  // Label for the plumbers panel.
  public JLabel plumberLabel = new JLabel("Plumbers", SwingConstants.CENTER){{
    setFont(new Font("Arial", Font.BOLD, 30)); 
    setForeground(Color.BLUE); 
  }};

  // Button to add a new plumber.
  public JButton addPlumberButton = new JButton("Add Plumber") {{
    setBackground(Color.gray);
  }};

  // Panel to hold the plumber label, plumbersPanel, and addPlumberButton.
  public JPanel plumberPanel = new JPanel(new BorderLayout()) {{
    setBackground(new Color(173, 216, 230)); 
    setForeground(Color.BLACK); 
    add(plumberLabel, BorderLayout.NORTH); 
    add(plumbersPanel, BorderLayout.CENTER);
    add(addPlumberButton, BorderLayout.SOUTH);
    setOpaque(false); 
  }};

  // Panel to hold saboteurs.
  public JPanel saboteursPanel = new JPanel(){{
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setOpaque(false); 
  }};

  // Label for the saboteurs panel.
  public JLabel saboteurLabel = new JLabel("Saboteurs", SwingConstants.CENTER){{
    setFont(new Font("Arial", Font.BOLD, 30)); 
    setForeground(Color.RED); 
  }};

  // Button to add a new saboteur.
  public JButton addSaboteurButton = new JButton("Add Saboteur"){{
    setBackground(Color.gray);
  }};

  // Panel to hold the saboteur label, saboteursPanel, and addSaboteurButton.
  public JPanel saboteurPanel = new JPanel(new BorderLayout()){{
    setBackground(new Color(255, 192, 203)); 
    setForeground(Color.BLACK); 
    add(saboteurLabel, BorderLayout.NORTH); 
    add(saboteursPanel, BorderLayout.CENTER);
    add(addSaboteurButton, BorderLayout.SOUTH);
    setOpaque(false); 
  }};
  
  // Panel to hold both plumberPanel and saboteurPanel.
  public JPanel teamsPanel = new JPanel(new GridLayout(1, 2)) {{
    add(plumberPanel);
    add(saboteurPanel);
    setOpaque(false); 
  }};
  
  // Button to go back to the previous view.
  public JButton backButton = new JButton("Back"){{
    setBackground(new Color(247, 154, 96));
  }};

  /**
   * The PlayerField class extends JPanel to provide a UI component
   * for displaying and editing a player's name, along with a button
   * to remove the player from the collection.
   */
  public class PlayerField extends JPanel {
    // Text field for the player's name.
    public PlayerTextFieldView textField;

    // Button to remove the player.
    public JButton xButton = new JButton("X") {{
      setBackground(new Color(245, 69, 69));
    }};

    /**
     * Constructs a PlayerField with the specified Player.
     * Sets up the text field and remove button.
     *
     * @param player the Player to be represented by this field
     */
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

  /**
   * Constructs a PlayersCollectionView with the specified PlayersCollection.
   * Initializes the UI components and sets up the layout and background image.
   *
   * @param players the PlayersCollection to be represented by this view
   */
  public PlayersCollectionView(PlayersCollection players) {
    this.players = players;
    
    // Initialize the controller for this view.
    controller = new PlayersCollectionController(players, this);

    // Set up action listeners for the add buttons.
    addPlumberButton.addActionListener(e -> controller.addPlumber());
    addSaboteurButton.addActionListener(e -> controller.addSaboteur());
    
    // Add existing players to the view.
    for (var player : players.getPlayers()) {
      if (player instanceof Plumber) {  
        plumbersPanel.add(new PlayerField(player));
      } else if (player instanceof Saboteur) {
        saboteursPanel.add(new PlayerField(player));
      }
    }

    // Set the layout for the main panel.
    setLayout(new BorderLayout());
    
    // Create a panel to hold the background image.
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
      
      // Add the background panel to the main panel.
      add(backgroundPanel);
  }
}
