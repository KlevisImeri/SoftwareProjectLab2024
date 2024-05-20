package mainstring.dev.Players.Player;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Saboteur.Saboteur;

/**
 * The PlayerCommandView class extends JPanel to provide a user interface
 * for displaying the commands available to a player. It displays different
 * commands based on whether the player is a Plumber or a Saboteur.
 */
public class PlayerCommandView extends JPanel {

    /**
   * Constructs a PlayerCommandView with the specified Player.
   * Sets up the layout and displays the commands available to the player.
   *
   * @param player the Player for whom the commands are displayed
   */
  public PlayerCommandView(Player player) {
    // Set the layout to BoxLayout, arranged vertically.
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Set the layout to BoxLayout
    // Set the background color of the panel to black.
    setBackground(Color.BLACK); // Set the background color of the panel
    // Ensure the panel is opaque.
    setOpaque(true); // Make sure the panel is opaque

    // Create a label for the player's name and set its font color.
    JLabel nameLabel = new JLabel(player.name);
    nameLabel.setForeground(new Color(247, 154, 96)); // Set the font color for the name label
    add(nameLabel);

    // Display commands specific to Plumber players.
    if (player instanceof Plumber) {
      JLabel plumberCommands = new JLabel("<html>" +
        "[m]ove<br>" +
        "changePump[D]irection()<br>" +
        "[d]isconnectPipe()<br>" +
        "[c]onnectPipe()<br>" +
        "[f]ix()<br>" +
        "[i]nsertPump()<br>" +
        "[p]ickPump()<br>" +
        "[P]ickPipe()" +
      "</html>");
      plumberCommands.setForeground(Color.BLUE); // Set the font color for the plumber commands
      add(plumberCommands);
    }
    
    // Display commands specific to Saboteur players.
    else if (player instanceof Saboteur) {
      JLabel saboteurCommands = new JLabel("<html>" +
        "changePump[D]irection()<br>" +
        "[m]ove<br>" +
        "[p]uncturePipe()" +
      "</html>");
      saboteurCommands.setForeground(Color.RED); // Set the font color for the saboteur commands
      add(saboteurCommands);
    }
  }
}
