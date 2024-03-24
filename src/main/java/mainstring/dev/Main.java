package mainstring.dev;

import mainstring.dev.Output.Color;
import mainstring.dev.Menu.*;
import mainstring.dev.Players.Player;
import mainstring.dev.Players.PlayersCollection;
import mainstring.dev.Players.Plumber;
import mainstring.dev.Players.Saboteur;


public class Main {
  private PlayersCollection players;
  private Grid grid;
  private Menu menu;

  Main() {
    menu = new Menu((e) -> startGame());
  }

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

  public void askForPlumber() {
    while (true) {
      System.out.println("Enter the name of the " + numOfPlumbers + " plumber:");
      if (players.add(new Plumber(Input.getLine()))) {
        numOfPlumbers++;
        break;
      }
    }
  }

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

  public void endGame() {}

  public void displayResults() {}
}
