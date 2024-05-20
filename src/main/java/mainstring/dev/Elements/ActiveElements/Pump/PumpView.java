package mainstring.dev.Elements.ActiveElements.Pump;

import java.awt.Dimension;
import java.awt.Graphics;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElementView;
import mainstring.dev.Grid.GridView;

public class PumpView extends ActiveElementView {
  Pump pump;
  String healthyImage = "/Images/pump.png";
  String brokenImage = "/Images/brokenpump.png";
  Boolean sizeSet = false;

  public PumpView(Pump pump, GridView gridView) {
    super(pump, "/Images/pump.png", gridView);
    this.pump = pump;
    new PumpController(pump, this);

    setPreferredSize(new Dimension(40,40));
    setSize(getPreferredSize());
    setImageSize(getPreferredSize());
  }

  @Override
  public void paintComponent(Graphics g) {
    if(pump.isHealthy()) {
      setBackgroundImage(healthyImage);
    } else {
      setBackgroundImage(brokenImage);
    }
    if(pump.hasNeighbor() && !sizeSet){
      setPreferredSize(new Dimension(200,200));
      setSize(getPreferredSize());
      setImageSize(100,100);
      setImageLocation(50, 50);
      sizeSet = true;
    }
    super.paintComponent(g);
  }
}
