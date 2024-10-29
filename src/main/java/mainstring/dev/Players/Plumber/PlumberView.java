package mainstring.dev.Players.Plumber;


import mainstring.dev.Elements.ActiveElements.Pump.PumpView;
import mainstring.dev.Elements.Element.ElementView;
import mainstring.dev.Elements.Pipe.PipeView;
import mainstring.dev.Players.Player.PlayerView;

/**
 * The PlumberView class extends PlayerView to provide a visual representation
 * of a Plumber in the game. It manages the display of the plumber and their
 * interactions with pipes and pumps.
 */
public class PlumberView extends PlayerView {
  // The Plumber instance being represented by this view.
  Plumber plumber;
  
  // The PipeView currently being carried by the plumber.
  public PipeView carryPipeView;

  // The PumpView currently being carried by the plumber.
  public PumpView carryPumpView;

  /**
   * Constructs a PlumberView with the specified Plumber and location.
   * Sets up the view and initializes the controller.
   *
   * @param plumber the Plumber to be represented by this view
   * @param location the initial location of the plumber
   */
  public PlumberView(Plumber plumber, ElementView location) {
    super(plumber, "/Images/plumer.png", location);
    this.plumber = plumber;

    // Initialize the controller for this view.
    new PlumberController(plumber, this);
  }
}
