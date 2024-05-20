package mainstring.dev.Players.Plumber;

import mainstring.dev.Elements.Element.ElementView;
import mainstring.dev.Players.Player.PlayerView;

public class PlumberView extends PlayerView {
  public PlumberView(Plumber plubmer, ElementView location) {
    super(plubmer,"/Images/plumer.png", location);
    new PlumberController(plubmer, this);
  }
}
