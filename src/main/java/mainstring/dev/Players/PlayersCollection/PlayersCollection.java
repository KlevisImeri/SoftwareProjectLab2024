package mainstring.dev.Players.PlayersCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;
import mainstring.dev.Players.Player.Player;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Saboteur.Saboteur;

public class PlayersCollection {
  private List<Plumber> plumbers = new ArrayList<>();
  private List<Saboteur> saboteurs = new ArrayList<>();

  @Override
  public String toString() {
    return """
        Players:
        Plumbers: %s
        Saboteurs: %s
        """.formatted(Output.toString(plumbers), Output.toString(saboteurs));
  }

  // Return a string containing only the names of the players
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

  public void add(Player player) {
    if (player instanceof Plumber) {
      plumbers.add((Plumber) player);
    } else if (player instanceof Saboteur) {
      saboteurs.add((Saboteur) player);
    }
  }

  public void add(Plumber plumber) {
    plumbers.add(plumber);
  }

  public void add(Saboteur saboteur) {
    saboteurs.add(saboteur);
  }

  public void remove(Plumber plumber) {
    plumbers.remove(plumber);
  }

  public void remove(Saboteur saboteur) {
    saboteurs.remove(saboteur);
  }

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

  public void remove(Player player) {
    if (player instanceof Plumber) {
      plumbers.remove(player);
    } else if (player instanceof Saboteur) {
      saboteurs.remove(player);
    }
  }

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

  public List<Player> getPlayers() {
    List<Player> allPlayers = new ArrayList<>();
    allPlayers.addAll(plumbers);
    allPlayers.addAll(saboteurs);
    return allPlayers;
  }

  public List<Plumber> getPlumbers() {
    return Collections.unmodifiableList(plumbers);
  }

  public List<Saboteur> getSaboteurs() {
    return Collections.unmodifiableList(saboteurs);
  }

  public int size() {
    return plumbers.size() + saboteurs.size();
  }
}
