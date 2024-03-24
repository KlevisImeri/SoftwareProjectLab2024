package mainstring.dev.Elements.ActiveElements;

import mainstring.dev.Elements.*;
import mainstring.dev.*;
import mainstring.dev.Output.Color;


public class Spring extends ActiveElement {
  public Spring(Grid grid) {
    super(grid);
    System.out.println("Spring()");
  }

  @Override
  public void Flow() {
    Output.println(
        "|----------------5.2.14.2 Calculation of the flow at a spring-----------------|",
        Color.LIGHT_BLUE);
        System.out.println("Flow()");
    for (Element neighbor : neighbors) {
      ((Pipe) neighbor).fill();
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  public String type() {
    return "spring";
  }
}
