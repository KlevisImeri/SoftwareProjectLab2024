package mainstring.dev.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import mainstring.dev.Grid;
import mainstring.dev.Players.Player;
import mainstring.dev.Players.PlayersCollection;

public abstract class Element { 
  protected Grid grid;
  protected PlayersCollection players; //here you can set the capacity
  protected Class<?> neighborType;
  protected Set<Element> neighbors;
  protected int capacityOfNeighbors;
  public void addPlayer(Player player)throws Exception{
    players.add(player);
  }
  public void removePlayer(Player player) throws Exception {}
  public void addNeighbor(Element neighbor) throws Exception {
    if (neighborType.isInstance(neighbor)) {
        neighbors.add(neighbor);
    } else {
        throw new IllegalArgumentException("Invalid neighbor type");
    }
  }
  public void removeNeighbor(Element neighbor) throws Exception {}
  public boolean isConnected(Element element){
   if(neighbors.contains(element)) return true;
   return false;
  }
  public List<Element> getNeighbors() {return new ArrayList<>(neighbors);}
  public boolean isSecoundNeighbor(Element element){ return true;}
}
