package mainstring.dev.Players;

import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Output.Color;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Elements.*;
import java.util.List;

/**
 * Represents a Plumber, a specialized type of player in the game. Plumbers can carry, connect,
 * disconnect pipes, and insert pumps as well as fix elements within the grid.
 */
public class Plumber extends Player {
  /**
   * A Pump that the Plumber is currently carrying. Null if no pump is being carried.
   */
  public Pump carryPump;

  /**
   * A Pipe that the Plumber is currently carrying. Null if no pipe is being carried.
   */
  public Pipe carryPipe;

  /**
   * Provides a string representation of the plumber, including their name, the pump and pipe they
   * are carrying.
   * 
   * @return A string representing the plumber.
   */
  @Override
  public String toString() {
    String superString = super.toString().replace("\n", "\n  ");
    String pipeString = (carryPipe != null) ? carryPipe.toString().replace("\n", "\n  ") : "null";
    String pumpString = (carryPump != null) ? carryPump.toString().replace("\n", "\n  ") : "null";
    return """
      
        Plumber{
          %s,
          carryPump: %s,
          carryPipe: %s
        }""".formatted(superString, pipeString, pumpString);
  }


  /**
   * Constructs a Plumber with a specified name.
   * 
   * @param name The name of the Plumber.
   */
  public Plumber(String name) {
    System.out.println("Plumber()");
    this.name = name;
  }

