package mainstring.dev.Players.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JLabel;
import mainstring.dev.JImage;
import mainstring.dev.Elements.Element.ElementView;

public class PlayerView extends JImage {
  JLabel name = new JLabel() {
    {
      setForeground(new Color(227, 129, 54));
    }
  };

  ElementView location;

  public PlayerView(Player player, String playerImage, ElementView location) {
    super(playerImage);
    this.location = location;
    name.setText(player.getName());
    add(name);
    setPreferredSize(new Dimension(60, 60));
    setImageSize(getPreferredSize());

    new PlayerController(player, this);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    revalidate();
  }
}
