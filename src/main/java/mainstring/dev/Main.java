package mainstring.dev;

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

    Grid grid = new Grid(players);
    //S----C(p1,p2,p3...)

    System.out.println("Did the game end? [y]es/[n]o");
    while(Input.getChar("yn")=='n') {
      mainLoop();
      System.out.println("Did the game end? [y]es/[n]o");
    }

    endGame();
  }

  /*---------------------------------------------Select Teams------------------------------------------- */
  int numOfPlumbers = 1;
  int numOfSaboteurs = 1;

  public void selectTeams() {
    System.out.println("selectTeams()");
    players = new PlayersCollection();
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
    System.out.println("mainLoop()");
    Player player = players.selectRandom();
    player.active();
    player.passive();
  }

  public void endGame() {}

  public void displayResults() {}
}
