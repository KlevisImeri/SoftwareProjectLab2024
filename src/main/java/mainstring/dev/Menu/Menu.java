package mainstring.dev.Menu;

import java.awt.event.ActionListener;


public class Menu {
  public Settings settings = new Settings();
  public ActionListener startGame;
  public void setStartGameFunction(ActionListener startGame){
    this.startGame=startGame;
  }
  public void showConfirmationDialog(){}
}
