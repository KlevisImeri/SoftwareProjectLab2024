package mainstring.dev.Grid;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import mainstring.dev.JImage;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElementView;
import mainstring.dev.Elements.ActiveElements.Cistern.CisternView;
import mainstring.dev.Elements.ActiveElements.Pump.PumpView;
import mainstring.dev.Elements.ActiveElements.Spring.SpringView;
import mainstring.dev.Elements.Element.ElementView;
import mainstring.dev.Elements.Pipe.PipeView;

/**
 * The GridView class extends JImage to provide a visual representation
 * of the grid. It manages the display of various elements like springs,
 * cisterns, pumps, and pipes, and handles their positioning and rendering.
 */
public class GridView extends JImage {
  // The Grid instance being represented by this view.
  Grid grid;

  // The controller responsible for handling interactions with the grid.
  GridController controller;

  // Views for the spring, cistern, pumps, and pipes.
  SpringView springView;
  CisternView cisternView;
  public List<PumpView> pumpViews = new ArrayList<>();
  public List<PipeView> pipeViews = new ArrayList<>();

  // Currently selected elements and views.
  public ElementView selectedElementView;
  public ActiveElementView selectedActiveElementView;
  public PumpView selectedPumpView;
  public PipeView previousSelectPipeView;
  public PipeView selectedPipeView;

  /**
   * Constructs a GridView with the specified Grid.
   * Initializes the views for the spring, cistern, pumps, and pipes,
   * and sets up their initial layout and connections.
   *
   * @param grid the Grid associated with this view
   */
  public GridView(Grid grid) {
    super("/Images/texture.png");
    this.grid = grid;
    controller = new GridController(grid, this);
    springView = new SpringView(grid.spring, this);
    cisternView = new CisternView(grid.cistern, this);

    // Initialize pipe views.
    for (var pipe : grid.pipes) {
      pipeViews.add(new PipeView(pipe, this));
    }
    
    // Initialize pump views.
    for (var pump : grid.pumps) {
      pumpViews.add(new PumpView(pump, this));
    }

    // Set up initial connections.
    cisternView.addNeighborView(pipeViews.get(0));
    pumpViews.get(0).setOutPipeView(pipeViews.get(0));

    springView.addNeighborView(pipeViews.get(1));
    pumpViews.get(0).setInPipeView(pipeViews.get(1));

    // Set the layout and add all views.
    setLayout(null);
    add(springView);
    add(cisternView);
    for(var pumpView : pumpViews){ add(pumpView);}
    for(var pipeView : pipeViews){ add(pipeView);}

    // Set the initial location for pumps.
    for(var pumpView : pumpViews){ 
      pumpView.setLocation(
        600,
        600
      );
    }

    setFocusable(true);
  }

  /**
   * Paints the GridView, including all its elements.
   * Updates the locations of the spring, cistern, and pumps.
   *
   * @param g the Graphics object to protect
   */
  @Override
  public void paint(Graphics g) {

    super.paint(g);
    
    // Update the locations of the spring and cistern based on the current size of the view.
    Dimension size = getSize();

    springView.setLocation(
      0, 
      size.height / 2 - springView.getHeight() / 2 
    );

    cisternView.setLocation(
      size.width - cisternView.getWidth(),
      size.height / 2 - cisternView.getHeight() / 2 
    );
    
    // Ensure the pumps maintain their set locations.
    for(var pumpView : pumpViews){ 
      pumpView.setLocation(pumpView.getLocation());
    }


    // Adjust the image size to match the current size of the view.
    this.setImageSize(getSize());
    // for(var pumpView : pumpViews){ 
    //   pumpView.setLocation(
    //     getWidth()/3 - pumpView.getWidth()/2,
    //     getHeight()/3 - pumpView.getHeight()/2
    //   );
    // }

  }
}
