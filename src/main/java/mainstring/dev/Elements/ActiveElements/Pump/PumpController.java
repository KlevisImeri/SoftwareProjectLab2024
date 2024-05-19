package mainstring.dev.Elements.ActiveElements.Pump;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PumpController implements MouseListener, MouseMotionListener {
  Pump pump;
  PumpView view;

  private volatile int screenX = 0;
  private volatile int screenY = 0;
  private volatile int myX = 0;
  private volatile int myY = 0;

  public PumpController(Pump pump, PumpView view) {
    this.pump = pump;
    this.view = view;

    view.addMouseMotionListener(this);
    view.addMouseListener(this);
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    int deltaX = e.getXOnScreen() - screenX;
    int deltaY = e.getYOnScreen() - screenY;

    view.setLocation(myX + deltaX, myY + deltaY);
  }

  @Override
  public void mouseMoved(MouseEvent e) {}

  @Override
  public void mouseClicked(MouseEvent e) {}

  @Override
  public void mousePressed(MouseEvent e) {
    screenX = e.getXOnScreen();
    screenY = e.getYOnScreen();

    myX = view.getX();
    myY = view.getY();
  }

  @Override
  public void mouseReleased(MouseEvent e) {}

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}
}
