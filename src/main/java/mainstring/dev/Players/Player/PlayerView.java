package mainstring.dev.Players.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JLabel;
import mainstring.dev.JImage;
import mainstring.dev.Elements.Element.ElementView;

public class PlayerView extends JImage {
  JLabel name = new JLabel() {
    {
        setForeground(new Color(227, 129, 54));
        setOpaque(true);
        setBackground(Color.BLACK);
        setFont(new Font("Arial", Font.BOLD, 10)); 
    }
  };

  ElementView location;

  public PlayerView(Player player, String playerImage, ElementView location) {
    super(playerImage);
    this.location = location;
    name.setText(player.getName());
    setLayout(null); // Use null layout to allow absolute positioning
    add(name);
    setPreferredSize(new Dimension(60, 60));
    setImageSize(getPreferredSize());

    // Position the name label at the bottom center
    FontMetrics fm = name.getFontMetrics(name.getFont());
    int textWidth = fm.stringWidth(name.getText());
    int labelHeight = fm.getHeight();
    int x = (getPreferredSize().width - textWidth) / 2;
    name.setBounds(x, getPreferredSize().height - labelHeight, textWidth, labelHeight);

    new PlayerController(player, this);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    revalidate();
  }
}
