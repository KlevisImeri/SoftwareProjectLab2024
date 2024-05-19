package mainstring.dev.Players.Player;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PlayerTextFieldController implements DocumentListener{
  public Player player;
  public PlayerTextFieldView view;

  public PlayerTextFieldController(Player player, PlayerTextFieldView view) {
    this.player = player;
    this.view = view;

    view.getDocument().addDocumentListener(this);
  }

  public void setName() {
    player.setName(view.getText());
  }

  @Override
  public void insertUpdate(DocumentEvent e) {
    setName();
  }

  @Override
  public void removeUpdate(DocumentEvent e) {
    setName();
  }

  @Override
  public void changedUpdate(DocumentEvent e) {
    setName();
  }

}
