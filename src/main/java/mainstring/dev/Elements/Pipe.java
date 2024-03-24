package mainstring.dev.Elements;

import mainstring.dev.Elements.ActiveElements.ActiveElement;

public class Pipe extends Element {
  public enum PipeHealthState {HEALTHY, LEAKING}
  public enum PipeFlowState {FULL, EMPTY}
  PipeHealthState healthState;
  PipeFlowState flowState;
  public Pipe(){
    neighborType=ActiveElement.class;
  }
  public void onMouseClick(){}
  public void puncture(){} //used
  public void fix() {
    healthState=PipeHealthState.HEALTHY;
    System.out.println("Fixed Pipe");

  } //used
  public void fill() { 
    if(healthState==PipeHealthState.LEAKING){
      grid.addWaterToDesert();
      return;
    }
    System.out.println("The pipe is filled");
    flowState=PipeFlowState.FULL;
  }
  public void empty() {flowState=PipeFlowState.EMPTY;}
  public boolean isFull() {
    if(flowState==PipeFlowState.FULL) return true;
    return false;
  }
}
