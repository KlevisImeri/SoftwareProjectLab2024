package mainstring.dev.Players.Player;

import javax.swing.*;
import java.awt.*;

/**
 * The PlayerTextFieldView class extends JTextField to provide a user interface
 * component for displaying and editing a player's name. It initializes the text
 * field with the player's current name and sets up the visual properties.
 */
public class PlayerTextFieldView extends JTextField {
  // The Player instance being represented by this view.
  public Player player;

  // The controller for handling interactions between the player and the text field.
  PlayerTextFieldController controller;

  /**
   * Constructs a PlayerTextFieldView with the specified Player.
   * Sets up the text field with the player's name and visual properties.
   *
   * @param player the Player to be represented by this view
   */
  public PlayerTextFieldView(Player player) {
    this.player = player;

    // Initialize the controller for this view.
    controller = new PlayerTextFieldController(player, this);

    // Set the text of the text field to the player's name.
    setText(player.getName());

    // Set the layout, size, alignment, font, and color properties.
    setLayout(new GridLayout(1,2));
    setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); 
    setHorizontalAlignment(SwingConstants.CENTER); // Align label to center horizontally
    setFont(new Font("Arial", Font.PLAIN, 16)); // Set font and size
    setForeground(Color.BLACK); // Set font color to black
  }
}
