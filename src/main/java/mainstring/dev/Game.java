package mainstring.dev;

import mainstring.dev.Output.Color;
import mainstring.dev.Menu.*;
import mainstring.dev.Players.Player;
import mainstring.dev.Players.PlayersCollection;
import mainstring.dev.Players.Plumber;
import mainstring.dev.Players.Saboteur;


/**
 * The Main class serves as the entry point for the game, orchestrating the setup, execution, and
 * termination of the game. It manages player selection, game loop, and displaying results.
 */
public class Game {
  public PlayersCollection players = new PlayersCollection();
  public Grid grid;
  public Menu menu = new Menu();

  /**
   * Constructor for Game. Initializes the game menu and sets up the callback for starting the game.
   */
  Game() {
    Input.game = this;
    menu.start();
    startGame();
  }

  /**
   * Starts the game by selecting teams, initializing the grid, running the main game loop, and
   * eventually calling for the game to end and display results.
   */
  public void startGame() {
    selectTeams();
    grid = new Grid(players);
    mainLoop();
    endGame();
  }


  /*---------------------------------------------Select Teams------------------------------------------- */
  int numOfPlumbers = 1;
  int numOfSaboteurs = 1;

  /**
   * Selects teams by asking the user to input players for Plumbers and Saboteurs. It supports
   * adding additional players based on user input.
   */
  private void selectTeams() {
    Output.println("\n[Adding Players into the teams]", Color.LIGHT_BLUE);
    askForPlumber();
    askForPlumber();
    askForSaboteur();
    askForSaboteur();
    System.out.println("Do you want to add more players? [y]es/[n]o");
    while (Input.getChar("yn") == 'y') {
      System.out.println("Select the team: [P]lumber/[S]aboteur");
      switch (Input.getChar("PS")) {
        case 'P':
          askForPlumber();
          break;
        case 'S':
          askForSaboteur();
          break;
      }
      System.out.println("Do you want to add more players? [y]es/[n]o");
    }
  }

  /**
   * Prompts the user to input a name for a Plumber player and adds the player to the players
   * collection.
   */
  private void askForPlumber() {
    while (true) {
      System.out.println("Enter the name of the " + numOfPlumbers + " plumber:");
      if (players.add(new Plumber(Input.getLine()))) {
        numOfPlumbers++;
        break;
      }
    }
  }

  /**
   * Prompts the user to input a name for a Saboteur player and adds the player to the players
   * collection.
   */
  private void askForSaboteur() {
    while (true) {
      System.out.println("Enter the name of the " + numOfSaboteurs + " saboteur:");
      if (players.add(new Saboteur(Input.getLine()))) {
        numOfSaboteurs++;
        break;
      }
    }
  }
  /*---------------------------------------------Select Teams------------------------------------------- */

  /*---------------------------------------------main Loop------------------------------------------- */

  /**
   * Executes the main game loop, repeatedly allowing each player to take active and passive actions
   * until the game ends, as determined by user input.
   */
  private void mainLoop() {
    Output.println("\n[Game Started]", Color.LIGHT_BLUE);
    Output.println("Did the game end? [y]es/[n]o",  Color.WHITE);
    while (Input.getChar("yn") == 'n') {
      Player player = players.selectRandom();
      player.active();
      player.passive();
      grid.caculateFlow();
      Output.println("Did the game end? [y]es/[n]o", Color.WHITE);
    }
  }
  /*---------------------------------------------main Loop------------------------------------------- */

  /*---------------------------------------------end Game------------------------------------------- */
  /**
   * Concludes the game, displaying the final results including the amounts of water gathered by
   * Plumbers and leaked by Saboteurs.
   */
  private void endGame() {
    Output.println("\n[Game Ended]", Color.LIGHT_BLUE);
    displayResults(grid.getWaterAtCistern(), grid.getWaterAtDesert());
    System.exit(1);
  }

  /**
   * Displays the results of the game, showing how much water was gathered and leaked.
   *
   * @param plumberResult The amount of water gathered by Plumbers.
   * @param saboteurResult The amount of water leaked by Saboteurs.
   */
  private void displayResults(int plumberResult, int saboteurResult) {
    Output.println("The plumber gathered: " + plumberResult + "liters of water",
        Color.LIGHT_MAGENTA);
    Output.println("The saboteurs leaked: " + saboteurResult + "liters of water",
        Color.LIGHT_MAGENTA);
  }
  /*---------------------------------------------end Game------------------------------------------- */
}
