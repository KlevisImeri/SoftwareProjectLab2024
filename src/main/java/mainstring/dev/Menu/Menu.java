package mainstring.dev.Menu;

import java.awt.event.ActionListener;
import mainstring.dev.Input;


public class Menu {
  public Settings settings = new Settings();
  public ActionListener startGame;

  public Menu(ActionListener startGame) {
    System.out.println("Menu()");

    System.out.println("Choose:");
    System.out.println("1. Start Game");
    System.out.println("2. Change Settings");
    
    switch(Input.getInt(1, 2)){
      case 1:
        startGame.actionPerformed(null);
        break;
      case 2:
        System.out.println(settings.getSettings().toString());
        System.out.println("Enter the new values:");
        System.out.println("endTime [5-720 min]");
        int endTime = Input.getInt(5, 720);
        System.out.println("playerTime [10-180 sec]");
        int playerTime = Input.getInt(10, 180);
        settings.setSettings(endTime, playerTime);
        System.out.println(settings.getSettings().toString());
        break;
    }
  }

  public void showConfirmationDialog() {}
}

