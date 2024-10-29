package mainstring.dev.Elements.Pipe;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The PipeController class is responsible for handling mouse and component events
 * for a Pipe element. It implements the ComponentListener and MouseListener interfaces
 * to respond to various events related to the PipeView.
 */
public class PipeController implements ComponentListener, MouseListener {
  // The Pipe instance being controlled.
  Pipe pipe;

  // The view associated with the Pipe.
  PipeView view;

  /**
   * Constructs a PipeController with the specified Pipe and PipeView.
   * Adds this controller as a component listener and mouse listener to the view.
   *
   * @param pipe the Pipe to control
   * @param view the PipeView associated with the Pipe
   */
  public PipeController(Pipe pipe, PipeView view) {
    this.pipe = pipe;
    this.view = view;

    // Add this controller as a MouseListener and ComponentListener to the view.
    view.addMouseListener(this);
  }

  /**
   * Invoked when the component's size changes.
   * Adjusts the size of the view to match the size of its parent and repaints the view.
   *
   * @param e the event to be processed
   */
  @Override
  public void componentResized(ComponentEvent e) {
    view.setSize(view.getParent().getSize());
    view.repaint();
  }

  // These methods are required by the ComponentListener interface, but are not used in this implementation.
  @Override
  public void componentMoved(ComponentEvent e) {}

  @Override
  public void componentShown(ComponentEvent e) {}

  @Override
  public void componentHidden(ComponentEvent e) {}

  /**
   * Invoked when the mouse button has been clicked (pressed and released) on a component.
   * Sets the selected pipe in the grid and updates the selected view.
   *
   * @param e the event to be processed
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    pipe.grid.setSelectedPipe(pipe);
    view.gridView.selectedElementView = view;
    view.gridView.previousSelectPipeView = view.gridView.selectedPipeView;
    view.gridView.selectedPipeView = view;
  }

  // These methods are required by the MouseListener interface, but are not used in this implementation.
  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}

}
