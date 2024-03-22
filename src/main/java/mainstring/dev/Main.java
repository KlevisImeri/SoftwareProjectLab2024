package mainstring.dev;

import java.util.Scanner;
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
    System.out.println("—Application Started—");
    System.out.println("main(String[] args)");

    System.out.println("Select function: [number]");
    System.out.println("1. disconnectPipe()");
    System.out.println("2. connectPipe()");
    System.out.println("3. fix()");
    System.out.println("4. changePumpDirection()");
    System.out.println("5. insertPump()");
    System.out.println("6. pickPump()");
    System.out.println("7. pickPipe()");
    System.out.println("8. puncturePipe()");
    System.out.println("9. move()");
    System.out.println("10. fill()");
    System.out.println("11. flow()");
    System.out.println("12. calculateFlow()");
    System.out.println("13. select()");
    System.out.println("14. Menu()");
    System.out.println("15. changeSettings()");
    System.out.println("16. selectTeams()");
    System.out.println("17. endGame()");

    int choice = 0;
    try(Scanner scanner = new Scanner(System.in)){
      System.out.print("Enter your choice (1-17): ");
      choice = scanner.nextInt();
    }catch(Exception e){
      e.printStackTrace();
    };
    
    
    switch (choice) {
      case 1:
        disconnectPipeSetup();
        break;
      case 2:
        connectPipeSetup();
        break;
      default:
        break;
    }
    // Process the user's choice here
    System.out.println("You chose option " + choice);

    // menu.setStartGameFunction((e)->startGame());
    // frame.add(new MenuGUI(menu));
    // frame.revalidate();
  }

  public static void disconnectPipeSetup(){

  }
  public static void connectPipeSetup(){

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
  public static void selectTeams(){}

  public static void mainLoop(){
    Player player =  playersCollection.selectRandom();
    player.active();
    //while(timer not ended){}
  }
  
  public static void endGame(){}

  public static void displayResults(){}
}
