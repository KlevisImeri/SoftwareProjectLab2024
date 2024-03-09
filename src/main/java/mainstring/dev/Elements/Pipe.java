package mainstring.dev.Elements;

import  mainstring.dev.Elements.ActiveElements.*;

public class Pipe extends Element {
  public enum PipeState {
    HEALTHY, LEAKING
  }
  int state;
  public void onMouseClick(){}
  public void puncture(){} //used
  public void fix() {} //used
  public Element getNext(Element element){return element;} //used ?? not implmented
}
