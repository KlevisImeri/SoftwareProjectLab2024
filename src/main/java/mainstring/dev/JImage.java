package mainstring.dev;

// import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
// import javax.swing.border.LineBorder;

/**
 * A custom JPanel subclass designed to display an image with customizable size and location. This
 * class allows for easy manipulation of the background image displayed within the panel.
 */
public class JImage extends JPanel {
  /**
   * The ImageIcon representing the background image to be displayed.
   */
  public ImageIcon backgroundImage;
  /**
   * The Dimension object defining the size of the image to be displayed.
   */
  protected Dimension imageSize = new Dimension(40, 40);
  /**
   * The Point object indicating the location of the top-left corner of the image within the panel.
   */
  protected Point imageLocation = new Point(0, 0);

  /**
   * Constructs a new JImage instance with the specified image path.
   * 
   * @param image The path to the image file to be displayed as the background.
   */
  public JImage(String image) {
    backgroundImage = new ImageIcon(getClass().getResource(image));
    setOpaque(false);
    // setBorder(new LineBorder(Color.MAGENTA, 3));
  }

  /**
   * Paints the component by drawing the background image onto it. Overrides the paintComponent
   * method of JPanel.
   * 
   * @param g The Graphics object to draw upon.
   */

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(backgroundImage.getImage(), imageLocation.x, imageLocation.y, imageSize.width,
        imageSize.height, this);
  }


  /**
   * Sets the background image to be displayed.
   * 
   * @param image The path to the new image file.
   */
  public void setBackgroundImage(String image) {
    backgroundImage = new ImageIcon(getClass().getResource(image));
  }

  /**
   * Sets the size of the image to be displayed.
   * 
   * @param x The width of the image.
   * @param y The height of the image.
   */
  public void setImageSize(int x, int y) {
    imageSize = new Dimension(x, y);
  }

  /**
   * Sets the size of the image to be displayed.
   * 
   * @param d The Dimension object defining the size.
   */
  public void setImageSize(Dimension d) {
    imageSize = d;
  }

  /**
   * Sets the location of the image within the panel.
   * 
   * @param x The x-coordinate of the top-left corner of the image.
   * @param y The y-coordinate of the top-left corner of the image.
   */
  public void setImageLocation(int x, int y) {
    imageLocation = new Point(x, y);
  }

  /**
   * Sets the location of the image within the panel.
   * 
   * @param l The Point object indicating the location.
   */
  public void setImageLocation(Point l) {
    imageLocation = l;
  }
}
