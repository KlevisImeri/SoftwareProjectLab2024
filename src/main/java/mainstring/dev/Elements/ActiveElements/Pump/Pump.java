package mainstring.dev.Elements.ActiveElements.Pump;


import java.util.Timer;
import java.util.TimerTask;
import mainstring.dev.Output;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElement;
import mainstring.dev.Elements.Pipe.Pipe;
import mainstring.dev.Grid.Grid;
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
      totalWater++;
    }

    /**
     * Decreases the total water in the reservoir by one unit. Simulates removing water from the
     * reservoir.
     */
    public void removeWater() {
      totalWater--;
    }

    /**
     * Returns a string representation of the reservoir.
     *
     * @return A string representing the reservoir, including its capacity and total water.
     */
    @Override
    public String toString() {
      return "[R,%s,%s]".formatted(capacity, totalWater);
    }
  }


  public PumpState state = PumpState.HEALTHY; // The current operational state of the pump
  private Reservoir reservoir = new Reservoir(); // The reservoir associated with this pump
  private Pipe in; // The input pipe connected to this pump
  private Pipe out; // The output pipe connected to this pump
  private Timer timer = new Timer(); // A timer used to schedule pump failure simulations

  /**
   * Returns a string representation of the pump, including its state, reservoir details, and
   * connected pipes.
   *
   * @return A string representing the pump, including its state, reservoir details, and connected
   *         pipes.
   */
  @Override
  public String toString() {
    return "P,%s,%s,%s,%s,%s".formatted(super.toString(), reservoir, state,
        in != null ? Integer.toString(in.hashCode()) : "null",
        out != null ? Integer.toString(out.hashCode()) : "null");
  }

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
    // This is turn off for prototype
    // schedulePipeBreak();
  }

  /**
   * Associates an input pipe with this pump and sets it as a neighboring element.
   * 
   * @param pipe The pipe to be set as the input for this pump.
   */
  public void setInPipe(Pipe pipe) throws Exception {
    String before = toString();
    if (!isConnected(pipe))
      addNeighbor(pipe);
    this.in = pipe;
    Output.printChange(before, toString());
  }

  /**
   * Associates an output pipe with this pump and sets it as a neighboring element.
   * 
   * @param pipe The pipe to be set as the output for this pump.
   */
  public void setOutPipe(Pipe pipe) throws Exception {
    String before = toString();
    if (!isConnected(pipe))
      addNeighbor(pipe);
    this.out = pipe;
    Output.printChange(before, toString());
  }

  /**
   * Simulates repairing the pump, potentially changing its state from BROKEN to HEALTHY.
   */
  public void fix() {
    String before = toString();
    state = PumpState.HEALTHY;
    Output.printChange(before, toString());
  }

  /**
   * Changes the direction of the pump by setting new input and output pipes based on the selected
   * pipe. If the selected pipe is far away or not connected, it throws an exception.
   * 
   * @throws Exception If the selected pipe is far away or not connected.
   */
  public void changeDirection() {
    try {
      grid.setSelectedPipe();
      if (isConnected(grid.getSelectedPipe())) {
        setInPipe(grid.getSelectedPipe());
      } else {
        throw new Exception("[The selected Pipe is far away]");
      }
      grid.setSelectedPipe();
      if (isConnected(grid.getSelectedPipe())) {
        setOutPipe(grid.getSelectedPipe());
      } else {
        throw new Exception("[The selected Pipe is far away]");
      }
    } catch (Exception e) {
      Output.println(e.getMessage(), Color.LIGHT_RED);
    }
  }

  /**
   * Manages the flow of water through the pump based on its current state. If the input pipe is
   * full, the pump will attempt to transfer water depending on whether it is healthy or broken. In
   * the case of a healthy pump, water is moved from the input pipe to the output pipe. If the pump
   * is broken, water is stored in the reservoir. This process simulates a realistic operation of a
   * pump, taking into account potential failures and the need for a reservoir.
   */
  @Override
  public void Flow(Pipe iniciator) {
    if (iniciator != in)
      return;
    String before = this.toString();
    if (in.isFull()) {
      if (state == PumpState.BROKEN || out.isFull()) {
        // If the pump is broken and the input pipe is full, water is added to the reservoir or
        // If the out pipe is full water is added to the reservoir;
        in.empty();
        reservoir.addWater();
      } else {
        // If the pump is healthy and the input pipe is full, water is transferred to the output
        // pipe
        in.empty();
        Output.printChange(before, this.toString());
        out.fill(this);
      }
    } else {
      if (state != PumpState.BROKEN && reservoir.totalWater != 0) {
        // If the pump is healthy and the reservoir is not empty, water is
        // removed from the reservoir and transferred to the output pipe
        reservoir.removeWater();
        Output.printChange(before, this.toString());
        out.fill(this);
      }
    }

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

