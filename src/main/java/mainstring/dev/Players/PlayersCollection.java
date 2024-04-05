package mainstring.dev.Players;

import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;
import java.util.Set;
import java.util.HashSet;


/**
 * Represents a collection of Player objects. This class provides functionality to add and remove
 * players, select a player randomly based on user input, and retrieve the current set of players.
 */
public class PlayersCollection {
  private Set<Player> players = new HashSet<>();
  // int minCapacity; // Unused fields for potential future use regarding capacity limits.
  // int maxCapacity;

  /**
   * Constructs a new PlayersCollection instance. Initial setup can be placed here if needed.
   */
  public PlayersCollection() {
    // System.out.println("PlayersCollection()");
  }

  /**
   * Attempts to add a player to the collection. If the player is already present, it indicates
   * failure.
   * 
   * @param player The player to be added to the collection.
   * @return true if the player was successfully added, false if the player was already in the
   *         collection.
   */
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

  /**
   * Removes a player from the collection.
   * 
   * @param player The player to be removed.
   */
  public void remove(Player player) {
    System.out.println("remove(" + player.getName() + ")");
    // Future checks for minCapacity could be implemented here.
    players.remove(player);
  }

  /**
   * Selects a random player from the collection based on user input. Continuously prompts for a
   * player's name until a valid name is entered.
   * 
   * @return The player corresponding to the entered name.
   */
  public Player selectRandom() {
    System.out.println("selectRandom()");
    System.out.println("What player do you want to return? [name]");
    for (Player p : players) {
      Output.println(p.toString(),Color.LIGHT_MAGENTA);
    }
    while (true) {
      String name = Input.getLine();
      for (Player player : players) {
        if (player.getName().equals(name)) {
          return player;
        }
      }
      Input.clearPreviousLine();
    }
  }

  /**
   * Retrieves the set of players currently in the collection.
   * 
   * @return A set containing all the players.
   */
  public Set<Player> getPlayers() {
    return players;
  }
}
