package mainstring.dev.Elements.ActiveElements;

import java.util.Timer;
import java.util.ArrayList;
import java.util.List;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;
import mainstring.dev.Elements.*;
import mainstring.dev.Grid;

public class Cistern extends ActiveElement {
  // Fields
  protected List<Pump> newPumps = new ArrayList<>(); // this are the pumps created
  protected List<Pipe> newPipes = new ArrayList<>();
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

  public void createPump() {
    newPumps.add(new Pump(grid));
  }

  public void createPipe() {
    newPipes.add(new Pipe(grid));
  }

  private void addWater() {
    System.out.println("addWater()");
  } // it also checks that water not negative

  private void removewater() {
    System.out.println("removeWater()");
  } // it also checks that water not negative
  // Public Functions

  public Cistern(Grid grid) {
    super(grid);
    System.out.println("Cistern()");
    schedulePipeCreation();
    schedulePumpCreation();
  }

  public Pump getPump() {
    System.out.println("getPump()");
    System.out.println("Does the cistern have new pumps?  [y]es/[n]o");
    switch (Input.getChar("yn")) {
      case 'y':
        return newPumps.get(0);
      case 'n':
        System.out.println("No More Pumps!");
    }
    return null;
  }

  public Pipe getPipe() {
    System.out.println("getPipe()");
    System.out.println("Does the cistern have new pipes?  [y]es/[n]o");
    switch (Input.getChar("yn")) {
      case 'y':
        return newPipes.get(0);
      case 'n':
        System.out.println("No More Pipes!");
    }
    return null;
  }

  @Override
  public void Flow() {
    Output.println("|----------------5.2.14.2 Calculation of the flow at a cistern-----------------|",
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

  public int getWaterAmount() {
    System.out.println("getWaterAmount()");
    return this.waterAmount;
  }

  public int setWaterAmount(int waterAmount) {
    System.out.println("setWaterAmount()");
    return this.waterAmount = 20;
  }


  public String type() {
    return "cistern";
  }
}
