package mainstring.dev.Players.PlayersCollection;

import java.awt.BorderLayout;
import mainstring.dev.Players.Plumber;
import mainstring.dev.Players.Saboteur;
import mainstring.dev.Players.Player.PlayerTextFieldView;

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
    view.plumbersPanel.add(new PlayerTextFieldView(p), BorderLayout.CENTER);
    view.revalidate();
    view.repaint();
  }

  public void addSaboteur() {
    Saboteur s = new Saboteur(null);
    players.add(s);
    view.saboteursPanel.add(new PlayerTextFieldView(s), BorderLayout.CENTER);
    view.revalidate();
    view.repaint();
  }
}
