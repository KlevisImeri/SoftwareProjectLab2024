package mainstring.dev.Players;

import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Elements.*;
import java.awt.event.*;
import java.util.List;

public class Plumber extends Player {
  Pump carryPump;
  Pipe carryPipe;

  public void connectPipe() throws Exception { //used 
      //check if the Selected pipe is connected at the locatoin of player and
      //check that the selected pump is a neighbor of the location:
      boolean isPipeClose = location.isConnected(grid.getSelectedPipe()); 
      boolean isPumpClose = location.isSecoundNeighbor(grid.getSelectedActiveElement());
      if(isPipeClose && isPumpClose){
         //connect the end at location of the selcted pipe ot the new selected pump
         location.removeNeighbor(grid.getSelectedPipe());
         grid.getSelectedPump().addNeighbor(grid.getSelectedPipe());
         //move the player to the selected pump
         move(grid.getSelectedPump());//(grid.getSelectedActiveElement is in neighbors)) can also be checked here
      }else{
         System.out.println("Pipe is to far away");
     }
  }
  public void connectNewPipe() throws Exception {
    if(location instanceof ActiveElement){
      carryPipe.addNeighbor(location); //they should contain each other so it doesn't matter
      location.addNeighbor(carryPipe);     
      carryPipe=null;
    }else{
      System.out.println("You can connect a New Pipe here!");
    }
  }

  public void fix() { // used
    if (location instanceof Pump) {
      ((Pump) location).fix();
    }else if (location instanceof Pipe) {
      ((Pipe) location).fix();
    } else if (location instanceof Cistern) {
      System.out.println("You can't fix a cistern");
    } else if (location instanceof Spring) {
      System.out.println("You can't fix a spring");
    }
  }

  public void insertPump() throws Exception{    
    if(carryPump!=null){
      if(location instanceof Pipe){
        Pipe newPipe = new Pipe();
        List<Element> pumps = location.getNeighbors();
        carryPump.setOutPipe(newPipe);
        carryPump.setInPipe((Pipe) location);
        carryPump.addPlayer(this);
        location.removeNeighbor(pumps.get(1));
        location.addNeighbor(carryPump);
        location.removePlayer(this);
        newPipe.addNeighbor(carryPump); 
        newPipe.addNeighbor(pumps.get(1));
        location = carryPump;
        carryPump=null;
      }else{
        System.out.println("You cant insert a Pump here!"); 
      }
    }else{
      System.out.println("You don't have a Pump"); 
    }
  }

  public void pickPump() {
    if (location instanceof Cistern){
      carryPump = ((Cistern)location).getPump();
    }else {
      System.out.println("You are not at the cistern!");
    }
  }

  public void pickPipe() {
    if (location instanceof Cistern){
      carryPipe = ((Cistern)location).getPipe();
    }else {
      System.out.println("You are not at the cistern!");
    }
  }

  public void keyTyped(KeyEvent e) {
    // big stiwch
    // e.getCharType()="c" -> connectPipe()
    // e.getCharType()="f" -> fixPump()
    // e.getCharType()="r" -> fixPipe()
    // d -> changePumpDirection()
    // i -> insertPump()
    // p -> pickPump()
  }
}
