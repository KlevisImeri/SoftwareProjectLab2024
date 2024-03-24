package mainstring.dev.Players;

import java.awt.event.*;
import java.util.Objects;
import mainstring.dev.Elements.*;
import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Grid;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;

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

  public void move() {
    Output.println("|-------------5.2.9 The " + type() + " moves from " + location.type() + " to "
        + grid.getSelectedElement().type() + "-------------|", Color.LIGHT_BLUE);
    System.out.println("move()");
    try {
      if (location.isConnected(grid.getSelectedElement())) {
        System.out.println("Is the destination element free of players? [y]es/[n]o");
        if(Input.getChar("yn")=='y') {
          grid.getSelectedElement().addPlayer(this);
          location.removePlayer(this);
          location = grid.getSelectedElement();
        } else {
          System.out.println("The element has to many players standing on it!");
        }
      } else {
        System.out.println("The destination is too far!");
      }
    } catch (Exception e) {
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  public void changePumpDirection() {
    Output.println("|--------------5.2.8 The "+type()+" changes the pump direction-------------|", Color.LIGHT_BLUE);
    System.out.println("changePumpDirection()");
    if (location instanceof Pump) {
      ((Pump) location).changeDirection();
    } else if (location instanceof Pipe) {
      System.out.println("You can't change the direction Pipe!");
    } else if (location instanceof Cistern) {
      System.out.println("You can't change the direction of cistern!");
    } else if (location instanceof Spring) {
      System.out.println("You can't change the direction of spring!");
    }
    Output.println("|--------------------------------------------------------------------|\n",
    Color.LIGHT_BLUE);
  }


  public abstract void active();

  public abstract void passive();

  public abstract String type();

  // Getters and setters for name and location
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Plumber: " + name;
  }
  // public ActiveElement getLocation() {
  // return location;
  // }

  public void setGrid(Grid grid) {
    this.grid = grid;
  }

  public void setLocation(Element location) {
    this.location = location;
  }
}
