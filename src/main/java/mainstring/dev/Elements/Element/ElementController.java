package mainstring.dev.Elements.Element;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ElementController implements MouseListener {
  Element element;
  ElementView view;

  public ElementController(Element element, ElementView view) {
    this.element = element;
    this.view = view;

    view.addMouseListener(this);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    element.grid.setSelectedElement(element);
    view.gridView.selectedElementView = view;
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
