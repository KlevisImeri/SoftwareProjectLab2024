package mainstring.dev.Players.Plumber;

import java.awt.Dimension;
import java.awt.Point;
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

          view.location.gridView.repaint();
          break;
        case 'c':
          plumber.connectPipe();
          view.remove(view.carryPipeView);

          view.carryPipeView.addNeighborView(view.location);
          view.location.gridView.add(view.carryPipeView);
        
          view.carryPipeView.repaint();
          
          view.carryPipeView = null;
          break;
        case 'f':
          plumber.fix();
          view.location.gridView.repaint();
          break;
        case 'i':
          Pipe pipe = plumber.insertPump();
          // Calculate the midpoint of the current location
          Point locationMid = view.location.getLocation();
          Dimension locationSize = view.location.getSize();
          locationMid.setLocation(
              locationMid.getX() + locationSize.getWidth() / 2,
              locationMid.getY() + locationSize.getHeight() / 2
          );
          view.carryPumpView.setLocation(
              locationMid.x - view.carryPumpView.getWidth() / 2,
              locationMid.y - view.carryPumpView.getHeight() / 2
          );

          PipeView newPipe = new PipeView(pipe, view.location.gridView);

          ElementView neighbor = view.location.neighborViews.get(1);

          view.location.removeNeighborView(neighbor);  
          view.carryPumpView.setOutPipeView((PipeView) view.location);
          view.carryPumpView.setInPipeView(newPipe);
          if(neighbor instanceof PumpView){
            ((PumpView)neighbor).setOutPipeView(newPipe);
          } else {
            System.out.println("Fuck You!");
            neighbor.addNeighborView(newPipe);
          }
          // newPipe.addNeighborView(neighbor);
          
          //order acyllu matters without the z component
          view.location.gridView.add(view.carryPumpView);
          view.location.gridView.setComponentZOrder(view.carryPumpView, 0); 
          view.location.gridView.add(newPipe);

          view.location.gridView.repaint();


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
