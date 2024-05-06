package mainstring.dev.Elements.ActiveElements.Pump;

import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElementView;

public class PumpView extends ActiveElementView {
  Pump pump;
  String healthyImage = "/Images/pump.png";
  String brokenImage = "/Images/brokenpump.png";

  public PumpView(Pump pump) {
    super(pump, "/Images/pump.png");
    this.pump = pump;
  }
}
