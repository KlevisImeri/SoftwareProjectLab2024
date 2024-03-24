package mainstring.dev;

import mainstring.dev.Output.Color;

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

    Output.println("|----------------------Application Started----------------------|",
        Color.LIGHT_BLUE);
    System.out.println("main(String[] args)");
    System.out.println("Select function: [2-17]");
    System.out.println("5.2.2 Menu()");
    System.out.println("5.2.3 selectTeams()");
    System.out.println("5.2.4 mainLoop()");
    System.out.println("5.2.5 move()");
    System.out.println("5.2.6 pickPump()");
    System.out.println("5.2.7 pickPipe()");
    System.out.println("5.2.8 changePumpDirection()");
    System.out.println("5.2.9 disconnectPipe()");
    System.out.println("5.2.10 connectPipe()");
    System.out.println("5.2.11 fix()");
    System.out.println("5.2.12 insertPump()");
    System.out.println("5.2.13 puncturePipe()");
    System.out.println("5.2.14 calculateFlow()");
    System.out.println("5.2.15 endGame()");

    switch (Input.getInt(2, 15)) {
      case 2:
        Menu();
        break;
      case 3:
        selectTeams();
        break;
      case 4:
        mainLoop();
        break;
      case 5:
        move();
        break;
      case 6:
        pickPump();
        break;
      case 7:
        pickPipe();
        break;
      case 8:
        changePumpDirection();
        break;
      case 9:
        disconnectPipe();
        break;
      case 10:
        connectPipe();
        break;
      case 11:
        fix();
        break;
      case 12:
        insertPump();
        break;
      case 13:
        puncturePipe();
        break;
      case 14:
        calculateFlow();
        break;
      case 15:
        endGame();
        break;
    }

    Main main = new Main();
    
    Output.println("|-------------------------Application Exited--------------------------|\n",
              Color.LIGHT_BLUE);
    System.exit(0);
  }

  private static void Menu() {}

  private static void selectTeams() {
    // start game
    Input.in("1");
  }

  private static void mainLoop() {
    // start game
    Input.in("1");
    // adding players
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    // Select Grid Setup
    Input.in("0");
    // Setup players
    Input.in("0");
  }

  private static void move() {
    // get all the inputs
    System.out.println("Which Setup do you want? [1-6]");
    System.out.println("5.2.5.1/2.1 The plumber/saboteur moves from pipe to pump");
    System.out.println("5.2.5.1/2.2 The plumber/saboteur moves from pipe to spring");
    System.out.println("5.2.5.1/2.3 The plumber/saboteur moves from pipe to cistern");
    System.out.println("5.2.9.1/2.4 The plumber/saboteur moves from pump to pipe");
    System.out.println("5.2.9.1/2.5 The plumber/saboteur moves from spring to pipe");
    System.out.println("5.2.9.1/2.6 The plumber/saboteur moves from cistern to pipe");
    int s = Input.getInt(1, 6);
    System.out.println("Which player is moving? [P]lumber/[S]aboteur");
    char c = Input.getChar("PS");

    /*---------setup---------*/
    // start game
    Input.in("1");
    // adding players
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    // Setup the grid
    switch (s) {
      case 1:
        Input.in("1");
        break;
      case 2:
        Input.in("2");
        break;
      case 3:
        Input.in("3");
        break;
      case 4:
        Input.in("4");
        break;
      case 5:
        Input.in("5");
        break;
      case 6:
        Input.in("6");
        break;
    }
    // Setup players
    Input.in("0");
    // main loop
    Input.in("n");
    switch (c) {
      case 'P':
        Input.in("Klevis"); // Plumber
        break;
      case 'S':
        Input.in("Ibrahim"); // Saboteur
        break;
    }
    Input.in("m");
  }

  private static void pickPump() {
    // Start game
    Input.in("1");
    // Selected Teams
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    // Select Grid Setup
    Input.in("8");
    // Setup players
    Input.in("0");
    // main loop
    Input.in("n");
    Input.in("Klevis");
    Input.in("8");
  }

  private static void pickPipe() {
    // Start game
    Input.in("1");
    // Selected Teams
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    // Select Grid Setup
    Input.in("8");
    // Setup players
    Input.in("0");
    // main loop
    Input.in("n");
    Input.in("Klevis");
    Input.in("P");
  }

  private static void changePumpDirection() {
    System.out.println("Which Setup do you want? [1-2]");
    System.out.println("5.2.4.1 The Plumber changes the pump direction");
    System.out.println("5.2.4.2 The Saboteur changes the pump direction");
    int s = Input.getInt(1, 2);
    // Start game
    Input.in("1");
    // Selected Teams
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    // Select Grid Setup
    Input.in("7");
    // Setup players
    Input.in("1");
    // main
    Input.in("n");
    switch (s) {
      case 1:
        Input.in("Diamond");
        break;
      case 2:
        Input.in("Murad");
      default:
        break;
    }
    Input.in("D");
  }

  private static void disconnectPipe() {
    System.out.println("Which Setup do you want? [1-3]");
    System.out.println("5.2.1.1 Disconnect pipe from pump");
    System.out.println("5.2.1.2 Disconnect pipe from spring");
    System.out.println("5.2.1.3 Disconnect pipe from cistern");
    int c = Input.getInt(1, 3);

    // start game
    Input.in("1");
    // adding players
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    // Select Grid Setup
    switch (c) {
      case 1:
        Input.in("4");
        break;
      case 2:
        Input.in("5");
        break;
      case 3:
        Input.in("6");
        break;
    }
    // Setup players
    Input.in("0");
    // main loop
    Input.in("n");
    Input.in("Klevis");
    Input.in("d");
  }

  private static void connectPipe() {
    System.out.println("Which Setup do you want? [1-3]");
    System.out.println("5.2.2.1 Connect pipe with pump");
    System.out.println("5.2.2.2 Connect pipe with spring");
    System.out.println("5.2.2.3 Connect pipe with cistern");
    int c = Input.getInt(1, 3);

    // start game
    Input.in("1");
    // adding players
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    // Select Grid Setup
    switch (c) {
      case 1:
        Input.in("4");
        break;
      case 2:
        Input.in("5");
        break;
      case 3:
        Input.in("6");
        break;
    }
    // Setup players
    Input.in("1");
    // main loop
    Input.in("n");
    Input.in("Klevis");
    Input.in("c");
  }

  private static void fix() {
    System.out.println("select setup[1-2]");
    System.out.println("5.2.3.1 Fix pump");
    System.out.println("5.2.3.2 Fix pipe");
    System.out.println("5.2.3.3 Fix cistern");
    System.out.println("5.2.3.4 Fix spring");
    int s = Input.getInt(1, 4);

    // start game
    Input.in("1");
    // adding players
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    // Select Grid Setup
    switch (s) {
      case 1:
        Input.in("4");
        break;
      case 2:
        Input.in("1");
        break;
      case 3:
        Input.in("5");
        break;
      case 4:
        Input.in("6");
        break;
    }
    // Setup players
    Input.in("0");
    // main loop
    Input.in("n");
    Input.in("Klevis");
    Input.in("f");
  }

  private static void insertPump() {
    // start game
    Input.in("1");
    // adding players
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    // Select Grid Setup
    Input.in("9");
    // Setup players
    Input.in("1");
    // main loop
    Input.in("n");
    Input.in("Klevis");
    Input.in("i");
  }

  private static void puncturePipe() {
    // start game
    Input.in("1");
    // adding players
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    // Select Grid Setup
    Input.in("1");
    // Setup players
    Input.in("0");
    // main loop
    Input.in("n");
    Input.in("Murad");
    Input.in("p");
  }

  private static void calculateFlow() {
      // Start game
      Input.in("1");
      // Selected Teams
      Input.in("Klevis");
      Input.in("Diamond");
      Input.in("Murad");
      Input.in("Ibrahim");
      Input.in("n");
      // Select Grid Setup
      Input.in("10");
      // Setup players
      Input.in("0");
      // main loop
      Input.in("n");
      Input.in("Klevis");
      Input.in("P");
  }

  private static void endGame() {
    // Start game
    Input.in("1");
    // Selected Teams
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    // Select Grid Setup
    Input.in("11");
    // Setup players
    Input.in("1");
    // main loop
    Input.in("n");
    Input.in("Klevis");
    Input.in("P");
    Input.in("y");
  }
}
