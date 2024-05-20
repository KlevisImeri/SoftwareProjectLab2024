package mainstring.dev.Players.Plumber;

import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import mainstring.dev.Elements.ActiveElements.Pump.PumpView;
import mainstring.dev.Elements.Element.ElementView;
import mainstring.dev.Elements.Pipe.Pipe;
import mainstring.dev.Elements.Pipe.PipeView;

public class PlumberController implements KeyListener {
  Plumber plumber;
  PlumberView view;

  public PlumberController(Plumber plumber, PlumberView plumberView) {
    this.plumber = plumber;
    this.view = plumberView;

    view.addKeyListener(this);
  }


  @Override
  public void keyTyped(KeyEvent e) {
    try {
      switch (e.getKeyChar()) {
        case 'd':
          plumber.disconnectPipe();
          view.carryPipeView = view.location.gridView.selectedPipeView;
          view.location.removeNeighborView(view.carryPipeView);
          view.add(view.carryPipeView);
      
          view.repaint();
          view.carryPipeView.repaint();
          break;
        case 'c':
          plumber.connectPipe();
          view.remove(view.carryPipeView);

          view.carryPipeView.addNeighborView(view.location);
          view.location.gridView.add(view.carryPipeView);
        
          view.carryPipeView.repaint();
          //view.location.gridView.repaint();
          view.carryPipeView = null;

          break;
        case 'f':
          plumber.fix();
          break;
        case 'i':
          Pipe pipe = plumber.insertPump();
          PipeView newPipe = new PipeView(pipe, view.location.gridView);
          
          List<ElementView> neighborViews = view.location.neighborViews;

          view.location.removeNeighborView(neighborViews.get(1));
          view.carryPumpView.addNeighborView(newPipe);
          view.carryPipeView.addNeighborView(view.location);
          view.carryPipeView.setLocation(500,500);
          newPipe.addNeighborView(neighborViews.get(1));

          view.location.gridView.add(view.carryPumpView);
          view.location.gridView.repaint();
          // view.location.gridView.add
          // 

          view.carryPumpView = null;
          break;
        case 'p':
          plumber.pickPump();
          view.carryPumpView = new PumpView(plumber.carryPump, view.location.gridView);
          view.add(view.carryPumpView);
          break;
        case 'P':
          plumber.pickPipe();
          view.carryPipeView = new PipeView(plumber.carryPipe, view.location.gridView);
          view.carryPipeView.addNeighborView(view.location);
          view.add(view.carryPipeView);
          break;
      }
    } catch (Exception exp) {
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {}

  @Override
  public void keyReleased(KeyEvent e) {}

}
