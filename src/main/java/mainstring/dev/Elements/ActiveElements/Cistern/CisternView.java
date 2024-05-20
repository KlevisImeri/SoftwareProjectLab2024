package mainstring.dev.Elements.ActiveElements.Cistern;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElementView;
import mainstring.dev.Elements.ActiveElements.Pump.PumpView;
import mainstring.dev.Elements.Pipe.PipeView;
import mainstring.dev.Grid.GridView;

public class CisternView extends ActiveElementView {
  Cistern cistern;
  List<PipeView> pipeViews = new ArrayList<>();
  List<PumpView> pumpViews = new ArrayList<>();

  public CisternView(Cistern cistern, GridView gridView) {
    super(cistern, "/Images/cistern.png", gridView);
    this.cistern = cistern;
    setPreferredSize(new Dimension(300, 200));
    setSize(getPreferredSize());
    setImageSize(getPreferredSize());
  }

  @Override
  public void paint(Graphics g) {
    synchronized (cistern.newPipes) {
      for (var pipeView : pipeViews) {
        remove(pipeView);
      }
      pipeViews.clear();

      int xPosition = 0;
      for (var pipe : cistern.newPipes) {
        PipeView pipeView = new PipeView(pipe, gridView);
        pipeView.setLocation(xPosition, 40); // Place pipes at the top
        pipeViews.add(pipeView);
        add(pipeView, gbc);
        xPosition += 40; // Increment xPosition for the next PipeView
      }
    }

    synchronized (cistern.newPumps) {
      for (var pumpView : pumpViews) {
        remove(pumpView);
      }
      pumpViews.clear();

      int xPosition = 0;
      for (var pump : cistern.newPumps) {
        PumpView pumpView = new PumpView(pump, gridView);
        pumpView.setLocation(xPosition, 0); // Place pumps 40 pixels below the pipes
        pumpViews.add(pumpView);
        add(pumpView, gbc);
        xPosition += 40; // Increment xPosition for the next PumpView
      }
    }

    revalidate();
    repaint();
    super.paint(g);
  }
}

