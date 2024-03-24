package mainstring.dev.Elements;

import mainstring.dev.Elements.ActiveElements.ActiveElement;
import mainstring.dev.Grid;

public class Pipe extends Element {
  public enum PipeHealthState {
    HEALTHY, LEAKING
  }
  public enum PipeFlowState {
    FULL, EMPTY
  }

  PipeHealthState healthState;
  PipeFlowState flowState;

  public Pipe(Grid grid) {
    super(grid);
    System.out.println("Pipe()");
    neighborType = ActiveElement.class;
  }


  public void puncture() {} // used

  public void fix() {
    System.out.println("fix()");
  } 

  public void fill() {
    if (healthState == PipeHealthState.LEAKING) {
      grid.addWaterToDesert();
      return;
    }
    System.out.println("The pipe is filled");
    flowState = PipeFlowState.FULL;
  }

  public void empty() {
    System.out.println("empty()");
    flowState = PipeFlowState.EMPTY;
  }

  public boolean isFull() {
    if (flowState == PipeFlowState.FULL)
      return true;
    return false;
  }

  public String type() {
    return "pipe";
  }

}
