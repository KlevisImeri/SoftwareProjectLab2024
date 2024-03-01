package mainstring.dev;

import java.util.List;
import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Players.*;
import mainstring.dev.Elements.*;

public class Grid {
  //Fields
  Cistern cistern = new Cistern();
  Spring spring = new Spring();
  List<Pump> pumps;

  //Public Functions
  public void connectPipe(Plumber plumber, Pipe pipe, ActiveElement Destination){}
	public void puncturePipe(Saboteur Saboteur, Pipe pipe){}
	public void changePipeDirection(Player player, Pipe pipe){}
	public void moveToLocation(Player player, ActiveElement Destination){}
  public void insertPump(Plumber plumber, Pipe pipe){}
}