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

// insert pump at player controller -> grid controller
// implemnet anchoring using percentages
// at Element view maybe you have percentages you keep

public class GridView extends JImage {
  Grid grid;
  GridController controller;
  SpringView springView;
  CisternView cisternView;
  List<PumpView> pumpViews = new ArrayList<>();
  List<PipeView> pipeViews = new ArrayList<>();
  public ElementView selectedElementView;
  public ActiveElementView selectedActiveElementView;
  public PumpView selectedPumpView;
  public PipeView selectedPipeView;

  public GridView(Grid grid) {
    super("/Images/texture.png");
    this.grid = grid;
    controller = new GridController(grid, this);
    springView = new SpringView(grid.spring, this);
    cisternView = new CisternView(grid.cistern, this);

    for (var pipe : grid.pipes) {
      pipeViews.add(new PipeView(pipe, this));
    }
    
    for (var pump : grid.pumps) {
      pumpViews.add(new PumpView(pump, this));
    }

    cisternView.addNeighborView(pipeViews.get(0));
    pumpViews.get(0).addNeighborView(pipeViews.get(0));

    springView.addNeighborView(pipeViews.get(1));
    pumpViews.get(0).addNeighborView(pipeViews.get(1));

    
    setLayout(null);
    add(springView);
    add(cisternView);
    for(var pumpView : pumpViews){ add(pumpView);}
    for(var pipeView : pipeViews){ add(pipeView);}

    for(var pumpView : pumpViews){ 
      pumpView.setLocation(
        600,
        600
      );
    }

    setFocusable(true);
  }

  @Override
  public void paint(Graphics g) {

    super.paint(g);
    
    // In the future here we will just call repaint
    // Because we will have to implement percantages
    // As locatoin
    Dimension size = getSize();

    springView.setLocation(
      0, 
      size.height / 2 - springView.getHeight() / 2 
    );

    cisternView.setLocation(
      size.width - cisternView.getWidth(),
      size.height / 2 - cisternView.getHeight() / 2 
    );
    
    for(var pumpView : pumpViews){ 
      pumpView.setLocation(pumpView.getLocation());
    }

    
    this.setImageSize(getSize());
    // for(var pumpView : pumpViews){ 
    //   pumpView.setLocation(
    //     getWidth()/3 - pumpView.getWidth()/2,
    //     getHeight()/3 - pumpView.getHeight()/2
    //   );
    // }

  }
}
