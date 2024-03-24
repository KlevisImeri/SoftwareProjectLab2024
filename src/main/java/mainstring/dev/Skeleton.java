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

    System.out.println("5.2.1 disconnectPipe()");
    System.out.println("5.2.2 connectPipe()");
    System.out.println("5.2.3 fix()");
    System.out.println("5.2.5 insertPump()");
    System.out.println("5.2.8 puncturePipe()");
    System.out.println("5.2.10 fill()");
    System.out.println("5.2.11 flow()");
    System.out.println("5.2.12 calculateFlow()");
    System.out.println("5.2.13 select()");
    System.out.println("5.2.16 endGame()");

    switch (Input.getInt(2, 17)) {
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
      case 16:
        endGame();
        break;
    }

    Main main = new Main();
  }

  private static void Menu() { }

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
    Input.in("m");
    switch (s) {
      case 1:
        Input.in("1");
        Input.in("n");
        if (c == 'P') {
          Input.in("Klevis"); // Plumber
        } else {
          Input.in("Ibrahim"); // Saboteur
        }
        break;
      case 2:
        Input.in("2");
        Input.in("n");
        if (c == 'P') {
          Input.in("Klevis"); // Plumber
        } else {
          Input.in("Ibrahim"); // Saboteur
        }

        break;
      case 3:
        Input.in("3");
        Input.in("n");
        if (c == 'P') {
          Input.in("Klevis"); // Plumber
        } else {
          Input.in("Ibrahim"); // Saboteur
        }
        break;
      case 4:
        Input.in("4");
        Input.in("n");
        if (c == 'P') {
          Input.in("Klevis"); // Plumber
        } else {
          Input.in("Ibrahim"); // Saboteur
        }
        Input.in("Ibrahim"); // Saboteur
        break;
      case 5:
        Input.in("5");
        Input.in("n");
        if (c == 'P') {
          Input.in("Klevis"); // Plumber
        } else {
          Input.in("Ibrahim"); // Saboteur
        }
        break;
      case 6:
        Input.in("6");
        Input.in("n");
        if (c == 'P') {
          Input.in("Klevis"); // Plumber
        } else {
          Input.in("Ibrahim"); // Saboteur
        }
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
    Input.in("p");
    Input.in("n");
    Input.in("Klevis");
    Input.in("p");
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
    Input.in("p");
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
    Input.in("D");
    //main
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

  // Define methods for each menu option here
  private static void disconnectPipe() {
    System.out.println("Which Setup do you want? [1-3]");
    System.out.println("5.2.1.1 Disconnect pipe from pump");
    System.out.println("5.2.1.2 Disconnect pipe from spring");
    System.out.println("5.2.1.3 Disconnect pipe from cistern");

    switch (Input.getInt(1, 3)) {
      case 1:
        disconnectPipe1();
        break;
      case 2:
        disconnectPipe2();
        break;
      case 3:
        disconnectPipe3();
        break;
    }

    System.out.println("Disconnecting pipe...");
  }

  private static void disconnectPipe1() {
    Output.println("|------------5.2.1.1 Disconnect pipe from pump------------|", Color.LIGHT_BLUE);

    // start game
    Input.in("1");
    // adding players
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    // main loop
    Input.in("n");
    Input.in("Klevis");
    Input.in("d");

    // pointer * is where player is
    /*
     * S---p*---C S-------C \ \p
     */

    Main main = new Main();

    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);

    main(null);
  }

  private static void disconnectPipe2() {
    Output.println("|------------5.2.1.2 Disconnect pipe from spring------------|",
        Color.LIGHT_BLUE);

    Input.in("1");
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    Input.in("n");
    Input.in("Klevis");
    // pointer is where player is
    /*
     * S---p---C S-------C \ \p
     */
    Input.in("d");

    Main main = new Main();
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);

    main(null);
  }

  private static void disconnectPipe3() {
    Output.println("|------------5.2.1.3 Disconnect pipe from spring------------|",
        Color.LIGHT_BLUE);


    Input.in("1");
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    Input.in("n");
    Input.in("Klevis");
    // pointer is where player is
    /*
     * S---p---C S-------C \ \p
     */
    Input.in("d");

    Main main = new Main();

    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);

    main(null);
  }

  private static void connectPipe() {
    System.out.println("Which Setup do you want? [1-3]");
    System.out.println("5.2.2.1 Connect pipe with pump");
    System.out.println("5.2.2.2 Connect pipe with spring");
    System.out.println("5.2.2.3 Connect pipe with cistern");

    switch (Input.getInt(1, 3)) {
      case 1:
        connectPipe1();
        break;
      case 2:
        connectPipe2();
        break;
      case 3:
        connectPipe3();
        break;
    }
  }

  private static void connectPipe1() {
    Output.println("|-------------5.2.2.1 Connect pipe with-------------|", Color.LIGHT_BLUE);

    Input.in("1");
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    Input.in("n");
    Input.in("Klevis");
    // pointer is where player is
    /*
     * S---p---C S-------C \ \p
     */
    Input.in("c");


    Main main = new Main();

    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);

    main(null);
  }

  private static void connectPipe2() {
    Output.println("|-------------5.2.2.2 Connect pipe with spring Setup-------------|",
        Color.LIGHT_BLUE);

    Input.in("1");
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    Input.in("n");
    Input.in("Klevis");
    Input.in("c");


    Main main = new Main();

    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);

    main(null);
  }

  private static void connectPipe3() {
    /*-----------------------------setup----------------------------*/
    Output.println("|-------------5.2.2.3 Connect pipe with cistern Setup-------------|",
        Color.LIGHT_BLUE);

    Input.in("1");
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    Input.in("n");
    Input.in("Klevis");
    Input.in("c");


    Main main = new Main();

    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);

    main(null);
  }

  private static void fix() {
    // Implementation for fix
    System.out.println("select setup[1-2]");
    System.out.println("5.2.3.1 fix pump");
    System.out.println("5.2.3.2 fix pipe");

    switch (Input.getInt(1, 2)) {
      case 1:
        fixPump();
        break;
      case 2:
        fixPipe();
        break;

    }


    System.out.println("Fixing...");


  }

  private static void fixPipe() {
    Output.println("|-----------------Fixing Pipe------------------|", Color.LIGHT_BLUE);
    Input.in("1");
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    Input.in("n");
    Input.in("Klevis");
    Input.in("f");
    Main main = new Main();
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);



    main(null);
  }

  private static void fixPump() {

    Output.println("|-----------------Fixing Pump------------------|", Color.LIGHT_BLUE);
    Input.in("1");
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    Input.in("n");
    Input.in("Klevis");
    Input.in("f");
    Main main = new Main();
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);



    main(null);
  }


  private static void insertPump() {
    // Implementation for insertPump
    /*-----------------------------setup----------------------------*/
    Output.println(
        "|-------------5.2.5.1 The Plumber inserts the pump at a pipe Setup-------------|",
        Color.LIGHT_BLUE);

    Input.in("1");
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    Input.in("n");
    Input.in("Klevis");
    Input.in("i");

    Main main = new Main();

    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);

    main(null);

    System.out.println("Inserting pump...");
  }



  private static void puncturePipe() {
    Output.println("|-------------5.2.8.1 The Saboteur punctures the pipe Setup-------------|",
        Color.LIGHT_BLUE);

    Input.in("1");
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    Input.in("n");
    Input.in("n");
    Input.in("Klevis");
    Input.in("p");

    Main main = new Main();

    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);

    main(null);
    System.out.println("Puncturing pipe...");
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



  private static void endGame() {
    // Implementation for endGame
    System.out.println("Ending game...");
  }
}
