package mainstring.dev.Players;
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

  public PlayersCollection(){
    System.out.println("PlayersCollection()");
  }

  public void add(Player player) throws Exception {
    System.out.println("addPlayer(" + player.getName() + ")");
    int size = players.size();
    players.add(player);
    if (size == players.size()) {
      Output.println("The player has been added before!", Color.LIGHT_RED);
      throw new Exception();
    } else {
      System.out.println("The player is added.");
    }
  }

  public void remove(Player player) {
    System.out.println("remmove(" + player.getName() + ")");
    // check minCapacity;
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
