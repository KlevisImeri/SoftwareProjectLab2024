package mainstring.dev.Elements;

import java.awt.List;
import mainstring.dev.Elements.ActiveElements.*;

public class Pipe extends Element {
  public enum PipeState {
    HEALTHY, LEAKING
  }
  int capacity;
  int state;
	List<ActiveElement> vertices;
  public void puncture(){} //used
  public void fix() {} //used
  public void addVertex(ActiveElement activeElement){} //used
  public void removeVertex(ActiveElement activeElement){}//used
  public ActiveElement getTheOtherVertex(ActiveElement activeElement){} //used
}
