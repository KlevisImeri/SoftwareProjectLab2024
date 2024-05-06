package mainstring.dev.Players.PlayersCollection;


import mainstring.dev.Players.PlayersCollection.PlayersCollectionView.PlayerField;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Saboteur.Saboteur;


public class PlayersCollectionController {
  PlayersCollection players;
  PlayersCollectionView view;

  public PlayersCollectionController(PlayersCollection players, PlayersCollectionView view) {
    this.players = players;
    this.view = view;
  }

  public void addPlumber() {
    Plumber p = new Plumber(null);
    players.add(p);
    view.plumbersPanel.add(view.new PlayerField(p));
    view.revalidate();
    view.repaint();
  }

  public void addSaboteur() {
    Saboteur s = new Saboteur(null);
    players.add(s);
    view.saboteursPanel.add(view.new PlayerField(s));
    view.revalidate();
    view.repaint();
  }

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
