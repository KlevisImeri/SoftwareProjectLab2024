package mainstring.dev.Players.PlayersCollection;


import mainstring.dev.Players.PlayersCollection.PlayersCollectionView.PlayerField;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Saboteur.Saboteur;

/**
 * The PlayersCollectionController class is responsible for managing the interactions
 * between the PlayersCollection and the PlayersCollectionView. It handles adding
 * and removing players from the collection and updating the view accordingly.
 */
public class PlayersCollectionController {

  // The PlayersCollection instance being controlled.
  PlayersCollection players;

  // The view associated with the PlayersCollection.
  PlayersCollectionView view;

  /**
   * Constructs a PlayersCollectionController with the specified PlayersCollection and PlayersCollectionView.
   *
   * @param players the PlayersCollection to control
   * @param view the PlayersCollectionView associated with the PlayersCollection
   */
  public PlayersCollectionController(PlayersCollection players, PlayersCollectionView view) {
    this.players = players;
    this.view = view;
  }

  /**
   * Adds a new Plumber to the collection and updates the view.
   */
  public void addPlumber() {
    Plumber p = new Plumber(null);
    players.add(p);
    view.plumbersPanel.add(view.new PlayerField(p));
    view.revalidate();
    view.repaint();
  }

  /**
   * Adds a new Saboteur to the collection and updates the view.
   */
  public void addSaboteur() {
    Saboteur s = new Saboteur(null);
    players.add(s);
    view.saboteursPanel.add(view.new PlayerField(s));
    view.revalidate();
    view.repaint();
  }

  /**
   * Removes a player from the collection and updates the view.
   *
   * @param playerField the PlayerField associated with the player to be removed
   */
  public void removePlayer(PlayerField playerField) {
    players.remove(playerField.textField.player);
    if (playerField.textField.player instanceof Plumber) {
        view.plumbersPanel.remove(playerField);
    } else {
        view.saboteursPanel.remove(playerField);
    }
    view.revalidate();
    view.repaint();
  }

}
