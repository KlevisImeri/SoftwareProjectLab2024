package mainstring.dev.Players;

import java.awt.event.*;
import mainstring.dev.Elements.ActiveElements.ActiveElement;
import mainstring.dev.UI.GUI.*;

//Controller of Player
public abstract class Player implements KeyListener {
  //Data
  int ID;
  protected ActiveElement location;
  String name;
  Grid grid;
  
  //GUI
  PlayerGUI gui = new PlayerGUI();
  
  gui.addMouseListener(this);

  public void keyTyped(KeyEvent e){}
  public void keyPressed(KeyEvent e){}
  public void keyReleased(KeyEvent e){}

  public Player(){}
  public Player(String name, ActiveElement location, int ID) {
    this.name = name;
    this.location = location;
    this.ID = ID;
  }


  public void moveToLocation(ActiveElement newLocation) {
    List<ActiveElements> = location.getNeighbords();
    if(selected.pump is insise  List<ActiveElements>){
      //rempove the player actiove elmenmt
      //add the player to the selected active elemnet
    }else{
      System.err.println("To far away");
    }
  }
  // Method for changing the direction of a pump
  public void changePumpDirection(ActiveElement pump){

  }

  public void active(){
    gui.setEnabled(true);
  }

  public void passive(){
    gui.setEnabled(false);
  }

  // Getters and setters for name and location
  // public String getName() {
  //   return name;
  // }

  // public ActiveElement getLocation() {
  //   return location;
  // }

  // public void setLocation(ActiveElement location) {
  //   this.location = location;
  // }

}
p