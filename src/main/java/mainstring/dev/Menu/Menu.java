package mainstring.dev.Menu;

import java.awt.event.ActionListener;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;


/**
 * The Menu class represents a simple text-based menu for a game or application, offering options to
 * start the game or change its settings. It utilizes a loop to repeatedly prompt the user until a
 * valid choice is made.
 */
public class Menu {

  /**
   * Settings object to manage game settings like end time and player time.
   */
  public Settings settings = new Settings();

  /**
   * Constructs a Menu instance and displays the menu options to the user. It supports starting the
   * game or changing the game's settings based on user input. The game starts when option 1 is
   * selected, while option 2 allows the user to adjust settings such as end time and player time.
   *
   * @param startGame An ActionListener that is triggered to start the game when option 1 is chosen.
   */
  public Menu(ActionListener startGame) {
    Output.println("\n|-----------------5.2.2.1 The user uses the menu ------------------|",
        Color.LIGHT_BLUE);
    System.out.println("Menu()");
    while (true) {
      System.out.println("Choose:");
      System.out.println("1. Start Game");
      System.out.println("2. Change Settings");

      int in = Input.getInt(1, 2);
      if (in == 1) {
        Output.println("|--------------------------------------------------------------------|\n",
            Color.LIGHT_BLUE);
        startGame.actionPerformed(null);
        break;
      } else if (in == 2) {
        Output.println(settings.getSettings().toString(), Color.LIGHT_MAGENTA);
        System.out.println("Enter the new values:");
        System.out.println("endTime [5-720 min]");
        int endTime = Input.getInt(5, 720);
        System.out.println("playerTime [10-180 sec]");
        int playerTime = Input.getInt(10, 180);
        settings.setSettings(endTime, playerTime);
        Output.println(settings.getSettings().toString(), Color.LIGHT_MAGENTA);
      }
    }
  }

  /**
   * A placeholder method for showing a confirmation dialog. This could be implemented to confirm
   * the user's choices or actions in a GUI-based version of the menu.
   */
  public void showConfirmationDialog() {}
}
