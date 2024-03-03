package mainstring.dev.Elements.ActiveElements;

import java.util.List;
import java.util.Random;
import mainstring.dev.Elements.Element;
import mainstring.dev.Elements.Pipe;
import mainstring.dev.Players.PlayersCollection;

public abstract class ActiveElement extends Element {
  //Fields
  protected PlayersCollection players;
  protected List<Pipe> pipes;
  protected Pipe in;
  protected Pipe out;
  protected Random random = new Random();
}
