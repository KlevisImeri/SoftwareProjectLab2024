package mainstring.dev;

import mainstring.dev.Game.Game;
import mainstring.dev.Game.GameView;

/**
 * The Main class contains the entry point of the application. It initializes and starts the game.
 */
public class Main {

  /**
   * The main method, which serves as the entry point of the application.
   * 
   * @param args The command-line arguments passed to the program.
   */
  public static void main(String[] args) {
    // Initialize and start the frame of the game
    new GameView(new Game());
  }
}

