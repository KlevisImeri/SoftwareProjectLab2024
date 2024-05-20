package mainstring.dev.Elements.ActiveElements.Spring;

import java.awt.Dimension;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElementView;
import mainstring.dev.Grid.GridView;

/**
 * The SpringView class extends ActiveElementView to provide a visual representation
 * of a Spring element. It initializes the view with the specified image and sets
 * the preferred size of the component.
 */
public class SpringView extends ActiveElementView {
  // The Spring instance being represented by this view.
  Spring spring;

  /**
   * Constructs a SpringView with the specified Spring and GridView.
   * Sets the preferred size and initializes the view with the provided spring image.
   *
   * @param spring the Spring associated with this view
   * @param gridView the GridView in which this spring is displayed
   */
  public SpringView(Spring spring, GridView gridView) {
    super(spring, "/Images/SpringMountain.png", gridView);

    // Set the preferred size for the spring view.
    setPreferredSize(new Dimension(230,150));
    setSize(getPreferredSize());
    setImageSize(getPreferredSize());
  }

}
