package mainstring.dev.Elements.ActiveElements.ActiveElement;

import mainstring.dev.Elements.Element.ElementView;
import mainstring.dev.Grid.GridView;

public class ActiveElementView extends ElementView {
  
  public ActiveElementView(ActiveElement element, String image, GridView gridView) {
    super(element, image, gridView);
    new ActiveElementController(element, this);
  }
}
