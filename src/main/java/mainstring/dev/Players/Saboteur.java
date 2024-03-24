package mainstring.dev.Players;

import mainstring.dev.Input;
import mainstring.dev.Elements.Pipe;

public class Saboteur extends Player {

  public Saboteur(String name) {
    this.name = name;
  }

  public void puncturePipe() {
    System.out.println("puncturePipe()");
    if (location instanceof Pipe) {
      System.out.println("The saboteur is on the pipe!");
      System.out.println("puncture()");
      ((Pipe) location).puncture();
    } else {
      System.out.println("You can only puncture Pipes!");
    }
  }

  @Override
  public void active() {
    System.out.println("active()");
    keyTyped();
  }

  @Override
  public void passive() {
    System.out.println("passive()");
  }

  public void keyTyped() {
    System.out.println("What does the player do?");
    System.out.println("changePump[D]irection()");
    System.out.println("[m]ove");
    System.out.println("[p]uncturePipe()");
    switch (Input.getChar("Dmp")) {
      case 'D':
        changePumpDirection();
        break;
      case 'm':
        move();
        break;
      case 'p':
        puncturePipe();
        break;
    }
  }

  @Override
  public String toString() {
    return "Saboteur: "+name;
  }

  public String type() {
    return "saboteur";
  }
}
