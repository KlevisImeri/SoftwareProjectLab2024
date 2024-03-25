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
public class Main {
  private PlayersCollection players;
  private Grid grid;
  private Menu menu;

  /**
   * Constructor for Main. Initializes the game menu and sets up the callback for starting the game.
   */
  Main() {
    menu = new Menu((e) -> startGame());
  }

  /**
   * Starts the game by selecting teams, initializing the grid, running the main game loop, and
   * eventually calling for the game to end and display results.
   */
  public void startGame() {
    System.out.println("startGame()");
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
  public void selectTeams() {
    players = new PlayersCollection();
    Output.println("\n|----------------5.2.3.1 Adding Players into the teams-----------------|",
        Color.LIGHT_BLUE);
    System.out.println("selectTeams()");
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
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  /**
   * Prompts the user to input a name for a Plumber player and adds the player to the players
   * collection.
   */
  public void askForPlumber() {
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
  public void askForSaboteur() {
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
  public void mainLoop() {
    Output.println("\n|----------------5.2.4.1 The main loop of the game-----------------|",
        Color.LIGHT_BLUE);
    System.out.println("mainLoop()");
    System.out.println("Did the game end? [y]es/[n]o");
    while (Input.getChar("yn") == 'n') {
      Player player = players.selectRandom();
      player.active();
      player.passive();
      grid.caculateFlow();
      System.out.println("Did the game end? [y]es/[n]o");
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }
  /*---------------------------------------------main Loop------------------------------------------- */

  /*---------------------------------------------end Game------------------------------------------- */
  /**
   * Concludes the game, displaying the final results including the amounts of water gathered by
   * Plumbers and leaked by Saboteurs.
   */
  public void endGame() {
    Output.println("\n|----------5.2.4.1 The game end and the display of results---------|",
        Color.LIGHT_BLUE);
    System.out.println("endGame()");
    displayResults(grid.getWaterAtCistern(), grid.getWaterAtDesert());
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  /**
   * Displays the results of the game, showing how much water was gathered and leaked.
   *
   * @param plumberResult The amount of water gathered by Plumbers.
   * @param saboteurResult The amount of water leaked by Saboteurs.
   */
  public void displayResults(int plumberResult, int saboteurResult) {
    System.out.println("displayResults()");
    System.out.println("The plumber gathered: " + plumberResult + "liters of water");
    System.out.println("The saboteurs leaked: " + saboteurResult + "liters of water");
  }
  /*---------------------------------------------end Game------------------------------------------- */
}
