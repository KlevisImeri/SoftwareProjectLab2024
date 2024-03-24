package mainstring.dev.Elements.ActiveElements;


// import mainstring.dev.Grid;
import mainstring.dev.Elements.Pipe;
// import mainstring.dev.UI.GUI.PumpGUI;
// import java.awt.event.ActionListener;
// import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import mainstring.dev.Grid;
import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;

// implements mouseListerner
public class Pump extends ActiveElement {
  public enum PumpState {
    HEALTHY, BROKEN
  }

  class Reservoir {
    public int capacity  = 10;
    public int totalWater = 0;

    public void addWater() {
      System.out.println("addWater()");
      totalWater++;
    }

    public void removeWater() {
      System.out.println("removeWater()");
      totalWater--;
    }
  }
  private class PipeBreakTask extends TimerTask {
    @Override
    public void run() {
      state = PumpState.BROKEN; // change pipe to broken
      schedulePipeBreak(); // Reschedule for the next random delay
    }
  }

  // Fields
  PumpState state = PumpState.HEALTHY;
  Reservoir reservoir = new Reservoir();
  private Pipe in;
  private Pipe out;
  private Timer timer = new Timer();

  // This is an exmaple of how the timer should have been implemedted
  private void schedulePipeBreak() {
    // Generate a random delay between 0 and 10 seconds
    long delay = random.nextInt(11) * 1000; // Convert to milliseconds
    // Schedule the updateState method with the random delay
    timer.schedule(new PipeBreakTask(), delay);
  }

  // public functions
  public Pump(Grid grid) {
    super(grid);
    System.out.println("Pump()");
    schedulePipeBreak();
  }

  public void setInPipe(Pipe pipe) {
    System.out.println("setInPipe()");
    addNeighbor(pipe);
    this.in = pipe;
  }

  public void setOutPipe(Pipe pipe) {
    System.out.println("setOutPipe()");
    addNeighbor(pipe);
    this.out = pipe;
  }

  public void fix() {
    System.out.println("fix()");
  }

  public void changeDirection() {
    System.out.println("changeDirection()");
  }

  @Override
  public void Flow() {
    Output.println("|----------------5.2.14.2 Calculation of the flow at a pump-----------------|",
        Color.LIGHT_BLUE);
    System.out.println("Flow()");
    if (in.isFull()) {
      if (state == PumpState.BROKEN) {
        reservoir.addWater();
      } else {
        out.fill();
      }
      in.empty();
    } else {
      if (state != PumpState.BROKEN && reservoir.capacity != reservoir.totalWater) {
        reservoir.removeWater();
        out.fill();
      }
    }
    // This is how it looks if you want to ask the tester
    // System.out.println(" Is the incoming Pipe full? [y]es\\[n]o");
    // switch (Input.getChar("yn")) {
    // case 'y':
    // System.out.println(" Is the pump broken? [y]es\\[n]o");
    // switch (Input.getChar("yn")) {
    // case 'y':
    // reservoir.addWater();
    // break;
    // case 'b':
    // out.fill();
    // break;
    // }
    // in.empty();
    // break;
    // case 'n':
    // System.out.println("Is the reservoir empty? [y]es\\[n]o");
    // switch (Input.getChar("yn")) {
    // case 'y':
    // reservoir.removeWater();
    // break;
    // case 'b':
    // out.fill();
    // break;
    // }
    // break;
    // }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
  }

  public String type() {
    return "pump";
  }
}

