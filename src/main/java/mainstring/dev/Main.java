package mainstring.dev;

import mainstring.dev.Menu.*;
import mainstring.dev.Players.Player;
import mainstring.dev.Players.PlayersCollection;
import mainstring.dev.Players.Plumber;
import mainstring.dev.Players.Saboteur;

/**
 * The Main class represents the entry point of the application.
 */
public class Main {
  private Menu menu;
  private PlayersCollection playersCollection = new PlayersCollection();

  /*
   * The main method is the entry point of the application.
   * 
   * @param args command-line arguments (not used in this application)
   */
  Main() {
    menu = new Menu((e) -> startGame());
  }

  public void startGame() {
    System.out.println("startGame()");

    selectTeams();

    // Grid grid = new Grid(players);
    // frame.add(new GridGUI(grid));

    // while(THe timer does not end){
    // mainLoop();
    // }
  }
  /*---------------------------------------------Select Teams------------------------------------------- */
  int numOfPlumbers = 1;
  int numOfSaboteurs = 1;

  public void askForPlumber() {
    while (true) {
      try {
        System.out.println("Enter the name of the " + numOfPlumbers + " plumber:");
        playersCollection.add(new Plumber(Input.getLine()));
        numOfPlumbers++;
        break;
      } catch (Exception e) {
      }
    }
  }

  public void askForSaboteur() {
    while (true) {
      try {
        System.out.println("Enter the name of the " + numOfSaboteurs + " saboteur:");
        playersCollection.add(new Saboteur(Input.getLine()));
        numOfSaboteurs++;
        break;
      } catch (Exception e) {
      }
    }
  }

  public void selectTeams() {
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
  }
  /*---------------------------------------------Select Teams------------------------------------------- */

  public void mainLoop() {
    Player player = playersCollection.selectRandom();
    // while(timer not ended){}
  }

  public void endGame() {}

  public void displayResults() {}
}
