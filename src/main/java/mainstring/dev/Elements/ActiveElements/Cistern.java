package mainstring.dev.Elements.ActiveElements;

import java.util.Timer;
import java.util.List;
import mainstring.dev.UI.GUI.CisternGUI;
import mainstring.dev.Elements.*;

public class Cistern extends ActiveElement {
  //Fields
  List<Pump> newPumps; //this are the pumps created
  List<Pipe> newPipes;
  int waterAmount;
  private Timer timerPipe = new Timer();
  private Timer timerPump = new Timer();
  private CisternGUI gui = new CisternGUI();

  //Private Functions
  private void schedulePipeCreation(){ createPipe();}
  private void schedulePumpCreation(){ createPump();}
  private void createPump(){}
  private void createPipe(){}
  private void addWater() {} //it also checks that water not negative
  private void removewater() {} //it also checks that water not negative
  //Public Functions
  public Cistern() {
    schedulePipeCreation();
    schedulePumpCreation();
  }
  public Pump getPump() { return newPumps.remove(newPumps.size()-1);} //used //We have to check if no pumps
  public Pipe getPipe() { return newPipes.remove(newPipes.size()-1);} //used //We have to check if no pumps
  @Override
  public void Flow(){
    for (Element element : neighbors) {
      if(((Pipe)element).isFull()) { 
        ((Pipe)element).empty();
        addWater();
      }
    } 
    for(int i=0; i<newPipes.size(); i++){removewater();}
  }
  public int getWaterAmount() {return this.waterAmount;}
}
