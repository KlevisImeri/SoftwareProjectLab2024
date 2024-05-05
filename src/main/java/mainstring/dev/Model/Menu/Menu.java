package mainstring.dev.Model.Menu;

import mainstring.dev.Model.Game;


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
  public Game game;
}
