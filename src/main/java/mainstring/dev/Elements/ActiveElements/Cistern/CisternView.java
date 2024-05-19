package mainstring.dev.Elements.ActiveElements.Cistern;

import java.awt.Dimension;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElementView;
import mainstring.dev.Grid.GridView;

public class CisternView extends ActiveElementView {
  Cistern cistern;

  public CisternView(Cistern cistern, GridView gridView) {
    super(cistern, "/Images/cistern.png", gridView);
    this.cistern = cistern;
    setPreferredSize(new Dimension(300,200));
    setSize(getPreferredSize());
    setImageSize(getPreferredSize());
  }
}
