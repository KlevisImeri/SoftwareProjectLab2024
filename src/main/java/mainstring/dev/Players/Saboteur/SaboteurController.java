package mainstring.dev.Players.Saboteur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Implements the KeyListener interface to handle keyboard input for the Saboteur player. This class
 * listens for key events and performs actions based on the keys pressed.
 */
public class SaboteurController implements KeyListener {
  /**
   * The Saboteur player instance that this controller interacts with.
   */
  Saboteur saboteur;

  /**
   * The SaboteurView instance that represents the visual component of the Saboteur player.
   */
  SaboteurView view;

  /**
   * Constructor for creating a new SaboteurController instance. Initializes the Saboteur player and
   * adds the controller as a key listener to the view.
   * 
   * @param saboteur The Saboteur player instance.
   * @param view The SaboteurView instance.
   */
  public SaboteurController(Saboteur saboteur, SaboteurView view) {
    this.saboteur = saboteur;
    this.view = view;

    view.addKeyListener(this);
  }

  /**
   * Handles the event when a key is typed. Currently, it checks if the 'p' key is pressed and calls
   * the puncturePipe method of the Saboteur player.
   * 
   * @param e The KeyEvent triggered by the key press.
   */

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

  /**
   * Placeholder for handling the event when a key is pressed down. Currently, this method does
   * nothing.
   * 
   * @param e The KeyEvent triggered by the key press.
   */
  @Override
  public void keyPressed(KeyEvent e) {}

  /**
   * Placeholder for handling the event when a key is released. Currently, this method does nothing.
   * 
   * @param e The KeyEvent triggered by the key release.
   */
  @Override
  public void keyReleased(KeyEvent e) {}


}
