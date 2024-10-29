package mainstring.dev.Elements.ActiveElements.Pump;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * The PumpController class handles mouse events for a Pump element,
 * allowing it to be dragged around the screen. It implements the MouseListener
 * and MouseMotionListener interfaces to respond to various mouse actions.
 */
public class PumpController implements MouseListener, MouseMotionListener {
  // The Pump instance being controlled.
  Pump pump;

  // The view associated with the Pump.
  PumpView view;

  // Variables to store the current and initial positions of the mouse and view.
  private volatile int screenX = 0;
  private volatile int screenY = 0;
  private volatile int myX = 0;
  private volatile int myY = 0;

  /**
   * Constructs a PumpController with the specified Pump and PumpView.
   * Adds this controller as a mouse listener and mouse motion listener to the view.
   *
   * @param pump the Pump to control
   * @param view the PumpView associated with the Pump
   */
  public PumpController(Pump pump, PumpView view) {
    this.pump = pump;
    this.view = view;

    // Add this controller as a MouseMotionListener and MouseListener to the view.
    view.addMouseMotionListener(this);
    view.addMouseListener(this);
  }

  /**
   * Invoked when a mouse button is pressed on the component and then dragged.
   * Updates the location of the PumpView based on the movement of the mouse.
   *
   * @param e the event to be processed
   */
  @Override
  public void mouseDragged(MouseEvent e) {
    int deltaX = e.getXOnScreen() - screenX;
    int deltaY = e.getYOnScreen() - screenY;

    // Set the new location of the view based on the delta values.
    view.setLocation(myX + deltaX, myY + deltaY);
  }

  // This method is required by the MouseMotionListener interface, but is not used in this implementation.
  @Override
  public void mouseMoved(MouseEvent e) {}

  // This method is required by the MouseListener interface, but is not used in this implementation.
  @Override
  public void mouseClicked(MouseEvent e) {}

  /**
   * Invoked when a mouse button has been pressed on a component.
   * Stores the initial position of the mouse and view for dragging.
   *
   * @param e the event to be processed
   */
  @Override
  public void mousePressed(MouseEvent e) {
    screenX = e.getXOnScreen();
    screenY = e.getYOnScreen();

    myX = view.getX();
    myY = view.getY();
  }

  // This method is required by the MouseListener interface, but is not used in this implementation.
  @Override
  public void mouseReleased(MouseEvent e) {}

  // This method is required by the MouseListener interface, but is not used in this implementation.
  @Override
  public void mouseEntered(MouseEvent e) {}

  // This method is required by the MouseListener interface, but is not used in this implementation.
  @Override
  public void mouseExited(MouseEvent e) {}
}