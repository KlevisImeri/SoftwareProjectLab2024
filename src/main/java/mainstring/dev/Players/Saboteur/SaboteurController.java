package mainstring.dev.Players.Saboteur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SaboteurController implements KeyListener {
  Saboteur saboteur;
  SaboteurView view;

  public SaboteurController(Saboteur saboteur, SaboteurView view) {
    this.saboteur = saboteur;
    this.view = view;

    view.addKeyListener(this);
  }

  @Override
  public void keyTyped(KeyEvent e) {
    try {
      switch (e.getKeyChar()) {
        case 'p':
          saboteur.puncturePipe();
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
