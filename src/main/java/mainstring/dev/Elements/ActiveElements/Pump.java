package mainstring.dev.Elements.ActiveElements;

import mainstring.dev.Elements.Pipe;
import java.sql.Time;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Pump extends ActiveElement {
  public enum PumpState {
    HEALTHY, BROKEN
  }
  class Reservoir {
    int capacity;
    int totalWater;

    void addWater(int value) {}
  }

  PumpState state = PumpState.HEALTHY;
  Time duration;
  Reservoir reservoir;
  int capacity;
  List<Pipe> pipes;
  Pipe in;
  Pipe out;
  private Timer timer = new Timer();
  private Random random = new Random();


  private void scheduleUpdate() {
    // Generate a random delay between 0 and 10 seconds
    long delay = random.nextInt(11) * 1000; // Convert to milliseconds

    // Schedule the updateState method with the random delay
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        state = PumpState.BROKEN; // change pipe to broken
        // Reschedule for the next random delay
        scheduleUpdate();
      }
    }, delay);
  }

  public Pump() {
    scheduleUpdate();
  }

  public void connectPipe(Pipe pipe) {}

  public void removePipe(Pipe pipe) {}

  public void setInPipe(Pipe pipe) {}

  public void setOutPipe(Pipe pipe) {}

}
