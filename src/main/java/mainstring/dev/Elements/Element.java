package mainstring.dev.Elements;

import java.util.*;
import mainstring.dev.Output;
import mainstring.dev.Grid.Grid;
import mainstring.dev.Players.Player.Player;
import mainstring.dev.Players.PlayersCollection.PlayersCollection;

/**
 * Represents an abstract element within a grid. This class serves as a base for different types of
 * elements that can exist in a grid. It manages players located on the element, its neighbors, and
 * interactions between them.
 */
public abstract class Element {
  public static int FreeID = 0;
  protected int ID;
  protected Grid grid; // The grid this element is part of
  protected PlayersCollection players = new PlayersCollection(); // Collection of players currently
                                                                 // on this element
  protected Class<?> neighborType; // The type of elements that can be neighbors to this element
  protected int capacityOfNeighbors = Integer.MAX_VALUE; // Capacity of neighboring elements, not
                                                         // explicitly used
  protected Set<Element> neighbors = new HashSet<>();// The set of neighboring elements

  /**
   * Returns a hash code value for the element based on its unique identifier.
   * 
   * @return The hash code value for the element.
   */
  @Override
  public int hashCode() {
    return ID;
  }

  /**
   * Returns a string representation of the element including its identifier, associated players,
   * and neighboring elements.
   * 
   * @return A string representation of the element.
   */
  @Override
  public String toString() {
    return "ID:%s,%s,%s".formatted(ID, players.toStringID(), Output.toStringID(neighbors));
  }

  /**
   * Constructs a new Element within a specified grid.
   * 
   * @param grid The grid this element is part of.
   */
  public Element(Grid grid) {
    this.ID = FreeID++;
    this.grid = grid;
  }

  /**
   * Adds a player to this element.
   * 
   * @param player The player to add to this element.
   */
  public void addPlayer(Player player) throws Exception {
    if (players.size() == capacityOfNeighbors)
      throw new Exception("[The element has to many players standing on it!]");
    String before = toString();
    if (player.getLocation() != null)
      player.getLocation().removePlayer(player); // remove player from previous location
    player.setLocation(this); // Set the player's location to this element
    players.add(player); // Add the player to the collection
    Output.printChange(before, toString());
  }

  /**
   * Adds multiple players to the collection of players associated with the element.
   * 
   * @param players The collection of players to add.
   * @throws Exception If an error occurs while adding a player.
   */
  public void addPlayers(Collection<Player> players) throws Exception {
    for (Player p : players) {
      addPlayer(p);
    }
  }

  /**
   * Removes a player from this element.
   * 
   * @param player The player to remove from this element.
   */
  public void removePlayer(Player player) {
    String before = toString();
    players.remove(player); // Remove the player from the collection
    Output.printChange(before, toString());
  }

  /**
   * Adds a neighbor to this element if it is of the correct type.
   * 
   * @param neighbor The element to be added as a neighbor.
   */
  public void addNeighbor(Element neighbor) throws Exception {
    if (neighborType.isInstance(neighbor)) {
      String before = toString();
      neighbors.add(neighbor); // Add the neighbor
      if (!neighbor.isConnected(this)) { // Check if the neighbor is already connected
        neighbor.addNeighbor(this); // Add this element as a neighbor to the neighbor
      }
      Output.printChange(before, toString());
    } else {
      throw new IllegalArgumentException(
          "[You cant add " + neighbor.type() + " into " + this.type() + "!]");
    }
  }

  /**
   * Removes a neighbor from this element.
   * 
   * @param neighbor The neighbor to remove.
   */
  public void removeNeighbor(Element neighbor) throws Exception {
    if (neighborType.isInstance(neighbor)) {
      String before = toString();
      neighbors.remove(neighbor);
      if (neighbor.isConnected(this)) { // Check if the neighbor is already connected
        neighbor.removeNeighbor(this); // Add this element as a neighbor to the neighbor
      }
      Output.printChange(before, toString());
    } else {
      throw new IllegalArgumentException(
          "[You cant remove " + neighbor.type() + " from " + this.type() + "!]");
    }
  }

  /**
   * Checks if an element is connected as a neighbor to this element.
   * 
   * @param element The element to check.
   * @return true if the element is a neighbor, false otherwise.
   */
  public boolean isConnected(Element element) {
    return neighbors.contains(element); // Check if the element is in the neighbors set
  }

  /**
   * Returns a list of this element's neighbors.
   * 
   * @return A list of neighboring elements.
   */
  public List<Element> getNeighbors() {
    return new ArrayList<>(neighbors); // Return a new list containing all neighbors
  }

  /**
   * Abstract method to return the type of this element. Must be implemented by subclasses to return
   * a unique identifier for the element type.
   * 
   * @return A string representing the type of this element.
   */
  public abstract String type();

  /**
   * Retrieves the unique identifier (ID) of the element.
   * 
   * @return The unique identifier (ID) of the element.
   */
  public int getID() {
    return ID;
  }
}
