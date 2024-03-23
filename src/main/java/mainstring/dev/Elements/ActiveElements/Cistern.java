package mainstring.dev.Elements.ActiveElements;

import java.util.Timer;
import java.util.List;
import mainstring.dev.Elements.*;

public class Cistern extends ActiveElement {
  //Fields
  protected List<Pump> newPumps; //this are the pumps created
  protected List<Pipe> newPipes;
  protected int waterAmount;
  protected Timer timerPipe = new Timer();
  protected Timer timerPump = new Timer();

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
