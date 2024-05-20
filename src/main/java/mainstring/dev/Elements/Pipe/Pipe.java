package mainstring.dev.Elements.Pipe;

import javax.swing.Timer;
import mainstring.dev.Output;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElement;
import mainstring.dev.Elements.Element.Element;
import mainstring.dev.Grid.Grid;


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
    EMPTY, FULL
  }

  private PipeHealthState healthState = PipeHealthState.HEALTHY; // Current health state of the pipe
  private PipeFlowState flowState = PipeFlowState.EMPTY; // Current flow state of the pipe

  @Override
  public String toString() {
    return "p,%s,%s,%s".formatted(super.toString(), healthState, flowState);
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
    capacityOfNeighbors = 2;
    capacityOfPlayers = 1;
  }

  /**
   * Sets the pipe's health state to LEAKING, indicating damage.
   */
  public void puncture() {
    String before = toString();
    healthState = PipeHealthState.LEAKING;
    if (flowState == PipeFlowState.FULL) {
      flowState = PipeFlowState.EMPTY;
      grid.addWaterToDesert();
    }
    Output.printChange(before, toString());
    updateViews();
  }

  /**
   * Fixes the pipe, potentially setting its health state from LEAKING to HEALTHY. Implementation
   * details are not provided, so additional logic may be needed.
   */
  public void fix() {
    String before = this.toString();
    healthState = PipeHealthState.HEALTHY;
    Output.printChange(before, this.toString());
    updateViews();
  }

  /**
   * Fills the pipe with water, changing its flow state to FULL. If the pipe is leaking, water is
   * added to the desert grid instead. After filling the pipe, the method triggers the flow of water
   * from the initiating active element to its neighboring pipes.
   * 
   * @param initiator The active element that initiated the flow of water into this pipe.
   */
  public void fill(ActiveElement iniciator) {
    String before = toString();
    if (healthState == PipeHealthState.LEAKING) {
      grid.addWaterToDesert();
    } else {
      flowState = PipeFlowState.FULL;
    }
    Output.printChange(before, toString());
    updateViews();
    Timer timer = new Timer(100, e -> {
      if (iniciator == null ||  getOtherNeighbor(iniciator)== null) {
        return; // grid set it up
      }
      getOtherNeighbor(iniciator).Flow(this);
    });
    timer.setRepeats(false); // Ensure it only runs once
    timer.start();
  }

  /**
   * Empties the pipe, setting its flow state to EMPTY.
   */
  public void empty() {
    String before = toString();
    flowState = PipeFlowState.EMPTY;
    Output.printChange(before, toString());
    updateViews();
  }

  /**
   * Checks if the pipe is full.
   * 
   * @return true if the pipe's flow state is FULL, false otherwise.
   */
  public boolean isFull() {
    return flowState == PipeFlowState.FULL;
  }

  public boolean isHealthy() {
    return this.healthState == PipeHealthState.HEALTHY;
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

  /**
   * p Retrieves the neighboring active element that is not equal to the specified active element.
   * 
   * @param e The active element for which to find the other neighboring active element.
   * @return The neighboring active element that is not equal to the specified active element, or
   *         null if no such element is found.
   */
  private ActiveElement getOtherNeighbor(ActiveElement e) {
    for (Element elem : getNeighbors()) {
      if (elem != e)
        return (ActiveElement) elem;
    }
    return null;
  }
}
