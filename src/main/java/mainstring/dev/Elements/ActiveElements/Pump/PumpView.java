package mainstring.dev.Elements.ActiveElements.Pump;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElementView;
import mainstring.dev.Elements.Pipe.PipeView;
import mainstring.dev.Grid.GridView;

/**
 * The PumpView class extends ActiveElementView to provide a visual representation
 * of a Pump element. It manages the display of the pump's state and its connections
 * to input and output pipes.
 */
public class PumpView extends ActiveElementView {
  // The Pump instance being represented by this view.
  Pump pump;

  // Images representing the healthy and broken states of the pump.
  String healthyImage = "/Images/pump.png";
  String brokenImage = "/Images/brokenpump.png";

  // Flag to track if the size has been set after a neighbor is added.
  Boolean sizeSet = false;

  // Views representing the input and output pipes connected to the pump.
  public PipeView inView;
  public PipeView outView;

  /**
   * Constructs a PumpView with the specified Pump and GridView.
   * Sets up the controller and initializes the view with the default pump image.
   *
   * @param pump the Pump associated with this view
   * @param gridView the GridView in which this pump is displayed
   */
  public PumpView(Pump pump, GridView gridView) {
    super(pump, "/Images/pump.png", gridView);
    this.pump = pump;
    new PumpController(pump, this);

    setPreferredSize(new Dimension(40, 40));
    setSize(getPreferredSize());
    setImageSize(getPreferredSize());
  }

  /**
   * Sets the input PipeView for this pump.
   *
   * @param view the input PipeView to set
   */   
  public void setInPipeView(PipeView view) {
    addNeighborView(view);
    inView = view;
  }

  /**
   * Sets the output PipeView for this pump.
   *
   * @param view the output PipeView to set
   */
  public void setOutPipeView(PipeView view) {
    addNeighborView(view);
    outView = view;
  }

  /**
   * Changes the direction of the views based on the selected and previous pipe views in the grid.
   */
  public void changeDirectionViews() {
    inView = gridView.previousSelectPipeView;
    outView = gridView.selectedPipeView;
  }

  /**
   * Paints the PumpView, including the connections to the input and output pipes.
   * Updates the background image based on the pump's health status and adjusts the size
   * if the pump has a neighbor.
   *
   * @param g the Graphics object to protect
   */
  @Override
  public void paint(Graphics g) {
    // Ensure the input and output views are valid neighbors.
    if(!neighborViews.contains(inView)) inView = null;
    if(!neighborViews.contains(outView)) outView = null;
    // Update the background image based on the pump's health status.
    if (pump.isHealthy()) {
      setBackgroundImage(healthyImage);
    } else {
      setBackgroundImage(brokenImage);
    }
    // Adjust the size if the pump has a neighbor and the size has not been set.
    if (pump.hasNeighbor() && !sizeSet) {
      setPreferredSize(new Dimension(200, 200));
      setSize(getPreferredSize());
      setImageSize(100, 100);
      setImageLocation(50, 50);
      sizeSet = true;
    }

    // Call the superclass's paint method.
    super.paint(g);

    // Draw connections to the input and output pipes.
    Point center = new Point(getX() + getWidth() / 2, getY() + getHeight() / 2);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.GREEN);
    g2d.setStroke(new BasicStroke(5));
    g2d.setFont(new Font("Arial", Font.BOLD, 50));

    if (inView != null) {
      Point inPipeCenter =
          new Point(inView.getX() + inView.getWidth() / 2, inView.getY() + inView.getHeight() / 2);

      double dx = inPipeCenter.x - center.x;
      double dy = inPipeCenter.y - center.y;

      String inDirection = "←";

      double angle = Math.atan2(dy, dx);

      AffineTransform oldTransform = g2d.getTransform();

      g2d.rotate(angle, getWidth() / 2 + dx * 0.1, getHeight() / 2 + dy * 0.1);

      //12 is for the size of the font
      g2d.drawString(inDirection, (int) (getWidth() / 2 + dx * 0.1) + 12,
          (int) (getHeight() / 2 + dy * 0.1) + 12);

      g2d.setTransform(oldTransform);
    }

    if (outView != null) {
      Point outPipeCenter = new Point(outView.getX() + outView.getWidth() / 2,
          outView.getY() + outView.getHeight() / 2);

      double dx = outPipeCenter.x - center.x;
      double dy = outPipeCenter.y - center.y;

      String outDirection = "→";

      double angle = Math.atan2(dy, dx);

      AffineTransform oldTransform = g2d.getTransform();
      
      //12 is for the size of the font
      g2d.rotate(angle, getWidth() / 2 + dx * 0.1, getHeight() / 2 + dy * 0.1);
      g2d.drawString(outDirection, (int) (getWidth() / 2 + dx * 0.1) + 12,
          (int) (getHeight() / 2 + dy * 0.1) + 12);

      g2d.setTransform(oldTransform);
    }

  }
}