  /**
   * Attempts to disconnect a pipe from its current location. If successful, the Plumber starts
   * carrying the disconnected pipe.
   */
  public void disconnectPipe() {
    Output.println("|-------------5.2.9 Disconnect pipe from " + location.type() + "-------------|",
        Color.LIGHT_BLUE);
    System.out.println("disconnectPipe()");
    Pipe sp = grid.getSelectedPipe();
    if (location.isConnected(sp)) {
      if (carryPipe == null) {
        location.removeNeighbor(sp);
        sp.removeNeighbor(location);
        carryPipe = sp;
      } else {
        Output.println("You are already carrying  a pipe!", Color.LIGHT_RED);
      }
    } else {
      Output.println("The pipe is too far away!", Color.LIGHT_RED);
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  /**
   * Attempts to connect a pipe to the Plumber's current location. If the Plumber is carrying a
   * pipe, it connects that pipe to the location.
   */
  public void connectPipe() {
    Output.println(
        "|----------------5.2.9 Connect pipe with " + location.type() + "-----------------|",
        Color.LIGHT_BLUE);
    System.out.println("connectPipe()");
    if (carryPipe != null) {
      if (location instanceof ActiveElement) {
        System.out.println("Can more pipes be connected to the location? [y]es/[n]no");
        switch (Input.getChar("yn")) {
          case 'y':
            carryPipe.addNeighbor(location);
            location.addNeighbor(carryPipe);
            carryPipe = null;
            break;
          case 'n':
            Output.println("The location is saturated with pipes!", Color.LIGHT_RED);
            break;
        }
      } else {
        Output.println("You can't connect a pipe to a pipe!", Color.LIGHT_RED);
      }
    } else {
      Output.println("The plumber is not carrying any pipe!", Color.LIGHT_RED);
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  /**
   * Fixes the element at the Plumber's current location if it is a Pump or Pipe.
   */
  public void fix() { // used
    Output.println(
        "|-----------------------5.2.11 Fixing " + location.type() + "--------------------------|",
        Color.LIGHT_BLUE);
    if (location instanceof Pump) {
      ((Pump) location).fix();
    } else if (location instanceof Pipe) {
      ((Pipe) location).fix();
    } else if (location instanceof Cistern) {
      Output.println("You can't fix a cistern", Color.LIGHT_RED);
    } else if (location instanceof Spring) {
      Output.println("You can't fix a spring", Color.LIGHT_RED);
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  /**
   * Inserts a pump into the grid at the Plumber's current location if the location is suitable
   * (i.e., a Pipe) and the Plumber is carrying a pump.
   */
  public void insertPump() {
    Output.println(
        "|------------------5.2.5.1 The Plumber inserts the pump at a pipe Setup--------------------|",
        Color.LIGHT_BLUE);
    System.out.println("insertPump()");
    if (carryPump != null) {
      if (location instanceof Pipe) {
        Pipe newPipe = new Pipe(grid);
        List<Element> pumps = location.getNeighbors();
        carryPump.setInPipe((Pipe) location);
        carryPump.setOutPipe(newPipe);
        carryPump.addPlayer(this);
        location.removeNeighbor(pumps.get(1));
        location.addNeighbor(carryPump);
        location.removePlayer(this);
        newPipe.addNeighbor(carryPump);
        newPipe.addNeighbor(pumps.get(1));
        location = carryPump;
        grid.addPump(carryPump);
        carryPump = null;
      } else {
        Output.println("You can't insert a Pump here!", Color.LIGHT_RED);
      }
    } else {
      Output.println("You don't have a Pump", Color.LIGHT_RED);
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  /**
   * Represents the action of picking up a pump from the current location, assuming the location is
   * a Cistern. If the plumber is not at a Cistern or there are no available pumps, an error message
   * is displayed.
   */
  public void pickPump() {
    Output.println("|-------------5.2.6 The Plumber picks up the pump-------------|",
        Color.LIGHT_BLUE);
    System.out.println("pickPump()");
    if (location instanceof Cistern) {
      carryPump = ((Cistern) location).getPump();
    } else {
      Output.println("You are not at the cistern!", Color.LIGHT_RED);
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  /**
   * Represents the action of picking up a pipe from the current location, assuming the location is
   * a Cistern. If the plumber is not at a Cistern or there are no available pipes, an error message
   * is displayed.
   */
  public void pickPipe() {
    Output.println("|-------------5.2.7.1 The Plumber picks up the pipe at Cistern-------------|",
        Color.LIGHT_BLUE);
    System.out.println("pickPipe()");
    if (location instanceof Cistern) {
      carryPipe = ((Cistern) location).getPipe();
    } else {
      Output.println("You are not at the cistern!", Color.LIGHT_RED);
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  /**
   * Defines the plumber's active behavior in the game. This method prompts the player to choose an
   * action from a predefined list of possible actions, including moving, changing pump direction,
   * and more.
   */
  @Override
  public void active() {
    System.out.println("active()");
    keyTyped();
  }

  /**
   * Defines the plumber's passive behavior in the game. Currently, this method does not implement
   * any specific behavior.
   */
  @Override
  public void passive() {
    System.out.println("passive()");
  }

  /**
   * Processes player input to determine the action the plumber should take. This method allows the
   * player to choose from moving, changing pump direction, disconnecting/connecting pipes, fixing
   * elements, and more.
   */
  public void keyTyped() {
    System.out.println("What does the player do?");
    System.out.println("[m]ove");
    System.out.println("changePump[D]irection()");
    System.out.println("[d]isnnectPipe()");
    System.out.println("[c]onnectPipe()");
    System.out.println("[f]ix()");
    System.out.println("[i]nsertPump()");
    System.out.println("[p]ickPump()");
    System.out.println("pick[P]ipe()");
    switch (Input.getChar("DmdcfipP")) {
      case 'm':
        move();
        break;
      case 'D':
        changePumpDirection();
        break;
      case 'd':
        disconnectPipe();
        break;
      case 'c':
        connectPipe();
        break;
      case 'f':
        fix();
        break;
      case 'i':
        insertPump();
        break;
      case 'p':
        pickPump();
        break;
      case 'P':
        pickPipe();
        break;
    }
  }


  /**
   * Returns the type of this player, which is "plumber".
   * 
   * @return A string indicating the player's type.
   */
  public String type() {
    return "plumber";
  }
}
