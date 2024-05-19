package mainstring.dev.Elements.ActiveElements.Pump;

import java.awt.Dimension;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElementView;
import mainstring.dev.Grid.GridView;

public class PumpView extends ActiveElementView {
  Pump pump;
  String healthyImage = "/Images/pump.png";
  String brokenImage = "/Images/brokenpump.png";

  public PumpView(Pump pump, GridView gridView) {
    super(pump, "/Images/pump.png", gridView);
    this.pump = pump;
    new PumpController(pump, this);

    setPreferredSize(new Dimension(200,200));
    setSize(getPreferredSize());
    setImageSize(100,100);
    setImageLocation(50, 50);
  }
}
