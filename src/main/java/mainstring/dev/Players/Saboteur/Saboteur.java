package mainstring.dev.Players.Saboteur;

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
    updateViews();
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
