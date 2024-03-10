package mainstring.dev.Elements.ActiveElements;

import java.util.Timer;
import java.util.List;
import mainstring.dev.UI.GUI.CisternGUI;
import mainstring.dev.Elements.Pipe;

public class Cistern extends ActiveElement {
  //Fields
  List<Pump> newPumps; //this are the pumps created
  List<Pipe> newPipes;
  int waterAmount;
  private Timer timerPipe = new Timer();
  private Timer timerPump = new Timer();
  private CisternGUI gui = new CisternGUI();

  //Private Functions
  private void schedulePipeCreation(){}
  private void schedulePumpCreation(){}
  private void createPump(){}
  private void createPipe(){}

  //Public Functions
  public Cistern() {
    schedulePipeCreation();
    schedulePumpCreation();
  }
  public Pump getPump() { return newPumps.remove(newPumps.size()-1);} //used //We have to check if no pumps
  public Pipe getPipe() { return newPipes.remove(newPipes.size()-1);} //used //We have to check if no pumps
  @Override
  public void Flow(){
    
  }
}
