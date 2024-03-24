package mainstring.dev.Elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mainstring.dev.Grid;
import mainstring.dev.Players.Player;
import mainstring.dev.Players.PlayersCollection;

public abstract class Element {
  protected Grid grid;
  protected PlayersCollection players = new PlayersCollection(); // here you can set the capacity
  protected Class<?> neighborType;
  protected Set<Element> neighbors = new HashSet<>();
  protected int capacityOfNeighbors;

  public Element(Grid grid) {
    this.grid = grid;
  }
  
  public void addPlayer(Player player) {
    System.out.println("addPlayer()");
    try {
      player.setLocation(this);
      players.add(player);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void removePlayer(Player player) {
    System.out.println("removePlayer("+player.type()+")");
    players.remove(player);
  }

  public void addNeighbor(Element neighbor) /* throws Exception */ {
    System.out.println("addNeighbor("+neighbor.type()+")");
    if (neighborType.isInstance(neighbor)) {
      neighbors.add(neighbor);
      if (!neighbor.isConnected(this)) {
        neighbor.addNeighbor(this);
      }
    } else {
      // throw new IllegalArgumentException("Invalid neighbor type");
    }
  }

  public void removeNeighbor(Element neighbor) {
    System.out.println("removeNeighbor("+neighbor.type()+")");
    neighbors.remove(neighbor);
  }

  public boolean isConnected(Element element) {
    System.out.println("isConnected("+element.type()+")");
    if (neighbors.contains(element))
      return true;
    return false;
  }

  public List<Element> getNeighbors() {
    System.out.println("getNeighbors()");
    return new ArrayList<>(neighbors);
  }

  public boolean isSecoundNeighbor(Element element) {
    System.out.println("isSecoundNeighbor("+element.type()+")");
    return true;
  }

  public abstract String type();
}
