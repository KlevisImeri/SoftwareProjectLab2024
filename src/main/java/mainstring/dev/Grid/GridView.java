package mainstring.dev.Grid;

import javax.swing.JPanel;
import mainstring.dev.Elements.ActiveElements.Cistern.CisternView;
import mainstring.dev.Elements.ActiveElements.Pump.PumpView;
import mainstring.dev.Elements.ActiveElements.Spring.SpringView;
import mainstring.dev.Elements.Pipe.PipeView;

public class GridView extends JPanel {
  Grid grid;
  GridController controller;
  

  public GridView(Grid grid) {
    this.grid = grid;
    controller = new GridController(grid, this);

    add(new CisternView(grid.cistern));
    add(new SpringView(grid.spring));

    for(var pipe : grid.pipes) {
      add(new PipeView(pipe));
    }

    for(var pump : grid.pumps) {
      add(new PumpView(pump));
    }
  }
}
