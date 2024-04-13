package mainstring.dev.Elements;

import java.util.*;
import mainstring.dev.Grid;
import mainstring.dev.Output;
import mainstring.dev.Players.Player;
import mainstring.dev.Players.PlayersCollection;

/**
 * Represents an abstract element within a grid. This class serves as a base for different types of
 * elements that can exist in a grid. It manages players located on the element, its neighbors, and
 * interactions between them.
 */
public abstract class Element {
  static int FreeID = 0;
  protected int ID;
  protected Grid grid; // The grid this element is part of
  protected PlayersCollection players = new PlayersCollection(); // Collection of players currently on this element
  protected Class<?> neighborType; // The type of elements that can be neighbors to this element
  protected int capacityOfNeighbors; // Capacity of neighboring elements, not explicitly used
  protected Set<Element> neighbors =  new HashSet<>();// The set of neighboring elements

  @Override
  public int hashCode() {
    return ID;
  }

  @Override
  public String toString() {
    return "[ID,%s,%s]".formatted(ID,players.toStringID(),Output.toStringID(neighbors));
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
  public void addPlayer(Player player) {
    try {
      player.setLocation(this); // Set the player's location to this element
      players.add(player); // Add the player to the collection
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void addPlayers(Collection<Player> players) {
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
    System.out.println("removePlayer(" + player.type() + ")");
    players.remove(player); // Remove the player from the collection
  }

  /**
   * Adds a neighbor to this element if it is of the correct type.
   * 
   * @param neighbor The element to be added as a neighbor.
   */
  public void addNeighbor(Element neighbor) /* throws Exception */ {
    System.out.println("addNeighbor(" + neighbor.type() + ")");
    if (neighborType.isInstance(neighbor)) {
      neighbors.add(neighbor); // Add the neighbor
      if (!neighbor.isConnected(this)) { // Check if the neighbor is already connected
        neighbor.addNeighbor(this); // Add this element as a neighbor to the neighbor
      }
    } else {
      // throw new IllegalArgumentException("Invalid neighbor type");
    }
  }

  /**
   * Removes a neighbor from this element.
   * 
   * @param neighbor The neighbor to remove.
   */
  public void removeNeighbor(Element neighbor) {
    System.out.println("removeNeighbor(" + neighbor.type() + ")");
    neighbors.remove(neighbor); // Remove the neighbor
  }

  /**
   * Checks if an element is connected as a neighbor to this element.
   * 
   * @param element The element to check.
   * @return true if the element is a neighbor, false otherwise.
   */
  public boolean isConnected(Element element) {
    System.out.println("isConnected(" + element.type() + ")");
    return neighbors.contains(element); // Check if the element is in the neighbors set
  }

  /**
   * Returns a list of this element's neighbors.
   * 
   * @return A list of neighboring elements.
   */
  public List<Element> getNeighbors() {
    System.out.println("getNeighbors()");
    return new ArrayList<>(neighbors); // Return a new list containing all neighbors
  }

  /**
   * Checks if an element is a second-level neighbor to this element. Currently always returns true,
   * but intended for future use.
   * 
   * @param element The element to check.
   * @return true always in this implementation.
   */
  public boolean isSecoundNeighbor(Element element) {
    System.out.println("isSecoundNeighbor(" + element.type() + ")");
    // Placeholder implementation
    return true;
  }

  /**
   * Abstract method to return the type of this element. Must be implemented by subclasses to return
   * a unique identifier for the element type.
   * 
   * @return A string representing the type of this element.
   */
  public abstract String type();
}
