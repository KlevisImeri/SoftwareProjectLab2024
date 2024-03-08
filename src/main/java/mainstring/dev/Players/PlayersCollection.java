package mainstring.dev.Players;

import java.util.List;

public class PlayersCollection {
  List<Plumber> plumbers;
  List<Saboteur> saboteurs;

  public Player selectRandom(){ return plumbers.get(0);}
}
