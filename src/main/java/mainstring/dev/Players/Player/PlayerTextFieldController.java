package mainstring.dev.Players.Player;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * The PlayerTextFieldController class is responsible for managing the interactions
 * and updates between a Player and a PlayerTextFieldView. It listens for changes
 * in the text field and updates the player's name accordingly.
 */
public class PlayerTextFieldController implements DocumentListener{
  // The Player instance being controlled.
  public Player player;

  // The view associated with the Player.
  public PlayerTextFieldView view;

  /**
   * Constructs a PlayerTextFieldController with the specified Player and PlayerTextFieldView.
   * Adds this controller as a document listener to the text field in the view.
   *
   * @param player the Player to control
   * @param view the PlayerTextFieldView associated with the Player
   */
  public PlayerTextFieldController(Player player, PlayerTextFieldView view) {
    this.player = player;
    this.view = view;

    // Add this controller as a DocumentListener to the text field.
    view.getDocument().addDocumentListener(this);
  }

  /**
   * Updates the player's name based on the text in the text field.
   */
  public void setName() {
    player.setName(view.getText());
  }

  /**
   * Called when text is inserted into the document.
   *
   * @param e the document event
   */
  @Override
  public void insertUpdate(DocumentEvent e) {
    setName();
  }

  /**
   * Called when text is removed from the document.
   *
   * @param e the document event
   */
  @Override
  public void removeUpdate(DocumentEvent e) {
    setName();
  }

  /**
   * Called when the document's attributes are changed.
   *
   * @param e the document event
   */
  @Override
  public void changedUpdate(DocumentEvent e) {
    setName();
  }

}
