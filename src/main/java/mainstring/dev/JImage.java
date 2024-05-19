package mainstring.dev;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class JImage extends JPanel {
  public ImageIcon backgroundImage;
  protected Dimension imageSize = new Dimension(40, 40);
  protected Point imageLocation = new Point(0, 0); 

  public JImage(String image) {
    backgroundImage = new ImageIcon(getClass().getResource(image));
    setOpaque(false);
    setBorder(new LineBorder(Color.MAGENTA, 3));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(
      backgroundImage.getImage(),
      imageLocation.x,
      imageLocation.y,
      imageSize.width,
      imageSize.height,
      this
    );
  }

  public void setImageSize(int x, int y) {
    imageSize = new Dimension(x, y);
  }

  public void setImageSize(Dimension d) {
    imageSize = d;
  }

  public void setImageLocation(int x, int y) {
    imageLocation = new Point(x, y);
  }

  public void setImageLocation(Point l) {
    imageLocation = l;
  }
}
