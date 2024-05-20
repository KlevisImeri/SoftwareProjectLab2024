package mainstring.dev.Elements.Element;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The ElementController class is responsible for handling mouse events
 * for an Element. It implements the MouseListener interface to respond
 * to mouse actions performed on the ElementView.
 */
public class ElementController implements MouseListener {
  // The Element instance being controlled.
  Element element;

  // The view associated with the Element.
  ElementView view;

  /**
   * Constructs an ElementController with the specified Element and ElementView.
   * Adds this controller as a mouse listener to the view.
   *
   * @param element the Element to control
   * @param view the ElementView associated with the Element
   */
  public ElementController(Element element, ElementView view) {
    this.element = element;
    this.view = view;

    // Add this controller as a MouseListener to the view.
    view.addMouseListener(this);
  }

  /**
   * Invoked when the mouse button has been clicked (pressed and released) on a component.
   * Sets the selected element in the grid to the current element and updates the selected view.
   *
   * @param e the event to be processed
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    element.grid.setSelectedElement(element);
    view.gridView.selectedElementView = view;
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
