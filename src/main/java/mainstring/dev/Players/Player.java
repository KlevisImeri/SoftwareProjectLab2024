package mainstring.dev.Players;

import java.awt.event.*;
import mainstring.dev.Elements.ActiveElements.ActiveElement;
import mainstring.dev.UI.GUI.*;

//Controller of Player
public abstract class Player implements MouseListener, KeyListener {
  //Data
  int ID;
  protected ActiveElement location;
  String name;
  
  //GUI
  PlayerGUI gui = new PlayerGUI();
    

  public void mousePressed(MouseEvent e){}
  public void mouseReleased(MouseEvent e){}
  public void mouseEntered(MouseEvent e){}
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
