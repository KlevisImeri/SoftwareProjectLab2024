package mainstring.dev.Elements.ActiveElements.Pump;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElementView;
import mainstring.dev.Elements.Pipe.PipeView;
import mainstring.dev.Grid.GridView;

public class PumpView extends ActiveElementView {
  Pump pump;
  String healthyImage = "/Images/pump.png";
  String brokenImage = "/Images/brokenpump.png";
  Boolean sizeSet = false;

  public PipeView inView;
  public PipeView outView;

  public PumpView(Pump pump, GridView gridView) {
    super(pump, "/Images/pump.png", gridView);
    this.pump = pump;
    new PumpController(pump, this);

    setPreferredSize(new Dimension(40, 40));
    setSize(getPreferredSize());
    setImageSize(getPreferredSize());
  }

  public void setInPipeView(PipeView view) {
    addNeighborView(view);
    inView = view;
  }

  public void setOutPipeView(PipeView view) {
    addNeighborView(view);
    outView = view;
  }

  public void changeDirectionViews() {
    inView = gridView.previousSelectPipeView;
    outView = gridView.selectedPipeView;
  }

  @Override
  public void paint(Graphics g) {
    if (pump.isHealthy()) {
      setBackgroundImage(healthyImage);
    } else {
      setBackgroundImage(brokenImage);
    }
    if (pump.hasNeighbor() && !sizeSet) {
      setPreferredSize(new Dimension(200, 200));
      setSize(getPreferredSize());
      setImageSize(100, 100);
      setImageLocation(50, 50);
      sizeSet = true;
    }

    super.paint(g);
    Point center = new Point(getX() + getWidth() / 2, getY() + getHeight() / 2);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.GREEN);
    g2d.setStroke(new BasicStroke(5));
    g2d.setFont(new Font("Arial", Font.BOLD, 50));

    if (inView != null) {
      Point inPipeCenter =
          new Point(inView.getX() + inView.getWidth() / 2, inView.getY() + inView.getHeight() / 2);

      double dx = inPipeCenter.x - center.x;
      double dy = inPipeCenter.y - center.y;

      String inDirection = "←";

      double angle = Math.atan2(dy, dx);

      AffineTransform oldTransform = g2d.getTransform();

      g2d.rotate(angle, getWidth() / 2 + dx * 0.1, getHeight() / 2 + dy * 0.1);

      //12 is for the size of the font
      g2d.drawString(inDirection, (int) (getWidth() / 2 + dx * 0.1) + 12,
          (int) (getHeight() / 2 + dy * 0.1) + 12);

      g2d.setTransform(oldTransform);
    }

    if (outView != null) {
      Point outPipeCenter = new Point(outView.getX() + outView.getWidth() / 2,
          outView.getY() + outView.getHeight() / 2);

      double dx = outPipeCenter.x - center.x;
      double dy = outPipeCenter.y - center.y;

      String outDirection = "→";

      double angle = Math.atan2(dy, dx);

      AffineTransform oldTransform = g2d.getTransform();
      
      //12 is for the size of the font
      g2d.rotate(angle, getWidth() / 2 + dx * 0.1, getHeight() / 2 + dy * 0.1);
      g2d.drawString(outDirection, (int) (getWidth() / 2 + dx * 0.1) + 12,
          (int) (getHeight() / 2 + dy * 0.1) + 12);

      g2d.setTransform(oldTransform);
    }

  }
}
