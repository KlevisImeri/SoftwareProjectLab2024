package mainstring.dev.Elements.ActiveElements;

import java.util.Timer;
import java.util.ArrayList;
import java.util.List;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;
import mainstring.dev.Elements.*;
import mainstring.dev.Grid;

/**
 * Represents a cistern in a water flow simulation, capable of storing water and dynamically
 * creating pumps and pipes. It serves as a central element in managing water resources within the
 * grid it is part of.
 */
public class Cistern extends ActiveElement {
  protected List<Pump> newPumps = new ArrayList<>(); // List of pumps created and managed by this
                                                     // cistern
  protected List<Pipe> newPipes = new ArrayList<>(); // List of pipes created and managed by this
                                                     // cistern
  protected int waterAmount = 0;// The amount of water currently stored in this cistern
  protected Timer timerPipe = new Timer(); // Timer for creating pipes
  protected Timer timerPump = new Timer(); // Timer for creating pumps

  @Override
  public String toString() {
    return "C,%s,%s,%s,%s".formatted(super.toString(), Output.toStringID(newPipes),
        Output.toStringID(newPumps), waterAmount);
  }

  /**
   * Instantly creates a new pipe and adds it to the list of managed pipes.
   */
  private void schedulePipeCreation() {
    createPipe();
  }

  /**
   * Instantly creates a new pump and adds it to the list of managed pumps.
   */
  private void schedulePumpCreation() {
    createPump();
  }

  /**
   * Adds a new Pump object to the list of new pumps.
   */
  public void createPump() {
    newPumps.add(new Pump(grid));
  }

  /**
   * Adds a new Pipe object to the list of new pipes.
   */
  public void createPipe() {
    newPipes.add(new Pipe(grid));
  }

  /**
   * Adds water to the cistern, ensuring the water amount does not become negative.
   */
  private void addWater() {
    System.out.println("addWater()");
  }

  /**
   * Removes water from the cistern, ensuring the water amount does not become negative.
   */
  private void removewater() {
    System.out.println("removeWater()");
  }

  /**
   * Constructs a new Cistern within the specified grid. It also schedules the creation of initial
   * pipes and pumps.
   * 
   * @param grid The grid in which this cistern is located.
   */
  public Cistern(Grid grid) {
    super(grid);
    // schedulePipeCreation();
    // schedulePumpCreation();
  }

  /**
   * Retrieves and returns the first new pump from the list of new pumps if available, otherwise
   * returns null. It prompts the user to indicate if new pumps are available.
   * 
   * @return The first new pump if available, or null if no new pumps are available.
   */
  public Pump getPump() {
    System.out.println("getPump()");
    System.out.println("Does the cistern have new pumps?  [y]es/[n]o");
    switch (Input.getChar("yn")) {
      case 'y':
        return newPumps.get(0);
      case 'n':
        Output.println("No More Pumps!", Color.LIGHT_RED);
    }
    return null;
  }

  /**
   * Retrieves and returns the first new pipe from the list of new pipes if available. Prompts the
   * user to indicate if new pipes are available. If no new pipes are available, it informs the user
   * accordingly.
   * 
   * @return The first new pipe if available, otherwise null.
   */
  public Pipe getPipe() {
    System.out.println("getPipe()");
    System.out.println("Does the cistern have new pipes?  [y]es/[n]o");
    switch (Input.getChar("yn")) {
      case 'y':
        return newPipes.get(0);
      case 'n':
        Output.println("No More Pipes!", Color.LIGHT_RED);
        return null;
    }
    return null;
  }

  /**
   * Manages the flow of water in response to the cistern's current state and its connections. It
   * empties any full pipes connected to it, adding their water to the cistern, and then attempts to
   * distribute this water to new pipes. This method exemplifies the cistern's role in the dynamic
   * water distribution system.
   */
  @Override
  public void Flow() {
    Output.println(
        "|----------------5.2.14.2 Calculation of the flow at a cistern-----------------|",
        Color.LIGHT_BLUE);
    System.out.println("Flow()");
    for (Element element : neighbors) {
      if (((Pipe) element).isFull()) {
        ((Pipe) element).empty();
        addWater();
      }
    }
    for (int i = 0; i < newPipes.size(); i++) {
      removewater();
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  /**
   * Returns the current amount of water stored in the cistern.
   * 
   * @return The current water amount in the cistern.
   */
  public int getWaterAmount() {
    System.out.println("getWaterAmount()");
    return this.waterAmount;
  }

  /**
   * Sets the cistern's water amount to a specified value. This method currently sets the water
   * amount to 20 regardless of the input value.
   * 
   * @param waterAmount The new water amount to set for the cistern.
   * @return The newly set water amount.
   */
  public int setWaterAmount(int waterAmount) {
    System.out.println("setWaterAmount()");
    this.waterAmount = 20; // Note: This sets the water amount to 20, ignoring the input parameter.
    return this.waterAmount;
  }

  /**
   * Provides a type identifier for the Cistern.
   * 
   * @return A string "cistern" as the type of this element.
   */
  @Override
  public String type() {
    return "cistern";
  }
}
