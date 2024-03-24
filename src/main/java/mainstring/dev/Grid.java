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
    Output.println("|-----------------------Setting Up the Grid------------------------|",
        Color.LIGHT_BLUE);
    System.out.println("Grid(players)");
    
    System.out.println("Select the setup of the grid? [int]");
    switch (Input.getInt(0, 9)) {
      case 0:
        setup0(players);  // S-----C*
      case 1: 
        setup1(players);  // --*--P
        break;
      case 2:
        setup2(players);  // --*--C
        break;
      case 3:
        setup3(players);  // --*--S
        break;
      case 4:
        setup4(players);  // ----P*
        break;
      case 5:
        setup5(players);  // ----C*
        break;
      case 6:
        setup6(players);  // ----S*
        break;
      case 7:
        setup7(players);  // --1--P*--2--
        break;
      case 8:
        setup8(players);  // C*
        break;
      case 9:
        setup9(players);  // S--*--C 
        break;
    }

    System.out.println("Set up players? [0-1]");
    switch (Input.getInt(0, 1)) {
      case 0:
        break;
      case 1:
        setupP1(players);
        break;
    }
    Output.println("|---------------------------------------------------------------------|",
        Color.LIGHT_BLUE);

  }

  private void setup0(PlayersCollection players) {
    cistern = new Cistern(this);
    spring = new Spring(this);
    Pipe pipe = new Pipe(this);
    pipe.addNeighbor(cistern);
    pipe.addNeighbor(spring);
    for( Player p : players.getPlayers()){
      cistern.addPlayer(p);
    }
    //S-----C*
  }

  private void setup1(PlayersCollection players) {
    Pipe pipe = new Pipe(this);
    Pump pump = new Pump(this);
    pipe.addNeighbor(pump);
    for (Player p : players.getPlayers()) {
      pipe.addPlayer(p);
    }
    setSelectedActiveElement(pump);
    /*
     * --*--P 
     */
  }

  private void setup2(PlayersCollection players) {
    Pipe pipe = new Pipe(this);
    cistern = new Cistern(this);
    pipe.addNeighbor(cistern);
    for (Player p : players.getPlayers()) {
      pipe.addPlayer(p);
    }
    setSelectedActiveElement(cistern);
    /*
     * --*--C 
     */
  }

  private void setup3(PlayersCollection players) {
    Pipe pipe = new Pipe(this);
    spring = new Spring(this);
    pipe.addNeighbor(spring);
    for (Player p : players.getPlayers()) {
      pipe.addPlayer(p);
    }
    setSelectedActiveElement(spring);
    /*
     * --*--S 
     */
  }


  private void setup4(PlayersCollection players) {
    Pipe pipe = new Pipe(this);
    Pump pump = new Pump(this);
    pump.addNeighbor(pipe);
    for (Player p : players.getPlayers()) {
      pump.addPlayer(p);
    }
    setSelectedPipe(pipe);
    /*
     * ----P* 
     */
  }

  private void setup5(PlayersCollection players) {
    Pipe pipe = new Pipe(this);
    cistern = new Cistern(this);
    cistern.addNeighbor(pipe);
    for (Player p : players.getPlayers()) {
      cistern.addPlayer(p);
    }
    setSelectedPipe(pipe);
    /*
     * ----C* 
     */
  }

  private void setup6(PlayersCollection players) {
    Pipe pipe = new Pipe(this);
    spring = new Spring(this);
    spring.addNeighbor(pipe);
    for (Player p : players.getPlayers()) {
      spring.addPlayer(p);
    }
    setSelectedPipe(pipe);
    /*
     * ----S*
     */
  }

  private void setup7(PlayersCollection players) {
    Pipe pipe1 = new Pipe(this);
    Pipe pipe2 = new Pipe(this);
    Pump pump = new Pump(this);
    pump.setInPipe(pipe1);
    pump.setOutPipe(pipe2);
    for (Player p : players.getPlayers()) {
      pump.addPlayer(p);
    }
    // --1--P*--2--
  }

  private void setup8(PlayersCollection players) {
    cistern = new Cistern(this);
    cistern.createPump();
    cistern.createPipe();
    for (Player p : players.getPlayers()) {
      cistern.addPlayer(p);
    }
    activeElements.add(cistern);
    // C*
  }

  private void setup9(PlayersCollection players) {
    cistern = new Cistern(this);
    spring = new Spring(this);
    Pipe pipe = new Pipe(this);
    pipe.addNeighbor(cistern);
    pipe.addNeighbor(spring);
    for( Player p : players.getPlayers()){
      //here we all more players in the pipe for demostartion
      //ths is just for testing
      pipe.addPlayer(p); 
    }
    //S--*--C
  }

  private void setupP1(PlayersCollection players) {
    for (Player p : players.getPlayers()) {
      if (p instanceof Plumber) {
        ((Plumber) p).carryPipe = new Pipe(this);
        ((Plumber) p).carryPump = new Pump(this);
      }
    }
  }

  public Element getSelectedElement() {
    System.out.println("getSelectedElement()");
    return selectedElement;
  }

  public void setSelectedElement(Element selectedElement) {
    System.out.println("setSelectedElement()");
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
    System.out.println("getSelectedPipe()");
    return selectedPipe;
  }

  public void setSelectedPipe(Pipe selectedPipe) {
    this.selectedElement = selectedPipe;
    this.selectedPipe = selectedPipe;
  }

  public void caculateFlow(){
    System.out.println("cacualteFlow()");
    for (ActiveElement e : activeElements) {
      e.Flow();      
    }
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
    System.out.println("addPump(pump)");
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
