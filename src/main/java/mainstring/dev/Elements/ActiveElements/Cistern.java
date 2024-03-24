package mainstring.dev.Elements.ActiveElements;

import java.util.Timer;
import java.util.List;
import mainstring.dev.Input;
import mainstring.dev.Elements.*;
import mainstring.dev.Grid;

public class Cistern extends ActiveElement {
  // Fields
  protected List<Pump> newPumps; // this are the pumps created
  protected List<Pipe> newPipes;
  protected int waterAmount;
  protected Timer timerPipe = new Timer();
  protected Timer timerPump = new Timer();

  // Private Functions
  private void schedulePipeCreation() {
    createPipe();
  }

  private void schedulePumpCreation() {
    createPump();
  }

  private void createPump() {}

  private void createPipe() {}

  private void addWater() {} // it also checks that water not negative

  private void removewater() {} // it also checks that water not negative
  // Public Functions

  public Cistern(Grid grid) {
    super(grid);
    schedulePipeCreation();
    schedulePumpCreation();
  }

  public Pump getPump() {
    System.out.println("getPump()");
    System.out.println("Does the cistern have new pumps?  [y]es/[n]o");
    switch (Input.getChar("yn")) {
      case 'y':
        return new Pump(grid);
      case 'n':
        System.out.println("No More Pumps!");
    }
    return null;
  }

  public Pipe getPipe() {
    System.out.println("getPipe()");
    System.out.println("Does the cistern have new pumps?  [y]es/[n]o");
    switch (Input.getChar("yn")) {
      case 'y':
        return new Pipe(grid);
      case 'n':
        System.out.println("No More Pipes!");
    }
    return null;
  } 

  @Override
  public void Flow() {
    for (Element element : neighbors) {
      if (((Pipe) element).isFull()) {
        ((Pipe) element).empty();
        addWater();
      }
    }
    for (int i = 0; i < newPipes.size(); i++) {
      removewater();
    }
  }

  public int getWaterAmount() {
    return this.waterAmount;
  }

    
  public String type() {
    return "cistern";
  }
}
