package mainstring.dev.Grid;

/**
 * The GridController class is responsible for managing the interactions
 * and logic related to the Grid and its view. This includes handling user actions
 * and updating the view as needed.
 */
public class GridController {
  // The Grid instance being controlled.
  Grid grid;

  // The view associated with the Grid.
  GridView view;

  /**
   * Constructs a GridController with the specified Grid and GridView.
   *
   * @param grid the Grid to control
   * @param view the GridView associated with the Grid
   */
  public GridController(Grid grid, GridView view) {
    this.grid = grid;
    this.view = view;
  }
}