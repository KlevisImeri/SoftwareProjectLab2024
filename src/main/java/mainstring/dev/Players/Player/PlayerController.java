package mainstring.dev.Players.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import mainstring.dev.Elements.ActiveElements.Pump.PumpView;

public class PlayerController implements KeyListener, MouseListener {
  Player player;
  PlayerView view;

  public PlayerController(Player player, PlayerView view) {
    this.player = player;
    this.view = view;

    view.addKeyListener(this);
    view.addMouseListener(this);
  }

  @Override
  public void mouseClicked(MouseEvent e) {}

  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}

  @Override
  public void keyTyped(KeyEvent e) {
    try {
      switch (e.getKeyChar()) {
        case 'm':
          player.move();
          // ore you can set it up se yuu repaint the whole thing
          view.location.remove(view);
          view.location.playerViews.remove(view);
          view.location = view.location.gridView.selectedElementView;
          view.location.add(view);
          view.location.playerViews.add(view);
          view.location.gridView.repaint();
          break;
        case 'D':
          player.changePumpDirection();
          ((PumpView) view.location).changeDirectionViews();
          break;
      }

    } catch (Exception exp) {
      exp.printStackTrace();
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {}

  @Override
  public void keyReleased(KeyEvent e) {}


}
