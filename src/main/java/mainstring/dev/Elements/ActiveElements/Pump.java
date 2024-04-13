package mainstring.dev.Elements.ActiveElements;


// import mainstring.dev.Grid;
import mainstring.dev.Elements.Pipe;
// import mainstring.dev.UI.GUI.PumpGUI;
// import java.awt.event.ActionListener;
// import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import mainstring.dev.Grid;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;

/**
 * Represents a pump within a water flow simulation, capable of transferring water from an input to
 * an output pipe. The pump can be in either a healthy or broken state, affecting its ability to
 * transfer water. It features an internal reservoir to store water when the pump is broken. The
 * pump's state can change randomly, simulating real-life pump reliability issues.
 *
 * This class demonstrates an understanding of event-driven programming by potentially implementing
 * ActionListener and MouseListener for GUI interactions, enabling direct manipulation and
 * observation of pump behavior within a graphical user interface.
 */
public class Pump extends ActiveElement {

  /**
   * Enumerates the possible states of the pump, indicating its operational status.
   */
  public enum PumpState {
    HEALTHY, BROKEN
  }

  /**
   * Inner class representing a reservoir within the pump. The reservoir is used to store water when
   * the pump is in a broken state, preventing water flow through the pump.
   */
  class Reservoir {
    public int capacity = 10; // The maximum amount of water the reservoir can hold
    public int totalWater = 0; // The current amount of water in the reservoir

    /**
     * Increases the total water in the reservoir by one unit. Simulates adding water to the
     * reservoir.
     */
    public void addWater() {
      System.out.println("addWater()");
      totalWater++;
    }

    /**
     * Decreases the total water in the reservoir by one unit. Simulates removing water from the
     * reservoir.
     */
    public void removeWater() {
      System.out.println("removeWater()");
      totalWater--;
    }
  }

  
  public PumpState state = PumpState.HEALTHY; // The current operational state of the pump
  private Reservoir reservoir = new Reservoir(); // The reservoir associated with this pump
  private Pipe in; // The input pipe connected to this pump
  private Pipe out; // The output pipe connected to this pump
  private Timer timer = new Timer(); // A timer used to schedule pump failure simulations


  /**
   * A scheduled task that simulates the pump breaking down. When executed, it changes the pump's
   * state to BROKEN and schedules another execution to simulate future failures.
   */
  private class PipeBreakTask extends TimerTask {
    @Override
    public void run() {
      state = PumpState.BROKEN;
      schedulePipeBreak();
    }
  }
  
  /**
   * Schedules the next pump failure simulation, randomly determining the time until the pump breaks
   * down again.
   */
  private void schedulePipeBreak() {
    long delay = (long) (Math.random() * 11) * 1000; // Random delay between 0 and 10 seconds
    timer.schedule(new PipeBreakTask(), delay);
  }

  /**
   * Constructs a new Pump object, associates it with a grid, and initializes the failure simulation
   * mechanism.
   * 
   * @param grid The grid within which the pump is located.
   */
  public Pump(Grid grid) {
    super(grid);
    schedulePipeBreak();
  }

  /**
   * Associates an input pipe with this pump and sets it as a neighboring element.
   * 
   * @param pipe The pipe to be set as the input for this pump.
   */
  public void setInPipe(Pipe pipe) {
    System.out.println("setInPipe()");
    addNeighbor(pipe);
    this.in = pipe;
  }

  /**
   * Associates an output pipe with this pump and sets it as a neighboring element.
   * 
   * @param pipe The pipe to be set as the output for this pump.
   */
  public void setOutPipe(Pipe pipe) {
    System.out.println("setOutPipe()");
    addNeighbor(pipe);
    this.out = pipe;
  }

  /**
   * Simulates repairing the pump, potentially changing its state from BROKEN to HEALTHY.
   */
  public void fix() {
    System.out.println("fix()");
    // The implementation of pump repair logic goes here
  }

  /**
   * Changes the direction of water flow through the pump. This could involve swapping the input and
   * output pipes, but the specifics are not defined in this method's body.
   */
  public void changeDirection() {
    System.out.println("changeDirection()");
    // The implementation of flow direction change logic goes here
  }

  /**
   * Manages the flow of water through the pump based on its current state. If the input pipe is
   * full, the pump will attempt to transfer water depending on whether it is healthy or broken. In
   * the case of a healthy pump, water is moved from the input pipe to the output pipe. If the pump
   * is broken, water is stored in the reservoir. This process simulates a realistic operation of a
   * pump, taking into account potential failures and the need for a reservoir.
   */
  @Override
  public void Flow() {
    Output.println("|----------------5.2.14.2 Calculation of the flow at a pump-----------------|",
        Color.LIGHT_BLUE);
    System.out.println("Flow()");
    if (in.isFull()) {
      if (state == PumpState.BROKEN) {
        // If the pump is broken and the input pipe is full, water is added to the reservoir
        reservoir.addWater();
      } else {
        // If the pump is healthy and the input pipe is full, water is transferred to the output
        // pipe
        out.fill();
      }
      // After handling water transfer, the input pipe is emptied
      in.empty();
    } else {
      if (state != PumpState.BROKEN && reservoir.capacity != reservoir.totalWater) {
        // If the pump is healthy and the reservoir is not full, water is removed from the reservoir
        // and transferred to the output pipe
        reservoir.removeWater();
        out.fill();
      }
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  /**
   * Returns a string identifier for the pump, useful for debugging and logging.
   * 
   * @return A string that identifies this specific element as a pump.
   */
  @Override
  public String type() {
    return "pump";
  }
}

