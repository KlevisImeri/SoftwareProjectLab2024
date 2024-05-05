package mainstring.dev.Grid;

import javax.swing.JPanel;

public class GridView extends JPanel {
  Grid grid;
  GridController controller;

  public GridView(Grid grid) {
    this.grid = grid;
    controller = new GridController(grid, this);
  }
}
