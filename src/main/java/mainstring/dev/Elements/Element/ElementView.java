package mainstring.dev.Elements.Element;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import mainstring.dev.JImage;
import mainstring.dev.Grid.GridView;
import mainstring.dev.Players.Player.PlayerView;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Plumber.PlumberView;
import mainstring.dev.Players.Saboteur.Saboteur;
import mainstring.dev.Players.Saboteur.SaboteurView;

/**
 * The ElementView class extends JImage to provide a visual representation
 * of an Element. It manages the display of players (plumbers and saboteurs) 
 * and handles neighboring elements within the grid.
 */
public class ElementView extends JImage {
  // The Element instance being represented by this view.
  Element element;

  // The controller responsible for handling events related to this element view.
  ElementController controller;

  // Lists to hold the views of players and neighboring elements associated with this element.
  public List<PlayerView> playerViews = new ArrayList<>();
  public List<ElementView> neighborViews = new ArrayList<>();

  // The grid view in which this element is displayed.
  public GridView gridView;

  // GridBagConstraints used for layout management within this view.
  protected GridBagConstraints gbc;

  /**
   * Constructs an ElementView with the specified Element, image, and GridView.
   * Sets up the layout and initializes the player views associated with this element.
   *
   * @param element the Element associated with this view
   * @param image the image representing the element
   * @param gridView the GridView in which this element is displayed
   */
  public ElementView(Element element, String image, GridView gridView) {
    super(image);
    this.gridView = gridView;
    this.element = element;
    controller = new ElementController(element, this);

    // Set up the layout manager and constraints.
    setLayout(new GridBagLayout());
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 0.0;
    gbc.weighty = 0.0;
    gbc.anchor = GridBagConstraints.CENTER;

    // Initialize and add plumber views.
    for (Plumber plumber : element.players.getPlumbers()) {
      PlumberView plumberView = new PlumberView(plumber, this);
      add(plumberView, gbc);
      gbc.gridx++;
      playerViews.add(plumberView);
    }

    // Initialize and add saboteur views.
    for (Saboteur saboteur : element.players.getSaboteurs()) {
      SaboteurView saboteurView = new SaboteurView(saboteur, this);
      add(saboteurView, gbc);
      gbc.gridx++;
      playerViews.add(saboteurView);
    }

    
  }

  /**
   * Adds a neighboring ElementView to this element view.
   * 
   * @param elemView the neighboring ElementView to add
   */
  public void addNeighborView(ElementView elemView) {
    neighborViews.add(elemView);
    elemView.neighborViews.add(this);
    // elemView.repaint();
    // repaint();
  }

  /**
   * Removes a neighboring ElementView from this element view.
   * 
   * @param elemView the neighboring ElementView to remove
   */
  public void removeNeighborView(ElementView elemView) {
    neighborViews.remove(elemView);
    elemView.neighborViews.remove(this);
    // elemView.repaint();
    // repaint();
  }

}
