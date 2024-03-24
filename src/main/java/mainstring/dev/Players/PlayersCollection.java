package mainstring.dev.Players;

import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;
import java.util.Set;
import java.util.HashSet;


public class PlayersCollection {
  private Set<Player> players = new HashSet<>();
  // int minCapacity;
  // int maxCapacity;

  public PlayersCollection() {
    System.out.println("PlayersCollection()");
  }

  public boolean add(Player player) {
    System.out.println("addPlayer(" + player.getName() + ")");
    int size = players.size();
    players.add(player);
    if (size == players.size()) {
      Output.println("The player has been added before!", Color.LIGHT_RED);
      return false;
    } else {
      System.out.println("The player is added.");
      return true;
    }
  }

  public void remove(Player player) {
    System.out.println("remove(" + player.getName() + ")");
    // check minCapacity;
    players.remove(player);
  }

  public Player selectRandom() {
    System.out.println("selectRandom()");
    System.out.println("What player do you want to return? [name]");
    for(Player p : players) {
      System.out.println(p.toString());
    }
    while(true){
      String name = Input.getLine();
      for (Player player : players) {
        if (player.getName().equals(name)) {
          return player;
        }
      }
      Input.clearPreviousLine();
    }
  }

  public Set<Player> getPlayers() {
    return players;
  }
}
