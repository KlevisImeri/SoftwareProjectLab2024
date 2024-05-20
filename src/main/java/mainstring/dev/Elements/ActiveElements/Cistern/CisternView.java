package mainstring.dev.Elements.ActiveElements.Cistern;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElementView;
import mainstring.dev.Elements.ActiveElements.Pump.PumpView;
import mainstring.dev.Elements.Pipe.PipeView;
import mainstring.dev.Grid.GridView;

/**
 * The CisternView class extends ActiveElementView to provide a visual representation
 * of a Cistern element. It manages the display and updates of associated PipeView and PumpView objects.
 */
public class CisternView extends ActiveElementView {
  // The Cistern instance being represented by this view.
  Cistern cistern;

  // Lists to hold the views of pipes and pumps associated with the cistern.
  List<PipeView> pipeViews = new ArrayList<>();
  List<PumpView> pumpViews = new ArrayList<>();

  /**
   * Constructs a CisternView with the specified Cistern and GridView.
   * Sets the preferred size and initializes the view with the provided cistern image.
   *
   * @param cistern the Cistern associated with this view
   * @param gridView the GridView in which this cistern is displayed
   */
  public CisternView(Cistern cistern, GridView gridView) {
    super(cistern, "/Images/cistern.png", gridView);
    this.cistern = cistern;

    // Set the preferred size for the cistern view.
    setPreferredSize(new Dimension(300, 200));
    setSize(getPreferredSize());
    setImageSize(getPreferredSize());
  }

  /**
   * Paints the CisternView, including the PipeView and PumpView components.
   * Synchronizes on the cistern's newPipes and newPumps lists to safely update the display.
   *
   * @param g the Graphics object to protect
   */
  @Override
  public void paint(Graphics g) {
    // Synchronize on the cistern's newPipes list to safely update pipe views.
    synchronized (cistern.newPipes) {
      // Remove all existing PipeView components.
      for (var pipeView : pipeViews) {
        remove(pipeView);
      }
      pipeViews.clear();

      // Add new PipeView components for each pipe in the cistern's newPipes list.
      int xPosition = 0;
      for (var pipe : cistern.newPipes) {
        PipeView pipeView = new PipeView(pipe, gridView);
        pipeView.setLocation(xPosition, 40); // Place pipes at the top
        pipeViews.add(pipeView);
        add(pipeView);
        xPosition += 40; // Increment xPosition for the next PipeView
      }
    }

    // Synchronize on the cistern's newPumps list to safely update pump views.
    synchronized (cistern.newPumps) {
      // Remove all existing PumpView components.
      for (var pumpView : pumpViews) {
        remove(pumpView);
      }
      pumpViews.clear();

      // Add new PumpView components for each pump in the cistern's newPumps list.
      int xPosition = 0;
      for (var pump : cistern.newPumps) {
        PumpView pumpView = new PumpView(pump, gridView);
        pumpView.setLocation(xPosition, 0); // Place pumps 40 pixels below the pipes
        pumpViews.add(pumpView);
        add(pumpView);
        xPosition += 40; // Increment xPosition for the next PumpView
      }
    }

    // Revalidate and repaint the view to ensure the new components are displayed.
    revalidate();
    repaint();
    super.paint(g);
  }
}