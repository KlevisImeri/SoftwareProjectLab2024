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
  private List<Pipe> pipes = new ArrayList<>();
  private List<ActiveElement> activeElements = new ArrayList<>();
  private PlayersCollection players;

  // Tracks the amount of water that has ended up in the desert (unusable water).
  private int waterInDesert = 0;

  // Selection fields for user interactions or game logic.
  private Element selectedElement;
  private ActiveElement selectedActiveElement;
  private Pipe selectedPipe;
  // private Pump selectedPump; // Uncomment if needed for game logic.

  @Override
  public String toString() {
    return """
        Pipes:
        %s

        Active Elements:
        %s

        Selected Element: %s
        Selected ActiveElement: %s
        Selected Pipe: %s

        Water in Desert: %s
        """.formatted(Output.toString(pipes), Output.toString(activeElements),
        selectedElement != null ? Integer.toString(selectedElement.hashCode()) : "null",
        selectedActiveElement != null ? Integer.toString(selectedActiveElement.hashCode()) : "null",
        selectedPipe != null ? Integer.toString(selectedPipe.hashCode()) : "null", waterInDesert);
  }

  /**
   * Constructs a Grid object and initializes it with a set of players. It sets up the grid based on
   * user input and assigns players to their starting locations.
   *
   * @param players A collection of players that will be participating in the game.
   */
  public Grid(PlayersCollection players) {
    try {
      Output.println("\n[Setting Up the Grid]", Color.LIGHT_BLUE);

      this.players = players;
      for (Player p : players.getPlayers()) {
        p.setGrid(this);
      }

      // get the pipes
      int numberOfPipes = Input.getInt(1, 100);
      for (int i = 0; i < numberOfPipes; i++) {
        setUpPipe();
      }

      // get the ActiveElements
      int numberOfActiveElem = Input.getInt(2, 10);
      for (int i = 0; i < numberOfActiveElem; i++) {
        String[] activeElem = Input.split(Input.getLine());
        switch (activeElem[0]) {
          case "C":
            setUpCistern(activeElem);
            break;
          case "S":
            setUpSpring(activeElem);
            break;
          case "P":
            setUpPump(activeElem);
            break;
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /*---------------------------------------Setups---------------------------------------------*/
  private void setUpPipe() throws Exception {
    Pipe pipe = new Pipe(this);
    pipes.add(pipe);
    String[] pipeS = Input.split(Input.getLine());
    for (String name : Input.split(pipeS[0])) {
      if (name != "") {
        pipe.addPlayer(players.get(name));
      }
    }
    switch (pipeS[1]) {
      case "HEALTHY":
        break; // default
      case "LEAKING":
        pipe.puncture();
        break;
    }
    switch (pipeS[2]) {
      case "EMPTY":
        break; // default
      case "FULL":
        pipe.fill(null);
        break;
    }
  }

  private void setUpCistern(String[] activeElem) throws Exception {
    // C,[1,3...n],[player1...player2],2,3
    this.cistern = new Cistern(this);
    for (String pipeIndx : Input.split(activeElem[1])) {
      if (pipeIndx.isEmpty())
        continue;
      cistern.addNeighbor(pipes.get(Integer.parseInt(pipeIndx)));
    }

    for (String player : Input.split(activeElem[2])) {
      if (player.isEmpty())
        continue;
      cistern.addPlayer(players.get(player));
    }
    for (int j = 0; j < Integer.parseInt(activeElem[3]); j++) {
      cistern.createPump();
    }
    for (int j = 0; j < Integer.parseInt(activeElem[4]); j++) {
      cistern.createPipe();
    }
    activeElements.add(cistern);
  }

  private void setUpSpring(String[] activeElem) throws Exception {
    // S,[1,3...n],[player1...player2]
    this.spring = new Spring(this);
    for (String pipeIndx : Input.split(activeElem[1])) {
      if (pipeIndx.isEmpty())
        continue;
      spring.addNeighbor(pipes.get(Integer.parseInt(pipeIndx)));
    }
    for (String player : Input.split(activeElem[2])) {
      if (player.isEmpty())
        continue;
      spring.addPlayer(players.get(player));
    }
    activeElements.add(spring);
  }

  private void setUpPump(String[] activeElem) throws Exception {
    // The first two pipes (1,3) in this case are the in and out pipe respectevely
    // P,[1,3...n],[player1...player2],HEALTHY,1,3
    Pump pump = new Pump(this);
    activeElements.add(pump);
    for (String pipeIndx : Input.split(activeElem[1])) {
      pump.addNeighbor(pipes.get(Integer.parseInt(pipeIndx)));
    }
    for (String player : Input.split(activeElem[2])) {
      pump.addPlayer(players.get(player));
    }
    switch (activeElem[3]) {
      case "HEALTHY":
        pump.state = Pump.PumpState.HEALTHY;
        break;
      case "BROKEN":
        pump.state = Pump.PumpState.BROKEN;
        break;
    }
    pump.setInPipe(pipes.get(Integer.parseInt(activeElem[4])));
    pump.setOutPipe(pipes.get(Integer.parseInt(activeElem[5])));
  }
  /*------------------------------------------------------------------------------------------*/


  /*------------------------------------get/set Elements--------------------------------------*/
  /**
   * Retrieves the currently selected element within the grid.
   *
   * @return The currently selected Element.
   */
  public Element getSelectedElement() {
    return selectedElement;
  }

  /**
   * Sets the currently selected element within the grid.
   *
   * @param selectedElement The Element to be set as selected.
   */
  public void setSelectedElement() {
    int ID = Input.getInt(0, Element.FreeID);
    for (Pipe p : pipes) {
      if (p.getID() == ID) {
        this.selectedElement = p;
      }
    }
    for (ActiveElement a : activeElements) {
      if (a.getID() == ID) {
        this.selectedElement = a;
      }
    }
  }

  /**
   * Retrieves the currently selected active element within the grid.
   *
   * @return The currently selected ActiveElement.
   */
  public ActiveElement getSelectedActiveElement() {
    return selectedActiveElement;
  }


  public void setSelectedActiveElement() {
    int ID = Input.getInt(0, Element.FreeID);
    for (ActiveElement a : activeElements) {
      if (a.getID() == ID) {
        this.selectedElement = a;
        this.selectedActiveElement = a;
      }
    }
  }

  /**
   * Retrieves the currently selected pipe within the grid.
   *
   * @return The currently selected Pipe.
   */
  public Pipe getSelectedPipe() {
    return selectedPipe;
  }

  /**
   * Sets the currently selected pipe within the grid.
   *
   * @param selectedPipe The Pipe to be set as selected.
   */
  public void setSelectedPipe() {
    int ID = Input.getInt(0, Element.FreeID);
    for (Pipe p : pipes) {
      if (p.getID() == ID) {
        this.selectedElement = p;
        this.selectedPipe = p;
      }
    }
  }
  /*------------------------------------get/set Elements--------------------------------------*/

  /*---------------------------------------Flow---------------------------------------------*/
  /**
   * Calculates and processes the flow through all active elements in the grid.
   */
  public void caculateFlow() {
    Output.println("\n[Flowing]", Color.LIGHT_BLUE);
    spring.Flow(null);
    System.out.println();
  }

  /*---------------------------------------Flow---------------------------------------------*/

  /**
   * Adds a Pump to the list of active elements within the grid.
   *
   * @param pump The Pump to be added to the grid.
   */
  public void addPump(Pump pump) {
    activeElements.add(pump);
  }

  public void addPipe(Pipe pipe) {
    pipes.add(pipe);
  }


  /**
   * Increases the water count in the desert by one. This simulates water loss to the desert.
   */
  public void addWaterToDesert() {
    this.waterInDesert++;
  }

  /**
   * Retrieves the amount of water currently in the desert.
   *
   * @return The amount of water in the desert.
   */
  public int getWaterAtDesert() {
    return this.waterInDesert;
  }

  /**
   * Retrieves the amount of water currently stored in the Cistern.
   *
   * @return The amount of water in the Cistern.
   */
  public int getWaterAtCistern() {
    return this.cistern.getWaterAmount();
  }
}
