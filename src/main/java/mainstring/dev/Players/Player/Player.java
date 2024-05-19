package mainstring.dev.Players.Player;


import java.util.Objects;
import javax.print.attribute.standard.Destination;
import mainstring.dev.Output;
import mainstring.dev.Elements.*;
import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Elements.ActiveElements.Cistern.Cistern;
import mainstring.dev.Elements.ActiveElements.Pump.Pump;
import mainstring.dev.Elements.ActiveElements.Spring.Spring;
import mainstring.dev.Elements.Element.Element;
import mainstring.dev.Elements.Pipe.Pipe;
import mainstring.dev.Grid.Grid;
import mainstring.dev.Output.Color;


/**
 * Represents an abstract player in the game. This class provides the foundational attributes and
 * behavior for players, including movement, identification, and interaction within the game grid.
 */
public abstract class Player {
  // Player's name as unique identifier for the player
  protected String name;

  // Current location of the player within the grid
  protected Element location;

  // The game grid to which the player belongs
  protected Grid grid;

  /**
   * Provides a string representation of the player, typically used for debugging purposes. This is
   * also used as outptu for the tests.
   * 
   * @return A string representation of the player, including the player's name and location.
   */
  @Override
  public String toString() {
    return "%s,%s".formatted(name, location != null ? location.hashCode() : "null");
  }

  /**
   * Generates a hash code based on the player's name. This method is overridden to ensure that
   * players can be effectively used in collections that rely on hash codes.
   * 
   * @return An integer hash code value for the player.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  /**
   * Compares this player to another object for equality. Players are considered equal if their
   * names are the same.
   * 
   * @param obj The object to be compared with this player.
   * @return true if the specified object is a player with the same name; false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    Player other = (Player) obj;
    return Objects.equals(name, other.name);
  }


  /**
   * Default constructor for creating a player without initial properties.
   */
  public Player() {}

  /**
   * Constructs a player with a specified name, location, ID, and associated grid.
   * 
   * @param name The name of the player.
   * @param location The starting location of the player within the grid.
   * @param ID The unique identifier for the player.
   * @param grid The grid to which the player belongs.
   */
  public Player(String name, Element location, Grid grid) {
    this.name = name;
    this.location = location;
    this.grid = grid;
  }

  /**
   * Moves the player from their current location to a selected element within the grid, if
   * possible. The movement is contingent upon the destination being connected to the current
   * location and not being occupied by too many players.
   */
  public void move() throws Exception {
    try {
      Element destination = grid.getSelectedElement();
      System.out.println(destination);
      System.out.println(location);
      if (!location.isConnected(destination))
        throw new Exception("[The destination is too far!]");

      String before = toString();
      destination.addPlayer(this);
      Output.printChange(before, toString());


    } catch (Exception e) {
      Output.println(e.getMessage(), Color.LIGHT_RED);
      throw e;
    }
  }

  /**
   * Attempts to change the direction of the pump. If the player's current location is a Pump, it
   * changes its direction. If the player is located on a Pipe, Cistern, or Spring, it notifies that
   * changing direction is not applicable.
   */
  public void changePumpDirection() {
    if (location instanceof Pump) {
      ((Pump) location).changeDirection();
    } else if (location instanceof Pipe) {
      Output.println("You can't change the direction Pipe!", Color.LIGHT_RED);
    } else if (location instanceof Cistern) {
      Output.println("You can't change the direction of cistern!", Color.LIGHT_RED);
    } else if (location instanceof Spring) {
      Output.println("You can't change the direction of spring!", Color.LIGHT_RED);
    }
  }

  /**
   * Abstract method that defines the active behavior of the player. This behavior must be
   * implemented by subclasses to specify how the player acts when active in the game.
   */
  public abstract void active();

  /**
   * Abstract method that defines the passive behavior of the player. This behavior must be
   * implemented by subclasses to specify how the player acts when passive in the game.
   */
  public abstract void passive();

  /**
   * Abstract method that returns the type of the player. Subclasses must implement this method to
   * provide a string representation of the player's type.
   * 
   * @return A string representing the type of the player.
   */
  public abstract String type();

  /**
   * Gets the name of the player.
   * 
   * @return The name of the player.
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the grid to which the player belongs. This method allows reassigning the player to a
   * different grid.
   * 
   * @param grid The new grid to set for the player.
   */
  public void setGrid(Grid grid) {
    this.grid = grid;
  }

  /**
   * Sets the location of the player within the grid. This method allows moving the player to a
   * different element.
   * 
   * @param location The new location to set for the player.
   */
  public void setLocation(Element location) {
    this.location = location;
  }

  /**
   * Retrieves the location of the player.
   * 
   * @return The location of the player.
   */
  public Element getLocation() {
    return location;
  }
}
