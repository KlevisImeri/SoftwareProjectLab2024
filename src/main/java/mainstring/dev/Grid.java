package mainstring.dev;

import java.util.ArrayList;
import java.util.List;
import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Output.Color;
import mainstring.dev.Players.*;
import mainstring.dev.Elements.*;

/**
 * The Grid class represents the game board where various elements are placed and interacted with.
 * It manages the layout and connections between elements like Cisterns, Springs, Pipes, and
 * potentially Pumps. The grid is responsible for initializing the game setup and assigning players
 * to their starting locations.
 */
public class Grid {
  // Fields
  private Cistern cistern;
  private Spring spring;
  // Active elements include both pipes and potentially other interactable game elements.
  private List<ActiveElement> activeElements = new ArrayList<>();

  // Tracks the amount of water that has ended up in the desert (unusable water).
  private int waterInDesert = 0;

  // Selection fields for user interactions or game logic.
  private Element selectedElement;
  private ActiveElement selectedActiveElement;
  private Pipe selectedPipe;
  // private Pump selectedPump; // Uncomment if needed for game logic.

  /**
   * Constructs a Grid object and initializes it with a set of players. It sets up the grid based on
   * user input and assigns players to their starting locations.
   *
   * @param players A collection of players that will be participating in the game.
   */
  public Grid(PlayersCollection players) {
    for (Player p : players.getPlayers()) {
      p.setGrid(this);
    }
    Output.println("|-----------------------Setting Up the Grid------------------------|",
        Color.LIGHT_BLUE);
    System.out.println("Grid(players)");

    System.out.println("Select the setup of the grid? [int]");
    switch (Input.getInt(0, 11)) {
      case 0:
        setup0(players); // S-----C*
      case 1:
        setup1(players); // --*--P
        break;
      case 2:
        setup2(players); // --*--C
        break;
      case 3:
        setup3(players); // --*--S
        break;
      case 4:
        setup4(players); // ----P*
        break;
      case 5:
        setup5(players); // ----C*
        break;
      case 6:
        setup6(players); // ----S*
        break;
      case 7:
        setup7(players); // --1--P*--2--
        break;
      case 8:
        setup8(players); // C*
        break;
      case 9:
        setup9(players); // S--*--C
        break;
      case 10:
        setup10(players); // S--1--P--2--C
        break;
      case 11:
        setup11(players); // desert 13l C 100l
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
  /*---------------------------------------Setups---------------------------------------------*/

  /**
   * A setup method example where a Cistern and a Spring are connected by a Pipe. This method places
   * players at the Cistern and sets the Spring as the selected active element.
   *
   * @param players A collection of players to be placed at the Cistern.
   */
  private void setup0(PlayersCollection players) {
    cistern = new Cistern(this);
    spring = new Spring(this);
    Pipe pipe = new Pipe(this);
    pipe.addNeighbor(cistern);
    pipe.addNeighbor(spring);
    for (Player p : players.getPlayers()) {
      cistern.addPlayer(p);
    }
    setSelectedActiveElement(spring);
    // S-----C*
  }

  /**
   * Setup method connecting a single Pipe to a Pump. Players are placed at the Pipe.
   * 
   * Diagram representation: --*--P
   * 
   * @param players A collection of players to be placed at the Pipe.
   */
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

  /**
   * Setup method connecting a single Pipe to a Cistern. Players are placed at the Pipe.
   * 
   * Diagram representation: --*--C
   * 
   * @param players A collection of players to be placed at the Pipe.
   */
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

  /**
   * Setup method connecting a single Pipe to a Spring. Players are placed at the Pipe.
   * 
   * Diagram representation: --*--S
   * 
   * @param players A collection of players to be placed at the Pipe.
   */
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

  /**
   * Setup method placing a Pump at the end of a Pipe. Players are placed at the Pump.
   * 
   * Diagram representation: ----P*
   * 
   * @param players A collection of players to be placed at the Pump.
   */
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

  /**
   * Setup method placing a Cistern at the end of a Pipe. Players are placed at the Cistern.
   * 
   * Diagram representation: ----C*
   * 
   * @param players A collection of players to be placed at the Cistern.
   */
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

  /**
   * Setup method placing a Spring at the end of a Pipe. Players are placed at the Spring.
   * 
   * Diagram representation: ----S*
   * 
   * @param players A collection of players to be placed at the Spring.
   */
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

  /**
   * Setup involving a Pump connected between two Pipes. Players are placed at the Pump.
   * 
   * Diagram representation: --1--P*--2--
   * 
   * @param players A collection of players to be placed at the Pump.
   */
  private void setup7(PlayersCollection players) {
    Pipe pipe1 = new Pipe(this);
    Pipe pipe2 = new Pipe(this);
    Pump pump = new Pump(this);
    pump.setInPipe(pipe1);
    pump.setOutPipe(pipe2);
    for (Player p : players.getPlayers()) {
      pump.addPlayer(p);
    }
    setSelectedActiveElement(pump);
    // --1--P*--2--
  }

  /**
   * Setup creating a standalone Cistern that also creates a Pump and a Pipe. Players are placed at
   * the Cistern.
   * 
   * Diagram representation: C*
   * 
   * @param players A collection of players to be placed at the Cistern.
   */
  private void setup8(PlayersCollection players) {
    cistern = new Cistern(this);
    cistern.createPump();
    cistern.createPipe();
    for (Player p : players.getPlayers()) {
      cistern.addPlayer(p);
    }
    activeElements.add(cistern);
    setSelectedActiveElement(cistern);
    // C*
  }

  /**
   * Setup method creating a simple pipeline from a Spring to a Cistern via a Pipe. This setup is
   * designed to demonstrate multiple players in a single pipe for testing purposes.
   * 
   * Diagram representation: S--*--C
   * 
   * @param players A collection of players to be placed in the pipe for demonstration.
   */
  private void setup9(PlayersCollection players) {
    cistern = new Cistern(this);
    spring = new Spring(this);
    Pipe pipe = new Pipe(this);
    pipe.addNeighbor(cistern);
    pipe.addNeighbor(spring);
    for (Player p : players.getPlayers()) {
      // here we all more players in the pipe for demostartion
      // ths is just for testing
      pipe.addPlayer(p);
    }
    setSelectedActiveElement(cistern);
    // S--*--C
  }

  /**
   * Setup method creating a more complex system with a Spring, a Pump, and a Cistern, connected by
   * two pipes. The first pipe is punctured, and the second pipe is filled with water, demonstrating
   * a dynamic water flow.
   * 
   * Diagram representation: S--1--P--2--C*
   * 
   * @param players A collection of players to be placed at the Cistern.
   */
  private void setup10(PlayersCollection players) {
    cistern = new Cistern(this);
    spring = new Spring(this);
    Pump pump = new Pump(this);
    activeElements.add(cistern);
    activeElements.add(spring);
    activeElements.add(pump);
    Pipe pipe1 = new Pipe(this);
    Pipe pipe2 = new Pipe(this);
    pump.setInPipe(pipe1);
    pump.setOutPipe(pipe2);
    pipe1.addNeighbor(spring);
    pipe2.addNeighbor(cistern);
    pipe2.fill();
    pipe1.puncture();
    for (Player p : players.getPlayers()) {
      cistern.addPlayer(p);
    }
    setSelectedActiveElement(spring);
    // S--1--P--2--C*
  }

  /**
   * Setup method initializing the grid with a Cistern and setting an initial amount of water in the
   * desert. This setup demonstrates managing water resources in different parts of the game
   * environment.
   * 
   * @param players A collection of players, not directly used in this setup.
   */
  private void setup11(PlayersCollection players) {
    cistern = new Cistern(this);
    this.waterInDesert = 13;
    cistern.setWaterAmount(100);
  }

  /**
   * Special setup method for players, providing Plumber players with a Pipe and a Pump at the
   * beginning of the game. This allows for immediate interaction with the game elements.
   * 
   * @param players A collection of players to be equipped with Pipes and Pumps if they are
   *        Plumbers.
   */
  private void setupP1(PlayersCollection players) {
    for (Player p : players.getPlayers()) {
      if (p instanceof Plumber) {
        ((Plumber) p).carryPipe = new Pipe(this);
        ((Plumber) p).carryPump = new Pump(this);
      }
    }
  }

  /*---------------------------------------Setups---------------------------------------------*/
  /**
   * Retrieves the currently selected element within the grid.
   *
   * @return The currently selected Element.
   */
  public Element getSelectedElement() {
    System.out.println("getSelectedElement()");
    return selectedElement;
  }

  /**
   * Sets the currently selected element within the grid.
   *
   * @param selectedElement The Element to be set as selected.
   */
  public void setSelectedElement(Element selectedElement) {
    System.out.println("setSelectedElement()");
    this.selectedElement = selectedElement;
  }

  /**
   * Retrieves the currently selected active element within the grid.
   *
   * @return The currently selected ActiveElement.
   */
  public ActiveElement getSelectedActiveElement() {
    System.out.println("getSelectedActiveElement()");
    return selectedActiveElement;
  }

  /**
   * Sets the currently selected active element within the grid.
   *
   * @param selectedActiveElement The ActiveElement to be set as selected.
   */
  public void setSelectedActiveElement(ActiveElement selectedActiveElement) {
    System.out.println("setSelectedActiveElement()");
    this.selectedElement = selectedActiveElement;
    this.selectedActiveElement = selectedActiveElement;
  }

  /**
   * Retrieves the currently selected pipe within the grid.
   *
   * @return The currently selected Pipe.
   */
  public Pipe getSelectedPipe() {
    System.out.println("getSelectedPipe()");
    return selectedPipe;
  }

  /**
   * Sets the currently selected pipe within the grid.
   *
   * @param selectedPipe The Pipe to be set as selected.
   */
  public void setSelectedPipe(Pipe selectedPipe) {
    System.out.println("setSelectedPipe()");
    this.selectedElement = selectedPipe;
    this.selectedPipe = selectedPipe;
  }

  /**
   * Calculates and processes the flow through all active elements in the grid.
   */
  public void caculateFlow() {
    Output.println(
        "|-------------------------------5.2.14.1 Calculation of general flow----------------------------|",
        Color.LIGHT_BLUE);
    System.out.println("cacualteFlow()");
    for (ActiveElement e : activeElements) {
      e.Flow();
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  /**
   * Adds a Pump to the list of active elements within the grid.
   *
   * @param pump The Pump to be added to the grid.
   */
  public void addPump(Pump pump) {
    System.out.println("addPump(pump)");
    activeElements.add(pump);
  }

  /**
   * Increases the water count in the desert by one. This simulates water loss to the desert.
   */
  public void addWaterToDesert() {
    System.out.println("addWaterToDesert()");
    this.waterInDesert++;
  }

  /**
   * Retrieves the amount of water currently in the desert.
   *
   * @return The amount of water in the desert.
   */
  public int getWaterAtDesert() {
    System.out.println("getWaterAtDesert()");
    return this.waterInDesert;
  }

  /**
   * Retrieves the amount of water currently stored in the Cistern.
   *
   * @return The amount of water in the Cistern.
   */
  public int getWaterAtCistern() {
    System.out.println("getWaterAtCistern()");
    return this.cistern.getWaterAmount();
  }
}
