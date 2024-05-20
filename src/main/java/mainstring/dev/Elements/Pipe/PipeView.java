package mainstring.dev.Elements.Pipe;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import mainstring.dev.Elements.Element.ElementView;
import mainstring.dev.Grid.GridView;

/**
 * The PipeView class extends ElementView to provide a visual representation
 * of a Pipe element. It manages the display of the pipe's state and handles
 * the painting logic to visualize connections to neighboring elements.
 */
public class PipeView extends ElementView {
  // The Pipe instance being represented by this view.
  Pipe pipe;

  // Images representing the different states of the pipe.
  String healthyImage = "/Images/pipe.png";
  String healthyImageFull = "/Images/fullpipe.png";
  String brokenImage = "/Images/brokenpipe.png";

  /**
   * Constructs a PipeView with the specified Pipe and GridView.
   * Sets the preferred size and initializes the view with the default pipe image.
   *
   * @param pipe the Pipe associated with this view
   * @param gridView the GridView in which this pipe is displayed
   */
  public PipeView(Pipe pipe, GridView gridView) {
    super(pipe, "/Images/pipe.png", gridView);
    this.pipe = pipe;
    pipe.addView(this);

    // Set the preferred size for the pipe view.
    setPreferredSize(new Dimension(40, 40));
    setSize(getPreferredSize());
    setImageSize(getPreferredSize());

    // Initialize the controller for this view.
    new PipeController(pipe, this);
  }

  /**
   * Paints the PipeView, including the connections to neighboring elements.
   * Updates the background image based on the pipe's state and adjusts the size
   * and location if the pipe is connected to two neighbors.
   *
   * @param g the Graphics object to protect
   */
  @Override
  public void paint(Graphics g) {
    // Update the background image based on the pipe's state.
    if (pipe.isHealthy() && pipe.isFull()) {
      setBackgroundImage(healthyImageFull);
    } else if (pipe.isHealthy() && !pipe.isFull()) {
      setBackgroundImage(healthyImage);
    } else {
      setBackgroundImage(brokenImage);
    }

    // Handle the painting logic if the pipe is connected to two neighbors.
    if (neighborViews.size() >= 2) {
      if (neighborViews.get(0) == neighborViews.get(1))
        System.out.println("Same Neighboor");

      Dimension d1 = neighborViews.get(0).getSize();
      Dimension d2 = neighborViews.get(1).getSize();
      Point p1 = neighborViews.get(0).getLocation();
      Point p2 = neighborViews.get(1).getLocation();

      if (p1.getX() == p2.getX() && p1.getY() == p2.getY())
        System.out.println("Same locatoin");

      p1.setLocation(p1.getX() + d1.getWidth() / 2, p1.getY() + d1.getHeight() / 2);
      p2.setLocation(p2.getX() + d2.getWidth() / 2, p2.getY() + d2.getHeight() / 2);
      double dx = p2.getX() - p1.getX();
      double dy = p2.getY() - p1.getY();
      double dis = Math.sqrt(dx * dx + dy * dy);

      // Padding is needed so when the size becomes small, the image which has 40 width
      // doesn't disappera becuause the saize fo the panel is [0,0].
      int padding = 70;
      setSize((int) Math.abs(dx) + padding, (int) (Math.abs(dy)) + padding);
      setLocation(
        (int) ((p1.getX() + p2.getX()) / 2 - getWidth() / 2),
        (int) ((p1.getY() + p2.getY()) / 2 - getHeight() / 2)
      );
      setImageSize((int) dis, 40);
      setImageLocation(0, getHeight() / 2 - 20);

      // System.out.println(getSize());

      Graphics2D g2d = (Graphics2D) g;
      double angle = Math.atan2(dy, dx);
      int w2 = getWidth() / 2;
      int h2 = getHeight() / 2;
      g2d.rotate(angle, w2, h2);
      super.paint(g);
      g2d.dispose();

    } else if (neighborViews.size() < 2) {
      setLocation(0, 0);
      setPreferredSize(new Dimension(40, 40));
      setSize(getPreferredSize());
      setImageSize(getPreferredSize());
      super.paint(g);
    }
  }
}
