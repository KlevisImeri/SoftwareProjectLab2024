package mainstring.dev.Elements.ActiveElements.ActiveElement;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The ActiveElementController class is responsible for handling mouse events
 * for an ActiveElement. It implements the MouseListener interface to respond
 * to mouse actions performed on the ActiveElementView.
 */
public class ActiveElementController implements MouseListener {
  
  // The ActiveElement instance being controlled.
  ActiveElement activeElement;

  // The view associated with the ActiveElement.
  ActiveElementView view;

  /**
   * Constructs an ActiveElementController with the specified ActiveElement and ActiveElementView.
   * Adds this controller as a mouse listener to the view.
   *
   * @param activeElement the ActiveElement to control
   * @param view the ActiveElementView associated with the ActiveElement
   */
  public ActiveElementController(ActiveElement activeElement, ActiveElementView view) {
    this.activeElement = activeElement;
    this.view = view;

    // Add this controller as a MouseListener to the view.
    view.addMouseListener(this);
  }

  /**
   * Invoked when the mouse button has been clicked (pressed and released) on a component.
   * Sets the selected active element in the grid to the current active element.
   *
   * @param e the event to be processed
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    activeElement.grid.setSelectedActiveElement(activeElement);
  }

  // These methods are required by the MouseListener interface, but are not used in this implementation.
  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}

}