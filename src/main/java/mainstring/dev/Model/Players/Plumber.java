package mainstring.dev.Model.Players;

import java.util.List;
import mainstring.dev.Model.Input;
import mainstring.dev.Model.Output;
import mainstring.dev.Model.Elements.*;
import mainstring.dev.Model.Elements.ActiveElements.*;
import mainstring.dev.Model.Output.Color;

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
    return "P,%s,%s,%s".formatted(super.toString(),
        carryPump != null ? carryPump.hashCode() : "null",
        carryPipe != null ? carryPipe.hashCode() : "null");
  }



  /**
   * Constructs a Plumber with a specified name.
   * 
   * @param name The name of the Plumber.
   */
  public Plumber(String name) {
    this.name = name;
  }

  /**
   * Attempts to disconnect a pipe from its current location. If successful, the Plumber starts
   * carrying the disconnected pipe.
   */
  public void disconnectPipe() {
    try {
      grid.setSelectedPipe();

      Pipe sp = grid.getSelectedPipe();
      if (location.isConnected(sp)) {
        if (carryPipe == null) {
          String before = toString();
          location.removeNeighbor(sp);
          carryPipe = sp;
          Output.printChange(before, toString());
        } else {
          throw new Exception("[You are already carrying a pipe!]");
        }
      } else {
        throw new Exception("[The pipe is too far away!]");
      }
    } catch (Exception e) {
      Output.println(e.getMessage(), Color.LIGHT_RED);
    }
  }

  /**
   * Attempts to connect a pipe to the Plumber's current location. If the Plumber is carrying a
   * pipe, it connects that pipe to the location.
   */
  public void connectPipe() {
    try {
      if (carryPipe == null) {
        String before = toString();
        location.addNeighbor(carryPipe);
        grid.addPipe(carryPipe);
        carryPipe = null;
        Output.printChange(before, toString());
      } else {
        throw new Exception("[You don't have a pump!]");
      }
    } catch (Exception e) {
      Output.println(e.getMessage(), Color.LIGHT_RED);
    }
  }

  /**
   * Fixes the element at the Plumber's current location if it is a Pump or Pipe.
   */
  public void fix() { // used
    if (location instanceof Pump) {
      ((Pump) location).fix();
    } else if (location instanceof Pipe) {
      ((Pipe) location).fix();
    } else if (location instanceof Cistern) {
      Output.println("[You can't fix a cistern!]", Color.LIGHT_RED);
    } else if (location instanceof Spring) {
      Output.println("[You can't fix a spring!]", Color.LIGHT_RED);
    }
  }

  /**
   * Inserts a pump into the grid at the Plumber's current location if the location is suitable
   * (i.e., a Pipe) and the Plumber is carrying a pump.
   */
  public void insertPump() {
    try {
      if (carryPump != null) {
        if (location instanceof Pipe) {
          String before = toString();

          Pipe newPipe = new Pipe(grid);
          List<Element> neighbors = location.getNeighbors();
          location.removeNeighbor(neighbors.get(1));


          carryPump.setInPipe(newPipe);
          carryPump.setOutPipe((Pipe) location);
          carryPump.addPlayer(this);
          newPipe.addNeighbor(neighbors.get(1));

          grid.addPipe(newPipe);
          grid.addPump(carryPump);
          carryPump = null;

          Output.printChange(before, toString());
        } else {
          throw new Exception("[You can't insert a Pump at a " + location.type() + "]");
        }
      } else {
        throw new Exception("[You don't have a Pump!]");
      }
    } catch (Exception e) {
      Output.println(e.getMessage(), Color.LIGHT_RED);
    }
  }

  /**
   * Represents the action of picking up a pump from the current location, assuming the location is
   * a Cistern. If the plumber is not at a Cistern or there are no available pumps, an error message
   * is displayed.
   */
  public void pickPump() {
    try {
      if (!(location instanceof Cistern))
        throw new Exception("[You are not at the cistern!]");
      String before = toString();
      carryPump = ((Cistern) location).getPump();
      Output.printChange(before, toString());
    } catch (Exception e) {
      Output.println(e.getMessage(), Color.LIGHT_RED);
    }
  }

  /**
   * Represents the action of picking up a pipe from the current location, assuming the location is
   * a Cistern. If the plumber is not at a Cistern or there are no available pipes, an error message
   * is displayed.
   */
  public void pickPipe() {
    try {
      if (!(location instanceof Cistern))
        throw new Exception("[You are not at the cistern!]");
      String before = toString();
      carryPipe = ((Cistern) location).getPipe();
      Output.printChange(before, toString());
    } catch (Exception e) {
      Output.println(e.getMessage(), Color.LIGHT_RED);
    }
  }

  /**
   * Defines the plumber's active behavior in the game. This method prompts the player to choose an
   * action from a predefined list of possible actions, including moving, changing pump direction,
   * and more.
   */
  @Override
  public void active() {
    keyTyped();
  }

  /**
   * Defines the plumber's passive behavior in the game. Currently, this method does not implement
   * any specific behavior. This is for future implementatoin when gui is needed.
   */
  @Override
  public void passive() {}

  /**
   * Processes player input to determine the action the plumber should take. This method allows the
   * player to choose from moving, changing pump direction, disconnecting/connecting pipes, fixing
   * elements, and more.
   */
  public void keyTyped() {
    System.out.println("What does the player do?");
    String lightMagenta = "\u001B[95m";
    String resetColor = "\u001B[0m";
    System.out.println(lightMagenta + "[m]" + resetColor + "ove");
    System.out.println("changePump" + lightMagenta + "[D]" + resetColor + "irection()");
    System.out.println(lightMagenta + "[d]" + resetColor + "isconnectPipe()");
    System.out.println(lightMagenta + "[c]" + resetColor + "onnectPipe()");
    System.out.println(lightMagenta + "[f]" + resetColor + "ix()");
    System.out.println(lightMagenta + "[i]" + resetColor + "nsertPump()");
    System.out.println(lightMagenta + "[p]" + resetColor + "ickPump()");
    System.out.println(lightMagenta + "[P]" + resetColor + "ickPipe()");

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
