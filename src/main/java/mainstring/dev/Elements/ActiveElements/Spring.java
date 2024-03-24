package mainstring.dev.Elements.ActiveElements;

import mainstring.dev.Elements.*;
import mainstring.dev.*;


public class Spring extends ActiveElement {
  public Spring(Grid grid) {
    super(grid);
    System.out.println("Spring()");
  }
  @Override
  public void Flow() {
    for (Element neighbor : neighbors) {
      ((Pipe) neighbor).fill();
    }
  }

  public String type() {
    return "spring";
  }
}
