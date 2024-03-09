package mainstring.dev.Players;

import java.util.List;
import java.util.Random;
import mainstring.dev.UI.GUI.PlayersCollectionGUI;

public class PlayersCollection {
  private List<Player> players;
  int minCapacity;
  int maxiCapacity;

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

    Random random = new Random();
    int index = random.nextInt(players.size());
    return players.get(index);
  }
}
