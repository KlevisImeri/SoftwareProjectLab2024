package mainstring.dev.Elements.ActiveElements;

import java.util.Random;
import mainstring.dev.Elements.Element;
import mainstring.dev.Elements.Pipe;
import mainstring.dev.Grid;


/**
 * Represents an abstract base class for active elements within the grid. Active elements are those
 * that can initiate actions, such as flowing water in the context of this simulation. This class
 * extends the {@link Element} class, setting a specific focus on interactions with {@link Pipe}
 * elements as neighbors.
 */
public abstract class ActiveElement extends Element {

  /**
   * Random number generator for use in subclasses to introduce variability in behavior, such as
   * determining flow dynamics or scheduling events.
   */
  protected Random random = new Random();

  /**
   * Constructs an ActiveElement with a specified grid context. This constructor initializes the
   * element within the given grid and sets its neighbor type to {@link Pipe}, indicating that its
   * interactions are primarily with Pipe elements.
   *
   * @param grid The grid within which this active element exists.
   */
  public ActiveElement(Grid grid) {
    super(grid);
    neighborType = Pipe.class;
  }

  /**
   * Abstract method that defines the flow behavior of the active element. Implementing classes must
   * provide a specific implementation of how the element interacts with its environment,
   * particularly in terms of moving or processing water within the grid.
   */
  public abstract void Flow(Pipe iniciator);
}
