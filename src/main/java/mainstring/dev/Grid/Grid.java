package mainstring.dev.Grid;

import java.util.ArrayList;
import java.util.List;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Elements.*;
import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Output.Color;
import mainstring.dev.Players.Player.Player;
import mainstring.dev.Players.PlayersCollection.PlayersCollection;

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

  /**
   * Returns a string representation of the grid, including information about pipes, active
   * elements, selected elements, selected active elements, selected pipe, and water in the desert.
   * 
   * @return A formatted string representing the grid.
   */
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
    try{
      cistern = new Cistern(this); activeElements.add(spring);
      spring = new Spring(this); activeElements.add(spring);
      Pump pump = new Pump(this); activeElements.add(pump);
      Pipe pipe1 = new Pipe(this); pipes.add(pipe1);
      Pipe pipe2 = new Pipe(this); pipes.add(pipe2);

      cistern.addNeighbor(pipe1);
      pump.addNeighbor(pipe1);

      spring.addNeighbor(pipe1);
      pump.addNeighbor(pipe2);

      
      cistern.addPlayers(players.getPlayers());
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


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

  /**
   * Sets the selected active element based on the user input ID. If the ID matches an active
   * element's ID, sets both the selected element and selected active element to that active
   * element.
   */
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

  /**
   * Adds a pipe to the list of pipes.
   * 
   * @param pipe The pipe to be added.
   */
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
