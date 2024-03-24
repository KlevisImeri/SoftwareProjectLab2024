package mainstring.dev;

import java.util.ArrayList;
import java.util.List;
import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Output.Color;
import mainstring.dev.Players.*;
import mainstring.dev.Elements.*;

public class Grid {
  // Fieldsp
  private Cistern cistern;
  private Spring spring;
  private List<ActiveElement> activeElements = new ArrayList<>(); // here the pipes are also stored

  private int waterInDesert = 0;


  private Element selectedElement;
  private ActiveElement selectedActiveElement;
  private Pipe selectedPipe;
  // private Pump selectedPump;

  public Grid(PlayersCollection players) {
    for (Player p : players.getPlayers()) {
      p.setGrid(this);
    }
    Output.println("|-----------------------Setting Up the Grid------------------------|",Color.LIGHT_BLUE);
    System.out.println("Grid(players)");
    System.out.println("Select the setup of the grid? [char]");
    System.out.println("[m]ove");
    System.out.println("changePump[D]irection()");
    System.out.println("[d]onnectPipe()");
    System.out.println("[c]onnectPipe()");
    System.out.println("[f]ix");
    System.out.println("[i]nsertPump()");
    System.out.println("[p]ickPump(), pickPipe()");

    switch (Input.getChar("mDdcfip")) {
      case 'm':
        System.out.println("Select which move setup? [1-6]");
        switch (Input.getInt(1, 6)) {
          case 1:
            System.out.println("5.2.5.1/2.1 The plumber/saboteur moves from pipe to pump");
            moveToPump(players);
            break;
          case 2:
            System.out.println("5.2.5.1/2.2 The plumber/saboteur moves from pipe to spring");
            moveToSpring(players);
            break;
          case 3:
            System.out.println("5.2.5.1/2.3 The plumber/saboteur moves from pipe to cistern");
            moveToCistern(players);
            break;
          case 4:
            System.out.println("5.2.9.1/2.4 The plumber/saboteur moves from pump to pipe");
            moveFromPump(players);
            break;
          case 5:
            System.out.println("5.2.9.1/2.5 The plumber/saboteur moves from spring to pipe");
            moveFromSpring(players);
            break;
          case 6:
            System.out.println("5.2.9.1/2.6 The plumber/saboteur moves from cistern to pipe");
            moveFromCistern(players);
            break;
        }
        break;
      case 'D':
        changePumpDirection(players);
        break;
      case 'p':
        pickPumpPipe(players);
        break;
    }
    Output.println("|---------------------------------------------------------------------|", Color.LIGHT_BLUE);
  }

  private void moveToPump(PlayersCollection players) {
    Pipe pipe = new Pipe(this);
    Pump pump = new Pump(this);
    pipe.addNeighbor(pump);
    for (Player p : players.getPlayers()) {
      pipe.addPlayer(p);
    }
    setSelectedActiveElement(pump);
    /*
     * --*--P -> ----P*
     */
  }

  private void moveToSpring(PlayersCollection players) {
    Pipe pipe = new Pipe(this);
    spring = new Spring(this);
    pipe.addNeighbor(spring);
    for (Player p : players.getPlayers()) {
      pipe.addPlayer(p);
    }
    setSelectedActiveElement(spring);
    /*
     * --*--S -> ----S*
     */
  }

  private void moveToCistern(PlayersCollection players) {
    Pipe pipe = new Pipe(this);
    cistern = new Cistern(this);
    pipe.addNeighbor(cistern);
    for (Player p : players.getPlayers()) {
      pipe.addPlayer(p);
    }
    setSelectedActiveElement(cistern);
    /*
     * --*--C -> ----C*
     */
  }

  private void moveFromPump(PlayersCollection players) {
    Pipe pipe = new Pipe(this);
    Pump pump = new Pump(this);
    pump.addNeighbor(pipe);
    for (Player p : players.getPlayers()) {
      pump.addPlayer(p);
    }
    setSelectedPipe(pipe);
    /*
     * ----P* -> --*--P
     */
  }

  private void moveFromCistern(PlayersCollection players) {
    Pipe pipe = new Pipe(this);
    cistern = new Cistern(this);
    cistern.addNeighbor(pipe);
    for (Player p : players.getPlayers()) {
      cistern.addPlayer(p);
    }
    setSelectedPipe(pipe);
    /*
     * ----C* -> --*--C
     */
  }

  private void moveFromSpring(PlayersCollection players) {
    Pipe pipe = new Pipe(this);
    spring = new Spring(this);
    spring.addNeighbor(pipe);
    for (Player p : players.getPlayers()) {
      spring.addPlayer(p);
    }
    setSelectedPipe(pipe);
    /*
     * ----S* -> --*--S
     */
  }

  private void changePumpDirection(PlayersCollection players) {
    Pipe pipe1 = new Pipe(this);
    Pipe pipe2 = new Pipe(this);
    Pump pump = new Pump(this);
    pump.setInPipe(pipe1);
    pump.setOutPipe(pipe2);
    for (Player p : players.getPlayers()) {
      pump.addPlayer(p);
    }
    // --1--P--2--
  }

  private void pickPumpPipe(PlayersCollection players) {
    cistern = new Cistern(this);
    cistern.createPump();
    cistern.createPipe();
    for (Player p : players.getPlayers()) {
      cistern.addPlayer(p);
    }
    activeElements.add(cistern);
  }

  public Element getSelectedElement() {
    System.out.println("getSelectedElement()");
    return selectedElement;
  }

  public void setSelectedElement(Element selectedElement) {
    this.selectedElement = selectedElement;
  }

  public ActiveElement getSelectedActiveElement() {
    return selectedActiveElement;
  }

  public void setSelectedActiveElement(ActiveElement selectedActiveElement) {
    this.selectedElement = selectedActiveElement;
    this.selectedActiveElement = selectedActiveElement;
  }

  public Pipe getSelectedPipe() {
    return selectedPipe;
  }

  public void setSelectedPipe(Pipe selectedPipe) {
    this.selectedElement = selectedPipe;
    this.selectedPipe = selectedPipe;
  }

  // public Pump getSelectedPump() {
  // return selectedPump;
  // }

  // public void setSelectedPump(Pump selectedPump) {
  // this.selectedElement = selectedPump;
  // this.selectedActiveElement = selectedPump;
  // this.selectedPump = selectedPump;
  // }

  public void addPump(Pump pump) {
    activeElements.add(pump);
  }


  public void addWaterToDesert() {
    this.waterInDesert++;
  }

  public int getWaterAtDesert() {
    return this.waterInDesert;
  }

  public int getWaterAtCistner() {
    return this.cistern.getWaterAmount();
  }
}

