package mainstring.dev.Players;

import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

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
    System.out.println("remmove(" + player.getName() + ")");
    // check minCapacity;
    players.remove(player);
  }

  public Player selectRandom() {
    System.out.println("What player you want to return? [name]");
    while(true){
      String name = Input.getLine();
      for (Player player : players) {
        if (player.getName().equals(name)) {
          return player;
        }
      }
    }
  }

  public Set<Player> getPlayers() {
    return players;
  }
}
