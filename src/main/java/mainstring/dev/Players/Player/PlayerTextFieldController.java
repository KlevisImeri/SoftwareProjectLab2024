package mainstring.dev.Players.Player;

public class PlayerTextFieldController {
  public Player player;
  public PlayerTextFieldView view;

  public PlayerTextFieldController(Player player, PlayerTextFieldView view) {
    this.player = player;
    this.view = view;
  }

  public void setName() {
    player.setName(view.getText());
  }

}
