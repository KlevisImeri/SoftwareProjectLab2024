package mainstring.dev.Elements;


public class Pipe extends Element {
  public enum PipeHealthState {HEALTHY, LEAKING}
  public enum PipeFlowState {FULL, EMPTY}
  PipeHealthState healthState;
  PipeFlowState flowState;
  public void onMouseClick(){}
  public void puncture(){} //used
  public void fix() {} //used
  public void fill() { 
    if(healthState==PipeHealthState.LEAKING){
      grid.addWaterToDesert();
      return;
    }
    flowState=PipeFlowState.FULL;
  }
  public void empty() {flowState=PipeFlowState.EMPTY;}
  public boolean isFull() {
    if(flowState==PipeFlowState.FULL) return true;
    return false;
  }
}
