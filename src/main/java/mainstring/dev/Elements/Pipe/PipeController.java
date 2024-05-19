package mainstring.dev.Elements.Pipe;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PipeController implements ComponentListener, MouseListener {
  Pipe pipe;
  PipeView view;

  public PipeController(Pipe pipe, PipeView view) {
    this.pipe = pipe;
    this.view = view;

    view.addMouseListener(this);
  }

  @Override
  public void componentResized(ComponentEvent e) {
    view.setSize(view.getParent().getSize());
    view.repaint();
  }

  @Override
  public void componentMoved(ComponentEvent e) {}

  @Override
  public void componentShown(ComponentEvent e) {}

  @Override
  public void componentHidden(ComponentEvent e) {}

  @Override
  public void mouseClicked(MouseEvent e) {
    pipe.grid.setSelectedPipe(pipe);
    view.gridView.selectedElementView = view;
    view.gridView.selectedPipeView = view;
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
