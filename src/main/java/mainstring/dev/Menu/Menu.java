package mainstring.dev.Menu;

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
   * Starts the menu, allowing the user to choose between starting the game or changing settings.
   * The user input is validated to ensure a valid choice is made before proceeding.
   */
  public void start() {
    Output.println("\n[Menu]", Color.LIGHT_BLUE);
    while (true) {
      System.out.println("Choose:");
      System.out.println("1. Start Game");
      System.out.println("2. Change Settings");

      int in = Input.getInt(1, 2);
      if (in == 1) {
        break;
      } else if (in == 2) {
        System.out.println("Enter the new values:");
        System.out.println("endTime [5-720 min]");
        int endTime = Input.getInt(5, 720);
        System.out.println("playerTime [10-180 sec]");
        int playerTime = Input.getInt(10, 180);
        System.out.println(endTime + playerTime);
        settings.setSettings(endTime, playerTime);
      }
    }
  }
}
