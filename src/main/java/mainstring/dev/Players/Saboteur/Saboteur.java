package mainstring.dev.Players.Saboteur;

import mainstring.dev.Input;
import mainstring.dev.Output;
import mainstring.dev.Elements.Pipe.Pipe;
import mainstring.dev.Output.Color;
import mainstring.dev.Players.Player.Player;

/**
 * Represents a Saboteur, a specialized type of player in the game. Saboteurs have the unique
 * ability to puncture pipes, potentially disrupting the flow of water within the grid. This class
 * encapsulates the behaviors and actions specific to a saboteur, including their active
 * interactions like puncturing pipes.
 */
public class Saboteur extends Player {
  /**
   * Provides a string representation of the saboteur, including their name.
   * 
   * @return A string representing the saboteur.
   */
  @Override
  public String toString() {
    String superString = super.toString().replace("\n", "\n  ");
    return "S,%s".formatted(superString);
  }

  /**
   * Constructs a Saboteur with a specified name.
   * 
   * @param name The name of the Saboteur.
   */
  public Saboteur(String name) {
    this.name = name;
  }

  /**
   * Attempts to puncture the pipe at the Saboteur's current location. This action can only be
   * performed if the Saboteur is located on a Pipe element.
   */
  public void puncturePipe() {
    if (location instanceof Pipe) {
      ((Pipe) location).puncture();
    } else {
      Output.println("You can only puncture Pipes!", Color.LIGHT_RED);
    }
  }

  /**
   * Defines the saboteur's active behavior in the game. This method prompts the player to choose an
   * action from a predefined list of possible actions, specifically designed for the saboteur's
   * role.
   */
  @Override
  public void active() {
    keyTyped();
  }

  /**
   * Defines the saboteur's passive behavior in the game. Currently, this method does not implement
   * any specific behavior.
   */
  @Override
  public void passive() {}

  /**
   * Processes player input to determine the action the saboteur should take. This method allows the
   * player to choose from moving, changing pump direction, and puncturing pipes.
   */
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

  /**
   * Returns the type of this player, which is "saboteur".
   * 
   * @return A string indicating the player's type.
   */
  public String type() {
    return "saboteur";
  }
}
