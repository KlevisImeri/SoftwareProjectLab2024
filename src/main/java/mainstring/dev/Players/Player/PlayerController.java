package mainstring.dev.Players.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import mainstring.dev.Elements.ActiveElements.Pump.PumpView;

/**
 * The PlayerController class is responsible for handling key and mouse events
 * for a Player. It implements the KeyListener and MouseListener interfaces
 * to respond to user input and update the player's state accordingly.
 */
public class PlayerController implements KeyListener, MouseListener {
  // The Player instance being controlled.
  Player player;

  // The view associated with the Player.
  PlayerView view;

  /**
   * Constructs a PlayerController with the specified Player and PlayerView.
   * Adds this controller as a key listener and mouse listener to the view.
   *
   * @param player the Player to control
   * @param view the PlayerView associated with the Player
   */
  public PlayerController(Player player, PlayerView view) {
    this.player = player;
    this.view = view;

    // Add this controller as a KeyListener and MouseListener to the view.
    view.addKeyListener(this);
    view.addMouseListener(this);
  }

  // These methods are required by the MouseListener interface, but are not used in this implementation.
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

  /**
   * Invoked when a key is typed.
   * Handles specific key actions to update the player's state and view.
   *
   * @param e the event to be processed
   */
  @Override
  public void keyTyped(KeyEvent e) {
    try {
      switch (e.getKeyChar()) {
        case 'm':
          player.move();
          // Update the player's location and repaint the view.
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
          view.location.gridView.repaint();
          break;
      }

    } catch (Exception exp) {
      exp.printStackTrace();
    }
  }

  // These methods are required by the KeyListener interface, but are not used in this implementation.
  @Override
  public void keyPressed(KeyEvent e) {}

  @Override
  public void keyReleased(KeyEvent e) {}


}
