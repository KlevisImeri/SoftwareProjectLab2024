package mainstring.dev.Players.PlayersCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;
import mainstring.dev.Players.Player.Player;

public class PlayersCollection {
  private List<Player> players = new ArrayList<>();

  @Override
  public String toString() {
    return """
        Players:
        %s
        """.formatted(Output.toString(players));
  }

  // Return a string containing only the names of the players
  public String toStringID() {
    List<String> playerNames = new ArrayList<>();
    for (Player player : players) {
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


  public void add(Player player) {
    players.add(player);
  }

  /**
   * Removes a player from the collection.
   *
   * @param player The player to be removed.
   */
  public void remove(Player player) {
    players.remove(player);
  }

  /**
   * Retrieves a player by their name.
   *
   * @param name The name of the player to retrieve.
   * @return The player object corresponding to the name, or null if no such player exists.
   */
  public Player get(String name) {
    for (Player player : players) {
      if (player.getName().equals(name)) {
        return player;
      }
    }
    return null;
  }

  /**
   * Selects a random player from the collection based on user input. Continuously prompts for a
   * player's name until a valid name is entered.
   *
   * @return The player corresponding to the entered name.
   */
  public Player selectRandom() {
    Output.println("Who's turn? [name]", Color.WHITE);
    for (Player p : players) {
      Output.println(p.getName(), Color.LIGHT_MAGENTA);
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
  public Collection<Player> getPlayers() {
    return players;
  }

  /**
   * Returns the number of players in the players.
   * 
   * @return The size of the players.
   */
  public int size() {
    return players.size();
  }
}
