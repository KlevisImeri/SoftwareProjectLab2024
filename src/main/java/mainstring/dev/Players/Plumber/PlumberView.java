package mainstring.dev.Players.Plumber;


import mainstring.dev.Elements.ActiveElements.Pump.PumpView;
import mainstring.dev.Elements.Element.ElementView;
import mainstring.dev.Elements.Pipe.PipeView;
import mainstring.dev.Players.Player.PlayerView;

public class PlumberView extends PlayerView {
  Plumber plumber;
  ElementView location;

  PipeView carryPipeView;
  PumpView carryPumpView;

  public PlumberView(Plumber plumber, ElementView location) {
    super(plumber, "/Images/plumer.png", location);
    this.plumber = plumber;
    this.location = location;
    new PlumberController(plumber, this);
  }
}
