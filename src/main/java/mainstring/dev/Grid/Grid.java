package mainstring.dev.Grid;

import java.util.ArrayList;
import java.util.List;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElement;
import mainstring.dev.Elements.ActiveElements.Cistern.Cistern;
import mainstring.dev.Elements.ActiveElements.Pump.Pump;
import mainstring.dev.Elements.ActiveElements.Spring.Spring;
import mainstring.dev.Elements.Element.Element;
import mainstring.dev.Elements.Pipe.Pipe;
import mainstring.dev.Output.Color;
import mainstring.dev.Players.PlayersCollection.PlayersCollection;
import mainstring.dev.Players.Plumber.Plumber;

/**
 * The Grid class represents the game board where various elements are placed and interacted with.
 * It manages the layout and connections between elements like Cisterns, Springs, Pipes, and
 * potentially Pumps. The grid is responsible for initializing the game setup and assigning players
 * to their starting locations.
 */
public class Grid {
  // Fields
  public Cistern cistern;
  public Spring spring;
  // Active elements include both pipes and potentially other interactable game elements.
  public List<Pipe> pipes = new ArrayList<>();
  public List<Pump> pumps = new ArrayList<>();

  // Tracks the amount of water that has ended up in the desert (unusable water).
  private int waterInDesert = 0;

  // Selection fields for user interactions or game logic.
  private Element selectedElement;
  private ActiveElement selectedActiveElement;
  private Pipe previousSelectedPipe;
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
        %s
        %s

        Selected Element: %s
        Selected elements: %s
        Selected Pipe: %s

        Water in Desert: %s
        """.formatted(Output.toString(pipes), cistern, spring, Output.toString(pumps),
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
  public Grid() {
    try{
      cistern = new Cistern(this); 
      spring = new Spring(this); 
      Pump pump = new Pump(this); pumps.add(pump);
      Pipe pipe1 = new Pipe(this); pipes.add(pipe1);
      Pipe pipe2 = new Pipe(this); pipes.add(pipe2);

      cistern.addNeighbor(pipe1);
      pump.setOutPipe(pipe1);

      spring.addNeighbor(pipe2);
      pump.setInPipe(pipe2);
      

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
  public void setSelectedElement(Element element) {
    selectedElement = element;
  }

  /**
   * Retrieves the currently selected active element within the grid.
   *
   * @return The currently selected elements.
   */
  public ActiveElement getSelectedActiveElement() {
    return selectedActiveElement;
  }

  /**
   * Sets the selected active element based on the user input ID. If the ID matches an active
   * element's ID, sets both the selected element and selected active element to that active
   * element.
   */
  public void setSelectedActiveElement(ActiveElement activeElement) {
    this.selectedElement = activeElement;
    this.selectedActiveElement = activeElement;
  }

  /**
   * Retrieves the currently selected pipe within the grid.
   *
   * @return The currently selected Pipe.
   */
  public Pipe getSelectedPipe() {
    return selectedPipe;
  }

  public Pipe getPreviousSelectedPipe(){
    return previousSelectedPipe;
  }

  /**
   * Sets the currently selected pipe within the grid.
   *
   * @param selectedPipe The Pipe to be set as selected.
   */
  public void setSelectedPipe(Pipe pipe) {
    this.selectedElement = pipe;
    if(selectedPipe != pipe) this.previousSelectedPipe = selectedPipe;
    this.selectedPipe = pipe;
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
    pumps.add(pump);
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

  public void addPlayers(PlayersCollection players) {
    try {
      // pipes.get(0).addPlayer(new Plumber("asdfasdf"));
      for(var player : players.getPlayers()){
        cistern.addPlayer(player);  
        player.setGrid(this);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
