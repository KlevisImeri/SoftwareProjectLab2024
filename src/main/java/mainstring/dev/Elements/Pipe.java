package mainstring.dev.Elements;

import mainstring.dev.Elements.ActiveElements.ActiveElement;
import mainstring.dev.Grid;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;

/**
 * Represents a Pipe element within the grid, extending the functionalities of an Element. Pipes can
 * have health states (e.g., healthy or leaking) and flow states (e.g., full or empty), affecting
 * their behavior and interactions within the grid.
 */
public class Pipe extends Element {
  /**
   * Enumerates the possible health states of a Pipe.
   */
  public enum PipeHealthState {
    HEALTHY, LEAKING
  }

  /**
   * Enumerates the possible flow states of a Pipe.
   */
  public enum PipeFlowState {
    FULL, EMPTY
  }

  private PipeHealthState healthState = PipeHealthState.HEALTHY; // Current health state of the pipe
  private PipeFlowState flowState = PipeFlowState.EMPTY; // Current flow state of the pipe

  @Override 
  public String toString() {
    return "p,%s,%s,%s".formatted(super.toString(),healthState,flowState);
  }

  /**
   * Constructs a Pipe element within a specified grid, setting its neighbor type to ActiveElement
   * by default.
   * 
   * @param grid The grid this Pipe element is part of.
   */
  public Pipe(Grid grid) {
    super(grid);
    neighborType = ActiveElement.class;
  }

  /**
   * Sets the pipe's health state to LEAKING, indicating damage.
   */
  public void puncture() {
    healthState = PipeHealthState.LEAKING;
  }

  /**
   * Fixes the pipe, potentially setting its health state from LEAKING to HEALTHY. Implementation
   * details are not provided, so additional logic may be needed.
   */
  public void fix() {
    System.out.print(this);
    healthState = PipeHealthState.HEALTHY;
    Output.print("  ->  ", Color.LIGHT_RED);
    System.out.println(this);
  }

  /**
   * Attempts to fill the pipe with water. If the pipe is LEAKING, water is added to the desert
   * instead. Otherwise, the pipe's flow state is set to FULL.
   */
  public void fill() {
    if (healthState == PipeHealthState.LEAKING) {
      grid.addWaterToDesert();
      return;
    }
    flowState = PipeFlowState.FULL;
  }

  /**
   * Empties the pipe, setting its flow state to EMPTY.
   */
  public void empty() {
    flowState = PipeFlowState.EMPTY;
  }

  /**
   * Checks if the pipe is full.
   * 
   * @return true if the pipe's flow state is FULL, false otherwise.
   */
  public boolean isFull() {
    return flowState == PipeFlowState.FULL;
  }

  /**
   * Returns the type identifier of this element.
   * 
   * @return A string representing the type of this element, "pipe" in this case.
   */
  @Override
  public String type() {
    return "pipe";
  }

}
