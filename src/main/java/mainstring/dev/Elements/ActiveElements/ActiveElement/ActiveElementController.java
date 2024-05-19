package mainstring.dev.Elements.ActiveElements.ActiveElement;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActiveElementController implements MouseListener {
  ActiveElement activeElement;
  ActiveElementView view;

  public ActiveElementController(ActiveElement activeElement, ActiveElementView view) {
    this.activeElement = activeElement;
    this.view = view;

    view.addMouseListener(this);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    activeElement.grid.setSelectedActiveElement(activeElement);
  }

  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}

}
