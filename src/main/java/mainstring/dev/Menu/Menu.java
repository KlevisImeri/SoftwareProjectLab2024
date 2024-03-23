package mainstring.dev.Menu;

import java.awt.event.ActionListener;
import mainstring.dev.Input;


public class Menu {
  public Settings settings = new Settings();
  public ActionListener startGame;

  public Menu(ActionListener startGame) {
    System.out.println("Menu()");

    String menu = 
    "Choose:\n" + 
    "1. Start Game\n" + 
    "2. Change Settings\n"; 

    System.out.println(menu);

    switch(Input.getInt(1, 2)){
      case 1:
        startGame.actionPerformed(null);
        break;
      case 2:
        System.out.println(settings.getSettings().toString());
        System.out.println("Enter the new values:");
        System.out.println("endTime [5min<=number<=720min]");
        int endTime = Input.getInt(5, 720);
        System.out.println("playerTime [10sec<=number<=180sec]");
        int playerTime = Input.getInt(10, 180);
        settings.setSettings(endTime, playerTime);
        break;
    }
  }

  public void showConfirmationDialog() {}
}

