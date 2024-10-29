package mainstring.dev;

import mainstring.dev.Game.Game;
import mainstring.dev.Game.GameView;

/**
 * The Main class serves as the entry point of the application. It is responsible for initializing and starting the game.
 * This class orchestrates the creation of the game instance and its associated graphical interface.
 */
public class Main {

  /**
   * The main method acts as the entry point of the application. It initializes the game logic and the graphical user interface.
   * Upon execution, this method creates a new instance of the game and its corresponding view, effectively launching the game.
   *
   * @param args Command-line arguments passed to the program. These arguments are not utilized in this simple example but can be used for various purposes such as specifying configuration options or controlling the game mode.
   */
  public static void main(String[] args) {
    // Initialize and start the frame of the game by creating a new GameView instance with a new Game instance.
    new GameView(new Game());
  }
}