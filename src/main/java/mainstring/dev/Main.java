package mainstring.dev;

import mainstring.dev.Menu.*;
import mainstring.dev.Players.PlayersCollection;
import mainstring.dev.UI.GUI.*;
/**
 * The Main class represents the entry point of the application.
 */
public class Main {
  private static MainFrame frame = new MainFrame();
  private static Menu menu = new Menu();
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

    
    // PlayersCollection players = new PlayersCollection();
    // frame.add(new PlayersCollectionGUI(players));

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
    /* select player randomly
     * make player active 
     *  - now all the kewboarad input are turn on for that player
     *  - this is becuase the UI checks if player active
     * Every time you click on pipe the GUI sets the curentpipe in the grid
     * while(timer for player is not over){
     *  he select pipe.
     *  he preses kewboard input.
     * }
    */ 
  }

}

//Teams
//TeamsGUI
//Grid takes the teams in the constructor
//The grid is setup with the grid ui
