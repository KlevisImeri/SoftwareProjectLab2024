package mainstring.dev.Elements.ActiveElements.Cistern;

import java.util.Timer;
import java.util.TimerTask;
import mainstring.dev.Output;
import mainstring.dev.Elements.*;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElement;
import mainstring.dev.Elements.ActiveElements.Pump.Pump;
import mainstring.dev.Elements.Pipe.Pipe;
import mainstring.dev.Grid.Grid;
import java.util.Random;
import java.util.Stack;

/**
 * Represents a cistern in a water flow simulation, capable of storing water and dynamically
 * creating pumps and pipes. It serves as a central element in managing water resources within the
 * grid it is part of.
 */
public class Cistern extends ActiveElement {
  Stack<Pump> newPumps = new Stack<>(); // List of pumps created and managed by this
                                        // cistern
  Stack<Pipe> newPipes = new Stack<>(); // List of pipes created and managed by this
                                        // cistern
  protected int waterAmount = 0;// The amount of water currently stored in this cistern
  private Timer timerPipe = new Timer(); // Timer for creating pipes
  private Timer timerPump = new Timer(); // Timer for creating pumps
  private Random random = new Random();


  @Override
  public String toString() {
    return "C,%s,%s,%s,%s".formatted(super.toString(), Output.toStringID(newPumps),
        Output.toStringID(newPipes), waterAmount);
  }

  /**
   * Adds a new Pump object to the list of new pumps.
   */
  public void createPump() {
    newPumps.push(new Pump(grid));
    updateViews();
    schedulePumpCreation();
  }

  /**
   * Adds a new Pipe object to the list of new pipes.
   */
  public void createPipe() {
    newPipes.push(new Pipe(grid));
    updateViews();
    schedulePipeCreation();
  }

  /**
   * Adds water to the cistern, ensuring the water amount does not become negative.
   */
  private void addWater() {
    waterAmount++;
  }

  /**
   * Removes water from the cistern, ensuring the water amount does not become negative.
   */
  private void removewater() {
    if (waterAmount == 0)
      return;
    waterAmount--;
  }

  /**
   * Constructs a new Cistern within the specified grid. It also schedules the creation of initial
   * pipes and pumps.
   * 
   * @param grid The grid in which this cistern is located.
   */
  public Cistern(Grid grid) {
    super(grid);
    schedulePipeCreation();
    schedulePumpCreation();
  }

  /**
   * Schedules the creation of a new pipe at a random interval.
   */
  private void schedulePipeCreation() {
    int interval = random.nextInt(10000) + 1000; // Random interval between 1 and 60 seconds
    timerPipe.schedule(new TimerTask() {
      @Override
      public void run() {
        createPipe();
      }
    }, interval);
  }

  /**
   * Schedules the creation of a new pump at a random interval.
   */
  private void schedulePumpCreation() {
    int interval = random.nextInt(10000) + 1000; // Random interval between 1 and 60 seconds
    timerPump.schedule(new TimerTask() {
      @Override
      public void run() {
        createPump();
      }
    }, interval);
  }

  /**
   * Retrieves and returns the first new pump from the list of new pumps if available, otherwise
   * returns null. It prompts the user to indicate if new pumps are available.
   * 
   * @return The first new pump if available, or null if no new pumps are available.
   */
  public Pump getPump() throws Exception {
    String before = toString();
    if (newPumps.size() == 0)
      throw new Exception("[No More Pumps!]");
    Pump p = newPumps.pop();
    Output.printChange(before, toString());
    return p;
  }

  /**
   * Retrieves and returns the first new pipe from the list of new pipes if available. Prompts the
   * user to indicate if new pipes are available. If no new pipes are available, it informs the user
   * accordingly.
   * 
   * @return The first new pipe if available, otherwise null.
   */
  public Pipe getPipe() throws Exception {
    String before = toString();
    if (newPipes.size() == 0)
      throw new Exception("[No More Pipes!]");
    Pipe p = newPipes.pop();
    Output.printChange(before, toString());
    updateViews();
    return p;
  }

  /**
   * Manages the flow of water in response to the cistern's current state and its connections. It
   * empties any full pipes connected to it, adding their water to the cistern, and then attempts to
   * distribute this water to new pipes. This method exemplifies the cistern's role in the dynamic
   * water distribution system.
   */
  @Override
  public void Flow(Pipe iniciator) {
    String before = this.toString();
    if (iniciator.isFull()) {
      iniciator.empty();
      addWater();
    }
    Output.printChange(before, this.toString());
  }

  /**
   * Returns the current amount of water stored in the cistern.
   * 
   * @return The current water amount in the cistern.
   */
  public int getWaterAmount() {
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
