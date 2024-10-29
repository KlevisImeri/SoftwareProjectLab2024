package mainstring.dev.Players.Saboteur;

import mainstring.dev.Elements.Element.ElementView;
import mainstring.dev.Players.Player.PlayerView;


/**
 * Represents the graphical representation of a Saboteur player in the game. This class extends
 * PlayerView to inherit common functionalities and behaviors of players. It is specifically
 * tailored to handle the unique aspects of the Saboteur character.
 */
public class SaboteurView extends PlayerView {
  /**
   * Constructor for creating a new SaboteurView instance. Initializes the Saboteur player with a
   * specific image and sets up the controller for handling interactions.
   * 
   * @param saboteur The Saboteur player instance.
   * @param location The ElementView representing the location where the Saboteur is placed in the
   *        game.
   */
  public SaboteurView(Saboteur saboteur, ElementView location) {
    super(saboteur, "/Images/saboteur.png", location);
    new SaboteurController(saboteur, this);
  }
}
