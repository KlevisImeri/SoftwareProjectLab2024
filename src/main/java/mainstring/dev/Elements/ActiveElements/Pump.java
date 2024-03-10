package mainstring.dev.Elements.ActiveElements;


// import mainstring.dev.Grid;
import mainstring.dev.Elements.Pipe;
// import mainstring.dev.UI.GUI.PumpGUI;
// import java.awt.event.ActionListener;
// import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

//implements mouseListerner
public class Pump extends ActiveElement {
  public enum PumpState {
    HEALTHY, BROKEN
  }
  
  class Reservoir {
    int capacity;
    int totalWater;

    void addWater() {totalWater++;}
    void removeWater() {capacity++;}
  }
  private class PipeBreakTask extends TimerTask {
    @Override
    public void run() {
        state = PumpState.BROKEN; // change pipe to broken
        schedulePipeBreak(); // Reschedule for the next random delay
    }
  }


  //Fields
  PumpState state = PumpState.HEALTHY;
  Reservoir reservoir;
  private Pipe in;
  private Pipe out;
  private Timer timer = new Timer();

  //private functions
  private void schedulePipeBreak() {
    // Generate a random delay between 0 and 10 seconds
    long delay = random.nextInt(11) * 1000; // Convert to milliseconds
    // Schedule the updateState method with the random delay
    timer.schedule(new PipeBreakTask(), delay);
  }
  
  //public functions
  public Pump() {
    schedulePipeBreak();
  }

  public void onMouseClick(){
    grid.setSelectedPump(this);
  } //used
  public void setInPipe(Pipe pipe) {this.in = pipe;} //used 
  public void setOutPipe(Pipe pipe) {this.out = pipe;} //used
  public void fix() {} //used
  public void changeDirection() {} //used
  @Override
  public void Flow(){
    if(in.isFull()){
      if(state==PumpState.BROKEN){
        reservoir.addWater();
      }else{
        out.fill();
      }
      in.empty();
    }
  }
}

// //controller Example
// public class PumpController {
//   Pump pump;
//   PumpGUI gui;
//   GridController grid;
// p
//   controsutn(pump,gui){}

//   public void connectPipe(Pipe pipe) {
//       grid.connecPipe((plumber)grid.currentPlayer)
//   }
//   public void removePipe(Pipe pipe) {}
//   public void setInPipe(Pipe pipe) {}
//   public void setOutPipe(Pipe pipe) {}
//   public void fixPump() {}
// }