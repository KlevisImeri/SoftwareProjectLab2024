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
        """.formatted(
            Output.toString(pipes),
            Output.toString(activeElements),
            selectedElement != null ? Integer.toString(selectedElement.hashCode()) : "null",
            selectedActiveElement != null ? Integer.toString(selectedActiveElement.hashCode()) : "null",
            selectedPipe != null ? Integer.toString(selectedPipe.hashCode()) : "null",
            waterInDesert
        );
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

      for (Player p : players.getPlayers()) {
        p.setGrid(this);
      }

      // get the pipes
      int numberOfPipes = Input.getInt(1, 100);
      for (int i = 0; i < numberOfPipes; i++) {
        Pipe pipe = new Pipe(this);
        String[] names = Input.split(Input.getLine());
        for (String name : names) {
          if (name != "") {
            pipe.addPlayer(players.get(name));
          }
        }
        pipes.add(pipe);
      }

      // get the ActiveElements
      int numberOfActiveElem = Input.getInt(2, 10);
      for (int i = 0; i < numberOfActiveElem; i++) {
        String[] activeElem = Input.split(Input.getLine());
        switch (activeElem[0]) {
          case "C":
            // C,[1,3...n],[player1...player2],2,3
            this.cistern = new Cistern(this);
            for (String pipeIndx : Input.split(activeElem[1])) {
              cistern.addNeighbor(pipes.get(Integer.parseInt(pipeIndx)));
            }

            for (String player : Input.split(activeElem[2])) {
              System.out.println(player);
              cistern.addPlayer(players.get(player));
            }
            for (int j = 0; j < Integer.parseInt(activeElem[3]); j++) {
              cistern.createPump();
            }
            for (int j = 0; j < Integer.parseInt(activeElem[4]); j++) {
              cistern.createPipe();
            }
            activeElements.add(cistern);
            break;
          case "S":
            // S,[1,3...n],[player1...player2]
            this.spring = new Spring(this);
            for (String pipeIndx : Input.split(activeElem[1])) {
              spring.addNeighbor(pipes.get(Integer.parseInt(pipeIndx)));
            }
            for (String player : Input.split(activeElem[2])) {
              spring.addPlayer(players.get(player));
            }
            activeElements.add(spring);
            break;
          case "P":
            // The first two pipes (1,3) in this case are the in and out pipe respectevely
            // P,[1,3...n],[player1...player2],HEALTHY
            Pump pump = new Pump(this);
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
            activeElements.add(pump);
            break;
        }

      }

      Output.println("[Grid is Setup]", Color.LIGHT_GREEN);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /*---------------------------------------Setups---------------------------------------------*/
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
  public void setSelectedElement(Element selectedElement) {
    this.selectedElement = selectedElement;
  }

  /**
   * Retrieves the currently selected active element within the grid.
   *
   * @return The currently selected ActiveElement.
   */
  public ActiveElement getSelectedActiveElement() {
    return selectedActiveElement;
  }

  /**
   * Sets the currently selected active element within the grid.
   *
   * @param selectedActiveElement The ActiveElement to be set as selected.
   */
  public void setSelectedActiveElement(ActiveElement selectedActiveElement) {
    this.selectedElement = selectedActiveElement;
    this.selectedActiveElement = selectedActiveElement;
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
  public void setSelectedPipe(Pipe selectedPipe) {
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
