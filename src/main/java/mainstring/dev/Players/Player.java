package mainstring.dev.Players;

import java.awt.event.*;
import java.util.Objects;
import mainstring.dev.Elements.*;
import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Grid;

// Controller of Player
public abstract class Player {
  // Data
  protected int ID;
  protected Element location;
  protected String name;
  protected Grid grid;

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    Player other = (Player) obj;
    return Objects.equals(name, other.name);
  }

  public void keyTyped(KeyEvent e) {}

  public void keyPressed(KeyEvent e) {}

  public void keyReleased(KeyEvent e) {}

  public Player() {}

  public Player(String name, Element location, int ID, Grid grid) {
    this.name = name;
    this.location = location;
    this.ID = ID;
    this.grid = grid;
  }

  protected void move(Element element) {}

  public void move() {
    try {
      if (location.isConnected(grid.getSelectedElement())) {
        grid.getSelectedElement().addPlayer(this);
        location.removePlayer(this);
        location = grid.getSelectedElement();
      } else {
        System.out.println("To far away");
      }
    } catch (Exception e) {
    }
  }


  public void changePumpDirection() {
    if (location instanceof Pump) {
      ((Pump) location).changeDirection();
    } else if (location instanceof Pipe) {
      System.out.println("You can't change the direction Pipe!");
    } else if (location instanceof Cistern) {
      System.out.println("You can't change the direction of cistern!");
    } else if (location instanceof Spring) {
      System.out.println("You can't change the direction of spring!");
    }
  }

  
  public abstract void active();
  public abstract void passive();

  // Getters and setters for name and location
  public String getName() {
    return name;
  }

  // public ActiveElement getLocation() {
  // return location;
  // }

  // public void setLocation(ActiveElement location) {
  // this.location = location;
  // }
}
