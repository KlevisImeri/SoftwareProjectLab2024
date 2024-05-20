package mainstring.dev.Players.Saboteur;

import mainstring.dev.Elements.Element.ElementView;
import mainstring.dev.Players.Player.PlayerView;

public class SaboteurView extends PlayerView {
  public SaboteurView(Saboteur saboteur, ElementView location) {
    super(saboteur, "/Images/saboteur.png", location);
    new SaboteurController(saboteur, this);
  }
}
