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
  int waterInDesert;
  Pipe currentPipe;
  Pipe currentPump;
  Pipe currentPlayer;
  

  //Public Functions
  public void connectPipe(Plumber plumber, ActiveElement Destination){}
	public void puncturePipe(Saboteur Saboteur){}
	public void changePipeDirection(Player player){}
	public void moveToLocation(Player player, ActiveElement Destination){}
  public void insertPump(Plumber plumber){}
  public void caculateFlow(){}
}