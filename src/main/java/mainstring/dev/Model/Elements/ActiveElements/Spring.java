package mainstring.dev.Model.Elements.ActiveElements;

import mainstring.dev.*;
import mainstring.dev.Model.Grid;
import mainstring.dev.Model.Elements.*;
import mainstring.dev.Model.Output.Color;

/**
 * Represents a Spring element within the grid, an active element that can initiate water flow. When
 * activated, the Spring attempts to fill all of its neighboring pipes, simulating the flow of
 * water.
 * <p>
 * This class extends {@link ActiveElement}, inheriting its basic functionalities and properties,
 * particularly in managing neighbors and integrating with the grid's dynamics.
 */
public class Spring extends ActiveElement {

  /**
   * Constructs a new Spring element within the specified grid.
   * <p>
   * Upon creation, it logs its instantiation for debugging purposes.
   * 
   * @param grid The grid within which the Spring element is placed.
   */
  public Spring(Grid grid) {
    super(grid);
  }

  /**
   * Initiates the flow process from the spring, attempting to fill all neighboring pipes. It prints
   * a message to indicate the calculation of the flow is in process, along with a distinctive
   * border and color for emphasis.
   * <p>
   * If a neighbor is a {@link Pipe}, it calls the {@code fill()} method on it, simulating the
   * process of water flowing into pipes from the spring.
   */
  @Override
  public void Flow(Pipe iniciator) {
    System.out.println(this);
    for (Element neighbor : neighbors) {
      ((Pipe) neighbor).fill(this);
    }
  }

  /**
   * Provides the type of this element, useful for identification and debugging within the system.
   * 
   * @return A string representing the type of this element, "spring" in this case.
   */
  @Override
  public String type() {
    return "spring";
  }

  /**
   * Returns a string representation of this object.
   *
   * @return A string representing this object.
   */
  @Override
  public String toString() {
    return "S,%s".formatted(super.toString());
  }
}
