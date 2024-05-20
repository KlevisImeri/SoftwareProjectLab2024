package mainstring.dev.Game;

import java.util.Timer;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Grid.Grid;
import mainstring.dev.Menus.StartMenu.Menu;
import mainstring.dev.Output.Color;
import mainstring.dev.Players.Player.Player;
import mainstring.dev.Players.PlayersCollection.PlayersCollection;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Saboteur.Saboteur;


/**
 * The Main class serves as the entry point for the game, orchestrating the setup, execution, and
 * termination of the game. It manages player selection, game loop, and displaying results.
 */
public class Game {
  PlayersCollection players = new PlayersCollection();
  Grid grid = new Grid();
  Menu menu = new Menu();
  Timer timer = new Timer();

  /**
   * Constructor for Game. Initializes the game menu and sets up the callback for starting the game.
   */
  public Game() {
    players.add(new Plumber("Klevis"));
    players.add(new Plumber("Diamond"));
    // players.add(new Saboteur("Murad"));
    // players.add(new Saboteur("Ibrahim"));
  }

  public void setUp() {
    grid = new Grid();
    grid.addPlayers(players);
  }

  /*---------------------------------------------main Loop------------------------------------------- */

  /**
   * Executes the main game loop, repeatedly allowing each player to take active and passive actions
   * until the game ends, as determined by user input.
   */

  /*---------------------------------------------main Loop------------------------------------------- */

  /*---------------------------------------------end Game------------------------------------------- */
  /**
   * Concludes the game, displaying the final results including the amounts of water gathered by
   * Plumbers and leaked by Saboteurs.
   */
  public void endGame() {
    Output.println("\n[Game Ended]", Color.LIGHT_BLUE);
    displayResults(grid.getWaterAtCistern(), grid.getWaterAtDesert());
  }

  /**
   * Displays the results of the game, showing how much water was gathered and leaked.
   *
   * @param plumberResult The amount of water gathered by Plumbers.
   * @param saboteurResult The amount of water leaked by Saboteurs.
   */
  public void displayResults(int plumberResult, int saboteurResult) {
    Output.println("The plumber gathered: " + plumberResult + "liters of water",
        Color.LIGHT_MAGENTA);
    Output.println("The saboteurs leaked: " + saboteurResult + "liters of water",
        Color.LIGHT_MAGENTA);
  }
  /*---------------------------------------------end Game------------------------------------------- */


  public PlayersCollection getPlayers() {
    return players;
  }

  public Menu getMenu() {
    return menu;
  }

  public Grid getGrid() {
    return grid;
  }

}
