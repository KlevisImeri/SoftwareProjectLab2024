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

  PipeHealthState healthState = PipeHealthState.HEALTHY;
  PipeFlowState flowState = PipeFlowState.EMPTY;

  public Pipe(Grid grid) {
    super(grid);
    System.out.println("Pipe()");
    neighborType = ActiveElement.class;
  }


  public void puncture() {
    System.out.println("puncture()");
    healthState = PipeHealthState.LEAKING;
  } 

  public void fix() {
    System.out.println("fix()");
  } 

  public void fill() {
    System.out.println("fill()");
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
    System.out.println("isFull()");
    if (flowState == PipeFlowState.FULL)
      return true;
    return false;
  }

  public String type() {
    return "pipe";
  }

}
