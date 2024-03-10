package mainstring.dev.Players;

import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mainstring.dev.UI.GUI.PlayersCollectionGUI;

public class PlayersCollection {
  private Set<Player> players;
  int minCapacity;
  int maxCapacity;

  PlayersCollectionGUI gui = new PlayersCollectionGUI();

  public void add(Player player) {
    //check maxiCapacity
    players.add(player);
  }

  public void remove(Player player) {
    //check minCapacity;
    players.remove(player);
  }

  public Player selectRandom() {
    if (players.isEmpty())
      return null;

    List<Player> playerList = new ArrayList<>(players);
    Random random = new Random();
    int index = random.nextInt(playerList.size());
    return playerList.get(index);
  }
}
