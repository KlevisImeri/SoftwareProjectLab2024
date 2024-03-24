package mainstring.dev.Players;

import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Output.Color;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Elements.*;
import java.util.List;

public class Plumber extends Player {
  public Pump carryPump;
  public Pipe carryPipe;

  public Plumber(String name) {
    this.name = name;
  }

  public void disconnectPipe() {
    Output.println("|-------------5.2.9 Disconnect pipe from " + location.type() + "-------------|",
        Color.LIGHT_BLUE);
    System.out.println("disconnectPipe()");
    Pipe sp = grid.getSelectedPipe();
    if (location.isConnected(sp)) {
      if (carryPipe == null) {
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
    Output.println(
        "|----------------5.2.9 Connect pipe with " + location.type() + "-----------------|",
        Color.LIGHT_BLUE);
    System.out.println("connectPipe()");
    if (carryPipe != null) {
      if (location instanceof ActiveElement) {
        System.out.println("Can more pipes be connected to the location? [y]es/[n]no");
        switch (Input.getChar("yn")) {
          case 'y':
            carryPipe.addNeighbor(location);
            location.addNeighbor(carryPipe);
            carryPipe = null;
            break;
          case 'n':
            Output.println("The location is saturated with pipes!", Color.LIGHT_RED);
            break;
        }
      } else {
        Output.println("You can't connect a pipe to a pipe!", Color.LIGHT_RED);
      }
    } else {
      Output.println("The plumber is not carrying any pipe!", Color.LIGHT_RED);
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  public void fix() { // used
    Output.println(
        "|-----------------------5.2.11 Fixing " + location.type() + "--------------------------|",
        Color.LIGHT_BLUE);
    if (location instanceof Pump) {
      ((Pump) location).fix();
    } else if (location instanceof Pipe) {
      ((Pipe) location).fix();
    } else if (location instanceof Cistern) {
      Output.println("You can't fix a cistern", Color.LIGHT_RED);
    } else if (location instanceof Spring) {
      Output.println("You can't fix a spring", Color.LIGHT_RED);
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  public void insertPump() {
    Output.println(
        "|------------------5.2.5.1 The Plumber inserts the pump at a pipe Setup--------------------|",
        Color.LIGHT_BLUE);
    System.out.println("insertPump()");
    if (carryPump != null) {
      if (location instanceof Pipe) {
        Pipe newPipe = new Pipe(grid);
        List<Element> pumps = location.getNeighbors();
        carryPump.setInPipe((Pipe) location);
        carryPump.setOutPipe(newPipe);
        carryPump.addPlayer(this);
        location.removeNeighbor(pumps.get(1));
        location.addNeighbor(carryPump);
        location.removePlayer(this);
        newPipe.addNeighbor(carryPump);
        newPipe.addNeighbor(pumps.get(1));
        location = carryPump;
        grid.addPump(carryPump);
        carryPump = null;
      } else {
        Output.println("You can't insert a Pump here!", Color.LIGHT_RED);
      }
    } else {
      Output.println("You don't have a Pump", Color.LIGHT_RED);
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  public void pickPump() {
    Output.println("|-------------5.2.6 The Plumber picks up the pump-------------|",
        Color.LIGHT_BLUE);
    System.out.println("pickPump()");
    if (location instanceof Cistern) {
      carryPump = ((Cistern) location).getPump();
    } else {
      Output.println("You are not at the cistern!", Color.LIGHT_RED);
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
      Output.println("You are not at the cistern!", Color.LIGHT_RED);
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
    System.out.println("[d]isnnectPipe()");
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
        break;
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
    return "Plumber: " + name;
  }

  public String type() {
    return "plumber";
  }

}
