package mainstring.dev.Elements.ActiveElements;

import java.util.Random;
import java.util.Timer;
import java.util.List;
import mainstring.dev.UI.GUI.CisternGUI;

public class Cistern extends ActiveElement {
  //Fields
  List<Pump> pumps;
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
  public Pump getPump() { return pumps.remove(pumps.size()-1);} //We have to check if no pumps
}
