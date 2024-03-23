package mainstring.dev;

import mainstring.dev.Menu.*;
import mainstring.dev.Players.Player;
import mainstring.dev.Players.PlayersCollection;
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
    menu = new Menu((e)->startGame());
  }

  public void startGame(){
    System.out.println("startGame()");
    

    // Grid grid = new Grid(players);
    // frame.add(new GridGUI(grid));

    // while(THe timer does not end){
    //   mainLoop();
    // }

  }
  public void selectTeams(){}

  public void mainLoop(){
    Player player =  playersCollection.selectRandom();
    //while(timer not ended){}
  }
  
  public void endGame(){}

  public void displayResults(){}
}
