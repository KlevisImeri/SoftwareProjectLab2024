package mainstring.dev.Players.Plumber;

import java.util.List;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Elements.*;
import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Elements.ActiveElements.Cistern.Cistern;
import mainstring.dev.Elements.ActiveElements.Pump.Pump;
import mainstring.dev.Elements.ActiveElements.Spring.Spring;
import mainstring.dev.Elements.Element.Element;
import mainstring.dev.Elements.Pipe.Pipe;
import mainstring.dev.Output.Color;
import mainstring.dev.Players.Player.Player;

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
  public void disconnectPipe() throws Exception {
    try {
      Pipe sp = grid.getSelectedPipe();
      if (location.isConnected(sp)) {
        if (carryPipe == null) {
          System.out.println("[Disconecting]");
          String before = toString();
          location.removeNeighbor(sp);
          carryPipe = sp;
          Output.printChange(before, toString());
          updateViews();
        } else {
          throw new Exception("[You are already carrying a pipe!]");
        }
      } else {
        throw new Exception("[The pipe is too far away!]");
      }
    } catch (Exception e) {
      Output.println(e.getMessage(), Color.LIGHT_RED);
      throw e;
    }
  }

  /**
   * Attempts to connect a pipe to the Plumber's current location. If the Plumber is carrying a
   * pipe, it connects that pipe to the location.
   */
  public void connectPipe()  throws Exception {
    try {
      if (carryPipe != null) {
        String before = toString();
        location.addNeighbor(carryPipe);
        grid.addPipe(carryPipe);
        carryPipe = null;
        Output.printChange(before, toString());
      } else {
        throw new Exception("[You don't have a pipe!]");
      }
    } catch (Exception e) {
      Output.println(e.getMessage(), Color.LIGHT_RED);
      throw e;
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
  public Pipe insertPump() throws Exception {
    try {
      if (carryPump != null) {
        if (location instanceof Pipe) {
          Output.println("[INSERTING PIPE]", Color.RED);
          String before = toString();

          Pipe newPipe = new Pipe(grid);
          List<Element> neighbors = location.getNeighbors();
          location.removeNeighbor(neighbors.get(1));


          carryPump.setInPipe(newPipe);
          carryPump.setOutPipe((Pipe) location);
          // carryPump.addPlayer(this);
          newPipe.addNeighbor(neighbors.get(1));

          grid.addPipe(newPipe);
          grid.addPump(carryPump);
          carryPump = null;

          Output.printChange(before, toString());
          return newPipe;
        } else {
          throw new Exception("[You can't insert a Pump at a " + location.type() + "]");
        }
      } else {
        throw new Exception("[You don't have a Pump!]");
      }
    } catch (Exception e) {
      Output.println(e.getMessage(), Color.LIGHT_RED);
      throw e;
    }
  }

  /**
   * Represents the action of picking up a pump from the current location, assuming the location is
   * a Cistern. If the plumber is not at a Cistern or there are no available pumps, an error message
   * is displayed.
   */
  public void pickPump()  throws Exception {
    try {
      if (!(location instanceof Cistern))
        throw new Exception("[You are not at the cistern!]");
      if(carryPump != null) 
        throw new Exception("[You are already carrying a pump!]");
      String before = toString();
      carryPump = ((Cistern) location).getPump();
      Output.printChange(before, toString());
      updateViews();
    } catch (Exception e) {
      Output.println(e.getMessage(), Color.LIGHT_RED);
      throw e;
    }
  }

  /**
   * Represents the action of picking up a pipe from the current location, assuming the location is
   * a Cistern. If the plumber is not at a Cistern or there are no available pipes, an error message
   * is displayed.
   */
  public void pickPipe() throws Exception {
    try {
      if (!(location instanceof Cistern))
        throw new Exception("[You are not at the cistern!]");
      if(carryPipe != null)
        throw new Exception("[You are already carrying a pipe!]");
      String before = toString();
      carryPipe = ((Cistern) location).getPipe();
      location.addNeighbor(carryPipe);
      Output.printChange(before, toString());
      updateViews();
    } catch (Exception e) {
      Output.println(e.getMessage(), Color.LIGHT_RED);
      throw e;
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
