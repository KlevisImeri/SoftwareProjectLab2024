package mainstring.dev.Elements;

import mainstring.dev.Elements.ActiveElements.ActiveElement;

public class Pipe extends Element {
  public enum PipeState {
    HEALTHY, LEAKING
  }
  int capacity;
  int state;
	ActiveElement endVertex;
	ActiveElement startVertex;
	public void changeDirection(){}
  public void puncurePipe(){}
  public void fixPump() {}
}
