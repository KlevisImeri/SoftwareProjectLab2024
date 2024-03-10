package mainstring.dev;

import mainstring.dev.Menu.*;
import mainstring.dev.Players.Player;
import mainstring.dev.Players.PlayersCollection;
import mainstring.dev.UI.GUI.*;
/**
 * The Main class represents the entry point of the application.
 */
public class Main {
  private static MainFrame frame = new MainFrame();
  private static Menu menu = new Menu();
  private static PlayersCollection playersCollection = new PlayersCollection();
  /*
   * The main method is the entry point of the application.
   * 
   * @param args command-line arguments (not used in this application)
   */
  public static void main(String[] args) {
    menu.setStartGameFunction((e)->startGame());
    frame.add(new MenuGUI(menu));
    frame.revalidate();
  }

  public static void startGame(){
    frame.getContentPane().removeAll();
    frame.revalidate();
    frame.repaint();

    System.out.println("The game started");
    
    PlayersCollection players = new PlayersCollection();
    frame.add(new PlayersCollectionGUI(players));

    // frame.getContentPane().removeAll();
    // frame.revalidate();
    // frame.repaint();

    // Grid grid = new Grid(players);
    // frame.add(new GridGUI(grid));

    // while(THe timer does not end){
    //   mainLoop();
    // }

  }
  public static void mainLoop(){
    Player player =  playersCollection.selectRandom();
    player.active();
    //while(timer not ended){}
  }
  
  public static void endGame(){}

  public static void displayResults(){}
}
