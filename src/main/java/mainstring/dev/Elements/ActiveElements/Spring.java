package mainstring.dev.Elements.ActiveElements;

import mainstring.dev.Elements.*;

public class Spring extends ActiveElement {
  @Override
  public void Flow(){
    for (Element neighbor : neighbors) {
      ((Pipe)neighbor).fill();
    }
  }
}
