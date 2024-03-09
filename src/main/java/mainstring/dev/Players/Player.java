package mainstring.dev.Players;

import java.awt.event.*;
import mainstring.dev.Elements.ActiveElements.ActiveElement;
import mainstring.dev.UI.GUI.*;
import mainstring.dev.Grid;

//Controller of Player
public abstract class Player  {
  //Data
  int ID;
  protected ActiveElement location;
  String name;
  Grid grid;
  
  PlayerGUI gui;

  public void keyTyped(KeyEvent e){}
  public void keyPressed(KeyEvent e){}
  public void keyReleased(KeyEvent e){}

  public Player(){}
  public Player(String name, ActiveElement location, int ID, Grid grid) {
    this.name = name;
    this.location = location;
    this.ID = ID;
    this.grid = grid;
  }


  public void move() {
    // if(locatation.isConnected(grid.getCurrentActiveElement())){
    //   location.removePlayer(this);
    //   grid.getCurrentActiveElement().addPlayer(this);
    //   location=ActiveElement
    // }else{
    //   System.err.println("To far away");
    // }
  }

  public void changePumpDirection(){ //used
    // if(location instanceof Pump){
    //   ((Pump)location).changeDirection();
    // }else if (location instanceof Cistern)) {
    //   "You can't change the direction of cistern!"
    // }else if (location instanceof Spring)) {
    //    "You can't change the direction of spring!"
    // }
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