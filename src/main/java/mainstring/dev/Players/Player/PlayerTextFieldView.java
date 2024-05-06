package mainstring.dev.Players.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerTextFieldView extends JTextField {
  public Player player;
  PlayerTextFieldController controller;

  public PlayerTextFieldView(Player player) {
    this.player = player;
    controller = new PlayerTextFieldController(player, this);
    addActionListener(e -> controller.setName());
    setText(player.getName());
    setLayout(new GridLayout(1,2));
    setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); 
    setHorizontalAlignment(SwingConstants.CENTER); // Align label to center horizontally
    setFont(new Font("Arial", Font.PLAIN, 16)); // Set font and size
    setForeground(Color.BLACK); // Set font color to black
  }
}
