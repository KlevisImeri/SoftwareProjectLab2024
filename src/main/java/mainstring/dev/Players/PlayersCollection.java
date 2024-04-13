package mainstring.dev.Players;

import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;
import java.util.*;

/**
 * Represents a collection of Player objects. This class provides functionality to add and remove
 * players, select a player randomly based on user input, and retrieve the current set of players.
 */
public class PlayersCollection {
  private Map<String, Player> playersMap = new HashMap<>();

  @Override
  public String toString() {
    return """
        Players:
        %s
        """.formatted(Output.toString(playersMap.values()));
  }

  // Return a string containing only the names of the players
  public String toStringID() {
    List<String> playerNames = new ArrayList<>();
    for (Player player : playersMap.values()) {
      playerNames.add(player.getName());
    }
    return "[" + String.join(", ", playerNames) + "]";
  }

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
    if (playersMap.containsKey(player.getName())) {
      Output.println("The player has been added before!", Color.LIGHT_RED);
      return false;
    } else {
      playersMap.put(player.getName(), player);
      return true;
    }
  }

  /**
   * Removes a player from the collection.
   *
   * @param player The player to be removed.
   */
  public void remove(Player player) {
    playersMap.remove(player.getName());
  }

  /**
   * Retrieves a player by their name.
   *
   * @param name The name of the player to retrieve.
   * @return The player object corresponding to the name, or null if no such player exists.
   */
  public Player get(String name) {
    return playersMap.get(name);
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
    for (Player p : playersMap.values()) {
      Output.println(p.toString(), Color.LIGHT_MAGENTA);
    }
    while (true) {
      String name = Input.getLine();
      if (playersMap.containsKey(name)) {
        return playersMap.get(name);
      }
      Input.clearPreviousLine();
    }
  }

  /**
   * Retrieves the set of players currently in the collection.
   *
   * @return A set containing all the players.
   */
  public Collection<Player> getPlayers() {
    return playersMap.values();
  }
}
