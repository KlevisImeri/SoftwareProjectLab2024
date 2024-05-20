package mainstring.dev.Players.Plumber;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
          break;
        case 'c':
          plumber.connectPipe();
          break;
        case 'f':
          plumber.fix();
          break;
        case 'i':
          plumber.insertPump();
          break;
        case 'p':
          plumber.pickPump();
          break;
        case 'P':
          plumber.pickPipe();
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
