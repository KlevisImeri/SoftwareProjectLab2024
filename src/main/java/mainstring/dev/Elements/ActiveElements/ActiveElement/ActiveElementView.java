package mainstring.dev.Elements.ActiveElements.ActiveElement;

import mainstring.dev.Elements.Element.ElementView;
import mainstring.dev.Grid.GridView;

/**
 * The ActiveElementView class extends ElementView to provide a visual representation
 * of an ActiveElement. It also sets up a controller to handle mouse events.
 */
public class ActiveElementView extends ElementView {
  
  /**
   * Constructs an ActiveElementView with the specified ActiveElement, image, and GridView.
   * Also sets up an ActiveElementController to handle mouse events for this view.
   *
   * @param element the ActiveElement associated with this view
   * @param image the image representing the element
   * @param gridView the grid view in which this element is displayed
   */
  public ActiveElementView(ActiveElement element, String image, GridView gridView) {
    super(element, image, gridView);

    // Set up the controller to handle mouse events for this view.
    new ActiveElementController(element, this);
  }
}
