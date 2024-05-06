package mainstring.dev.Elements.ActiveElements.Cistern;

import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElementView;

public class CisternView extends ActiveElementView {
  Cistern cistern;

  public CisternView(Cistern cistern) {
    super(cistern, "/Images/cistern.png");
    this.cistern = cistern;
  }
}
