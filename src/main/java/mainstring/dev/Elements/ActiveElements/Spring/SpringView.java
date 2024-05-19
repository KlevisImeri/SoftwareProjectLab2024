package mainstring.dev.Elements.ActiveElements.Spring;

import java.awt.Dimension;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElementView;
import mainstring.dev.Grid.GridView;

public class SpringView extends ActiveElementView {
  Spring spring;

  public SpringView(Spring spring, GridView gridView) {
    super(spring, "/Images/SpringMountain.png", gridView);
    setPreferredSize(new Dimension(230,150));
    setSize(getPreferredSize());
    setImageSize(getPreferredSize());
  }

}
