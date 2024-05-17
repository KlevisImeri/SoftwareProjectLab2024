package mainstring.dev.Players.Player;

import javax.swing.JLabel;
import mainstring.dev.JImage;

public class PlayerView extends JImage {
  JLabel name = new JLabel();

  public PlayerView(Player player, String playerImage) {
    super(playerImage);
    name.setText(player.getName());
    add(name);
  }
}
