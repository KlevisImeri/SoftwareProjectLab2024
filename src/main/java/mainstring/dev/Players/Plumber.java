package mainstring.dev.Players;

import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Output.Color;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Elements.*;
import java.util.List;

public class Plumber extends Player {
  private Pump carryPump;
  private Pipe carryPipe;

  public Plumber(String name) {
    this.name = name;
  }

  public void disconnectPipe() {
    Pipe sp = grid.getSelectedPipe();
    if (location.isConnected(sp)) {
      if (carryPipe != null) {
        location.removeNeighbor(sp);
        sp.removeNeighbor(location);
        carryPipe = sp;
      } else {
        System.out.println("You are already carrying  a pipe!");
      }
    } else {
      System.out.println("The pipe is too far away!");
    }
  }

  public void connectPipe() {
    System.out.println("connectPipe()");
    if (carryPipe != null) {
      if (location instanceof ActiveElement) {
        System.out.println("The Location is an active element!");
        System.out.println("addNeighbor(activeElement)");
        carryPipe.addNeighbor(location); // they should contain each other so it doesn't matter
        System.out.println("addNeighbor(Pipe)");
        location.addNeighbor(carryPipe);
        carryPipe = null;
      } else {
        System.out.println("You can't connect a pipe to a pipe!");
      }
    }
    else {
      Output.println("The plumber is not carrying any pipe!", Color.LIGHT_RED);
    }
  }

  public void fix() { // used
    if (location instanceof Pump) {
      ((Pump) location).fix();
    } else if (location instanceof Pipe) {
      ((Pipe) location).fix();
    } else if (location instanceof Cistern) {
      System.out.println("You can't fix a cistern");
    } else if (location instanceof Spring) {
      System.out.println("You can't fix a spring");
    }
  }

  public void insertPump() {
    System.out.println("insertPump()");
    if (carryPump != null) {
      if (location instanceof Pipe) {
        System.out.println("Pipe()");
        Pipe newPipe = new Pipe(grid);
        System.out.println("getNeighbors()");
        List<Element> pumps = location.getNeighbors();
        System.out.println("setInPipe()");
        carryPump.setInPipe((Pipe) location);
        System.out.println("setOutPipe()");
        carryPump.setOutPipe(newPipe);
        System.out.println("addPlayer()");
        carryPump.addPlayer(this);
        System.out.println("removeNeighbor(Element)");
        location.removeNeighbor(pumps.get(1));
        System.out.println("addNeighbor(carryPump)");
        location.addNeighbor(carryPump);
        System.out.println("removePlayer(Plumber)");
        location.removePlayer(this);
        System.out.println("addNeighbor(carryPump)");
        newPipe.addNeighbor(carryPump);
        System.out.println("addNeighbor(Element)");
        newPipe.addNeighbor(pumps.get(1));
        location = carryPump;
        grid.addPump(carryPump);
        carryPump = null;
      } else {
        System.out.println("You can't insert a Pump here!");
      }
    } else {
      System.out.println("You don't have a Pump");
    }
  }

  public void pickPump() {
    Output.println("|-------------5.2.6.1 The Plumber picks up the pump-------------|",
    Color.LIGHT_BLUE);
    System.out.println("pickPump()");
    if (location instanceof Cistern) {
      carryPump = ((Cistern) location).getPump();
    } else {
      System.out.println("You are not at the cistern!");
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  public void pickPipe() {
    Output.println("|-------------5.2.7.1 The Plumber picks up the pipe at Cistern-------------|",
    Color.LIGHT_BLUE);
    System.out.println("pickPipe()");
    if (location instanceof Cistern) {
      carryPipe = ((Cistern) location).getPipe();
    } else {
      System.out.println("You are not at the cistern!");
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  @Override
  public void active() {
    System.out.println("active()");
    keyTyped();
  }
  
  @Override
  public void passive() {
    System.out.println("passive()");
  }
  
  public void keyTyped() {
    System.out.println("What does the player do?");
    System.out.println("[m]ove");
    System.out.println("changePump[D]irection()");
    System.out.println("[d]onnectPipe()");
    System.out.println("[c]onnectPipe()");
    System.out.println("[f]ix()");
    System.out.println("[i]nsertPump()");
    System.out.println("[p]ickPump()");
    System.out.println("pick[P]ipe()");
    switch (Input.getChar("DmdcfipP")) {
      case 'm':
        move();
        break;
      case 'D':
        changePumpDirection();
        break;
      case 'd':
        disconnectPipe();
      case 'c':
        connectPipe();
        break;
      case 'f':
        fix();
        break;
      case 'i':
        insertPump();
        break;
      case 'p':
        pickPump();
        break;
      case 'P':
        pickPipe();
        break;
    }
  }
  
  @Override
  public String toString() {
    return "Plumber: "+name;
  }

  public String type() {
    return "plumber";
  }

}
