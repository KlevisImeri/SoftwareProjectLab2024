package mainstring.dev.Players.PlayersCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import mainstring.dev.Output;
import mainstring.dev.Players.Player.Player;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Saboteur.Saboteur;

/**
 * The PlayersCollection class manages a collection of Plumber and Saboteur players.
 * It provides methods to add, remove, and retrieve players, as well as to get a random player.
 */
public class PlayersCollection {
  // List to store plumbers.
  private List<Plumber> plumbers = new ArrayList<>();

  // List to store saboteurs.
  private List<Saboteur> saboteurs = new ArrayList<>();

  /**
   * Returns a string representation of the players in the collection.
   *
   * @return a formatted string with the names of the plumbers and saboteurs
   */
  @Override
  public String toString() {
    return """
        Players:
        Plumbers: %s
        Saboteurs: %s
        """.formatted(Output.toString(plumbers), Output.toString(saboteurs));
  }

  /**
   * Returns a string containing only the names of the players.
   *
   * @return a string with the names of all players
   */
  public String toStringID() {
    List<String> playerNames = new ArrayList<>();
    for (Plumber plumber : plumbers) {
      playerNames.add(plumber.getName());
    }
    for (Saboteur saboteur : saboteurs) {
      playerNames.add(saboteur.getName());
    }
    return "[" + String.join(", ", playerNames) + "]";
  }

  /**
   * Adds a player to the collection.
   *
   * @param player the player to add
   */
  public void add(Player player) {
    if (player instanceof Plumber) {
      plumbers.add((Plumber) player);
    } else if (player instanceof Saboteur) {
      saboteurs.add((Saboteur) player);
    }
  }

  /**
   * Adds a plumber to the collection.
   *
   * @param plumber the plumber to add
   */
  public void add(Plumber plumber) {
    plumbers.add(plumber);
  }

  /**
   * Adds a saboteur to the collection.
   *
   * @param saboteur the saboteur to add
   */
  public void add(Saboteur saboteur) {
    saboteurs.add(saboteur);
  }

  /**
   * Removes a plumber from the collection.
   *
   * @param plumber the plumber to remove
   */
  public void remove(Plumber plumber) {
    plumbers.remove(plumber);
  }

  /**
   * Removes a saboteur from the collection.
   *
   * @param saboteur the saboteur to remove
   */
  public void remove(Saboteur saboteur) {
    saboteurs.remove(saboteur);
  }

  /**
   * Retrieves a player by name from the collection.
   *
   * @param name the name of the player to retrieve
   * @return the player with the specified name, or null if not found
   */
  public Player get(String name) {
    for (Plumber plumber : plumbers) {
      if (plumber.getName().equals(name)) {
        return plumber;
      }
    }
    for (Saboteur saboteur : saboteurs) {
      if (saboteur.getName().equals(name)) {
        return saboteur;
      }
    }
    return null;
  }

  /**
   * Removes a player from the collection.
   *
   * @param player the player to remove
   */
  public void remove(Player player) {
    if (player instanceof Plumber) {
      plumbers.remove(player);
    } else if (player instanceof Saboteur) {
      saboteurs.remove(player);
    }
  }

  /**
   * Selects a random player from the collection.
   *
   * @return a randomly selected player
   */
  public Player selectRandom() {
    List<Player> allPlayers = new ArrayList<>();
    allPlayers.addAll(plumbers);
    allPlayers.addAll(saboteurs);

    if (allPlayers.isEmpty()) {
      throw new RuntimeException("No players available to select.");
    }
    
    Random random = new Random();
    int randomIndex = random.nextInt(allPlayers.size());
    return allPlayers.get(randomIndex);
  }

  /**
   * Returns a list of all players in the collection.
   *
   * @return a list of all players
   */
  public List<Player> getPlayers() {
    List<Player> allPlayers = new ArrayList<>();
    allPlayers.addAll(plumbers);
    allPlayers.addAll(saboteurs);
    return allPlayers;
  }

   /**
   * Returns an unmodifiable list of plumbers in the collection.
   *
   * @return an unmodifiable list of plumbers
   */
  public List<Plumber> getPlumbers() {
    return Collections.unmodifiableList(plumbers);
  }

  /**
   * Returns an unmodifiable list of saboteurs in the collection.
   *
   * @return an unmodifiable list of saboteurs
   */
  public List<Saboteur> getSaboteurs() {
    return Collections.unmodifiableList(saboteurs);
  }

  /**
   * Returns the total number of players in the collection.
   *
   * @return the total number of players
   */
  public int size() {
    return plumbers.size() + saboteurs.size();
  }
}
