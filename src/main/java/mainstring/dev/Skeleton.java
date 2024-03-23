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
    System.out.println("Select function: [1-17]");
    System.out.println("5.2.1 disconnectPipe()");
    System.out.println("5.2.2 connectPipe()");
    System.out.println("5.2.3 fix()");
    System.out.println("5.2.4 changePumpDirection()");
    System.out.println("5.2.5 insertPump()");
    System.out.println("5.2.6 pickPump()");
    System.out.println("5.2.7 pickPipe()");
    System.out.println("5.2.8 puncturePipe()");
    System.out.println("5.2.9 move()");
    System.out.println("5.2.10 fill()");
    System.out.println("5.2.11 flow()");
    System.out.println("5.2.12 calculateFlow()");
    System.out.println("5.2.13 select()");
    System.out.println("5.2.14 Menu()");
    System.out.println("5.2.15 selectTeams()");
    System.out.println("5.2.16 endGame()");

    switch (Input.getInt(1, 17)) {
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
        selectTeams();
        break;
      case 16:
        endGame();
        break;
    }
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
    /*-----------------------------setup----------------------------*/
    Output.println("|------------5.2.1.1 Disconnect pipe from pump Setup------------|",
        Color.LIGHT_BLUE);

    Input.in("1");
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");
    
    Main main = new Main();

    // add plauer
    // add the elemetns
    // add players to elemtns
    /*-----------------------------setup----------------------------*/

    main(null);
  }

  private static void disconnectPipe2() {


    main(null);
  }

  private static void disconnectPipe3() {

    main(null);
  }

  private static void connectPipe() {
    // Implementation for connectPipe
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

    System.out.println("Connecting pipe...");
  }

  private static void connectPipe1() {
    /*-----------------------------setup----------------------------*/
    Output.println("|-------------5.2.2.1 Connect pipe with pump Setup-------------|",
        Color.LIGHT_BLUE);

    Input.in("1");
    Input.in("Klevis");
    Input.in("Diamond");
    Input.in("Murad");
    Input.in("Ibrahim");

    Main main = new Main();

    System.out.println("Does the player carry a pipe? [y]es/[n]o");
    switch (Input.getChar("yYnN")) {
      case 'y':
      case 'Y':
        System.out.println("Is the location an active element?[y]es/[n]o");
        switch (Input.getChar("yYnN")) {
          case 'y':
          case 'Y':
            System.out.println("Can more pipes be connected to the location?[y]es/[n]o");
            switch (Input.getChar("yYnN")) {
              case 'y':
              case 'Y':
                // addNeighbor(Pipe);
                // addNeighbor(Pump);
                break;

              case 'n':
              case 'N':
                System.out.println("The location is saturated with pipes!");
                break;

              default:
                break;
            }
            break;

          case 'n':
          case 'N':
            System.out.println("You can't connect a pipe to a pipe!");
            break;

          default:
            break;
        }
        break;

      case 'n':
      case 'N':
        System.out.println("You are not carrying a pipe!");
        break;

      default:
        break;
    }

    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);

    main(null);
  }

  private static void connectPipe2() {
    main(null);
  }

  private static void connectPipe3() {
    main(null);
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
    Output.println("\n|-----------------5.2.1.1 The user uses the menu ------------------|",
        Color.LIGHT_BLUE);
    Main main = new Main();
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);

    main(null);
  }


  private static void selectTeams() {
    Output.println("\n|----------------5.2.13.2 Adding Players into the teams-----------------|",
        Color.LIGHT_BLUE);
    Input.in("1");
    Main main = new Main();
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  private static void endGame() {
    // Implementation for endGame
    System.out.println("Ending game...");
  }
}
