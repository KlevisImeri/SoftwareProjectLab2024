package mainstring.dev.Elements.ActiveElements;

import java.util.Random;
import mainstring.dev.Elements.Element;
import mainstring.dev.Elements.Pipe;
public abstract class ActiveElement extends Element {
  public ActiveElement(){
     neighborType=Pipe.class;
  }
  protected Random random = new Random();
  public abstract void Flow();
}
