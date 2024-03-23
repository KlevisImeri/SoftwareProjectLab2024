package mainstring.dev;

import java.util.Scanner;
import mainstring.dev.Menu.*;
import mainstring.dev.Players.Player;
import mainstring.dev.Players.PlayersCollection;
import mainstring.dev.UI.GUI.*;

/**
 * The Skeleton class represents the entry point of the skeleton application.
 */
public class Skeleton {
  /*
   * The main method is the entry point of the application.
   * 
   * @param args command-line arguments (not used in this application)
   */
  public static void main(String[] args) {
    System.out.println("—Application Started—");
    System.out.println("main(String[] args)");

    System.out.println("Select function: [1-17]");
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
    try (Scanner scanner = new Scanner(System.in)) {
      choice = scanner.nextInt();
    } catch (Exception e) {
      e.printStackTrace();
    } 


    switch (choice) {
      case 1:
        disconnectPipe();
        break;
      case 2:
        connectPipe();
        break;
      case 3:
        fix();
        break;
      case 4:
        changePumpDirection();
        break;
      case 5:
        insertPump();
        break;
      case 6:
        pickPump();
        break;
      case 7:
        pickPipe();
        break;
      case 8:
        puncturePipe();
        break;
      case 9:
        move();
        break;
      case 10:
        fill();
        break;
      case 11:
        flow();
        break;
      case 12:
        calculateFlow();
        break;
      case 13:
        select();
        break;
      case 14:
        Menu();
        break;
      case 15:
        changeSettings();
        break;
      case 16:
        selectTeams();
        break;
      case 17:
        endGame();
        break;
      default:
        System.out.println("Invalid choice. Please select a number between 1 and 17.");
    }
  }

  // Define methods for each menu option here
  private static void disconnectPipe() {
    int choice = 0;
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Which Setup do you want?");
      System.out.println("1");
      System.out.println("2");
      System.out.println("3");
      choice = scanner.nextInt();
    } catch (Exception e) {
      e.printStackTrace();
    } 

    switch (choice) {
      case 1:
        disconnectPipe1();
        break;
      case 2:
        disconnectPipe2();
        break;
      case 3:
        disconnectPipe3();
        break;
      default:
        break;
    }

    System.out.println("Disconnecting pipe...");
  }

  private static void disconnectPipe1() {
    /*-----------------------------setup----------------------------*/ 
    Main main = new Main(); //create game
    main.main(null);
    //add plauer
    //add the elemetns
    //add players to elemtns
    /*-----------------------------setup----------------------------*/ 

    //Call of function
    saboter.disconnectPipe();
  }
  private static void disconnectPipe2() {}
  private static void disconnectPipe3() {}

  private static void connectPipe() {
    // Implementation for connectPipe
    System.out.println("Connecting pipe...");
  }

  private static void fix() {
    // Implementation for fix
    System.out.println("Fixing...");
  }

  private static void changePumpDirection() {
    // Implementation for changePumpDirection
    System.out.println("Changing pump direction...");
  }

  private static void insertPump() {
    // Implementation for insertPump
    System.out.println("Inserting pump...");
  }

  private static void pickPump() {
    // Implementation for pickPump
    System.out.println("Picking pump...");
  }

  private static void pickPipe() {
    // Implementation for pickPipe
    System.out.println("Picking pipe...");
  }

  private static void puncturePipe() {
    // Implementation for puncturePipe
    System.out.println("Puncturing pipe...");
  }

  private static void move() {
    // Implementation for move
    System.out.println("Moving...");
  }

  private static void fill() {
    // Implementation for fill
    System.out.println("Filling...");
  }

  private static void flow() {
    // Implementation for flow
    System.out.println("Flowing...");
  }

  private static void calculateFlow() {
    // Implementation for calculateFlow
    System.out.println("Calculating flow...");
  }

  private static void select() {
    // Implementation for select
    System.out.println("Selecting...");
  }

  private static void Menu() {
    // Implementation for Menu
    System.out.println("Opening menu...");
  }

  private static void changeSettings() {
    // Implementation for changeSettings
    System.out.println("Changing settings...");
  }

  private static void selectTeams() {
    // Implementation for selectTeams
    System.out.println("Selecting teams...");
  }

  private static void endGame() {
    // Implementation for endGame
    System.out.println("Ending game...");
  }

  public static void startGame() {
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
    // mainLoop();
    // }

  }

  public static void selectTeams() {}

  public static void mainLoop() {
    Player player = playersCollection.selectRandom();
    player.active();
    // while(timer not ended){}
  }

  public static void endGame() {}

  public static void displayResults() {}
}
