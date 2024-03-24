package mainstring.dev.Players;

import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;
import mainstring.dev.Elements.Pipe;

public class Saboteur extends Player {

  public Saboteur(String name) {
    this.name = name;
  }

  public void puncturePipe() {
    Output.println("|-----------------5.2.8.1 The Saboteur punctures the pipe-------------------|",
        Color.LIGHT_BLUE);
    System.out.println("puncturePipe()");
    if (location instanceof Pipe) {
      System.out.println("puncture()");
      ((Pipe) location).puncture();
    } else {
      Output.println("You can only puncture Pipes!", Color.LIGHT_RED);
    }
    Output.println("|--------------------------------------------------------------------|\n",
        Color.LIGHT_BLUE);
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
    return "Saboteur: " + name;
  }

  public String type() {
    return "saboteur";
  }
}
