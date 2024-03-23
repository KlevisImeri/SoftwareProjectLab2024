package mainstring.dev.Players;

import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Input;
import mainstring.dev.Elements.*;
import java.awt.event.*;
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
    if (location instanceof ActiveElement) {
      carryPipe.addNeighbor(location); // they should contain each other so it doesn't matter
      location.addNeighbor(carryPipe);
      carryPipe = null;
    } else {
      System.out.println("You can connect a Pipe here!");
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
    if (carryPump != null) {
      if (location instanceof Pipe) {
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
        grid.addPump(carryPump);
        carryPump = null;
      } else {
        System.out.println("You cant insert a Pump here!");
      }
    } else {
      System.out.println("You don't have a Pump");
    }
  }

  public void pickPump() {
    if (location instanceof Cistern) {
      carryPump = ((Cistern) location).getPump();
    } else {
      System.out.println("You are not at the cistern!");
    }
  }

  public void pickPipe() {
    if (location instanceof Cistern) {
      carryPipe = ((Cistern) location).getPipe();
    } else {
      System.out.println("You are not at the cistern!");
    }
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
    System.out.println("KeyTyped()");
    System.out.println("[d]onnectPipe()");
    System.out.println("[c]onnectPipe()");
    System.out.println("[f]ix()");
    System.out.println("changePump[D]irection()");
    System.out.println("[i]nsertPump()");
    System.out.println("[p]ickPump()");
    System.out.println("[m]ove");
    switch (Input.getChar("dcfxDipm")) {
      case 'd':
        disconnectPipe();
      case 'c':
        connectPipe();
        break;
      case 'f':
        fix();
        break;
      case 'D':
        changePumpDirection();
        break;
      case 'i':
        insertPump();
        break;
      case 'p':
        pickPump();
        break;
      case 'm':
        move();
        break;
    }
  }
}



// Old depricated things
// public void connectPipe() throws Exception { //used
// //check if the Selected pipe is connected at the locatoin of player and
// //check that the selected pump is a neighbor of the location:
// boolean isPipeClose = location.isConnected(grid.getSelectedPipe());
// boolean isPumpClose = location.isSecoundNeighbor(grid.getSelectedActiveElement());
// if(isPipeClose && isPumpClose){
// //connect the end at location of the selcted pipe ot the new selected pump
// location.removeNeighbor(grid.getSelectedPipe());
// grid.getSelectedPump().addNeighbor(grid.getSelectedPipe());
// //move the player to the selected pump
// move(grid.getSelectedPump());//(grid.getSelectedActiveElement is in neighbors)) can also be
// checked here
// }else{
// System.out.println("Pipe is to far away");
// }
// }
