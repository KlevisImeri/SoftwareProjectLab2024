package mainstring.dev;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JImage extends JPanel {
  public ImageIcon backgroundImage;

  public JImage(String image) {
    backgroundImage = new ImageIcon(getClass().getResource(image));
    setPreferredSize(new Dimension(100,100));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
  }
}
