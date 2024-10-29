package mainstring.dev.Players.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JLabel;
import mainstring.dev.JImage;
import mainstring.dev.Elements.Element.ElementView;

/**
 * The PlayerView class extends JImage to provide a visual representation
 * of a player in the game. It displays the player's name and image,
 * and manages the player's location within the game.
 */
public class PlayerView extends JImage {
  // Label for displaying the player's name.
  JLabel name = new JLabel() {{
        setForeground(new Color(227, 129, 54));
        setOpaque(true);
        setBackground(Color.BLACK);
        setFont(new Font("Arial", Font.BOLD, 10)); 
  }};

  // The Player instance being represented by this view.
  Player player;

  // The current location of the player within the game.
  public ElementView location;

  /**
   * Constructs a PlayerView with the specified Player, image, and location.
   * Sets up the name label, layout, and initial properties of the view.
   *
   * @param player the Player to be represented by this view
   * @param playerImage the image representing the player
   * @param location the initial location of the player
   */
  public PlayerView(Player player, String playerImage, ElementView location) {
    super(playerImage);
    this.location = location;
    this.player = player;
    player.addView(this);
    player.setFocusable(this);

    // Set the text of the name label to the player's name.
    name.setText(player.getName());

    // Use null layout to allow absolute positioning of the name label.
    setLayout(null); // Use null layout to allow absolute positioning
    add(name);

    // Set the preferred size and image size for the player view.
    setPreferredSize(new Dimension(60, 60));
    setImageSize(getPreferredSize());

    // Position the name label at the bottom center of the player view.
    FontMetrics fm = name.getFontMetrics(name.getFont());
    int textWidth = fm.stringWidth(name.getText());
    int labelHeight = fm.getHeight();
    int x = (getPreferredSize().width - textWidth) / 2;
    name.setBounds(x, getPreferredSize().height - labelHeight, textWidth, labelHeight);

    // Initialize the controller for this view.
    new PlayerController(player, this);
  }

  /**
   * Paints the PlayerView, ensuring the component is properly validated.
   *
   * @param g the Graphics object to protect
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    revalidate();
  }
}
