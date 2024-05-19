package mainstring.dev.Game;

import mainstring.dev.Grid.GridView;

public class GameController {
  Game game;
  GameView view;

  public GameController(Game game, GameView view) {
    this.game = game;
    this.view = view;

    view.playersCollectionView.backButton.addActionListener(e -> hideTeams());
    view.menuView.selectTeamsButton.addActionListener(e -> displayTeams());
    view.menuView.startGameButton.addActionListener(e -> startGame());
    view.menuView.settingsButton.addActionListener(e -> openSettings());
    view.menuView.settingsView.backButton.addActionListener(e -> closeSettings());
  }

  public void displayTeams() {
    view.remove(view.menuView);
    view.add(view.playersCollectionView);
    view.revalidate();
    view.repaint();
  }

  public void hideTeams() {
    view.remove(view.playersCollectionView);
    view.add(view.menuView);
    view.revalidate();
    view.repaint();
  }

  public void startGame() {
    view.remove(view.menuView);
    // Start game bfore new GridView So the players are added
    // Should be fixed in the future
    game.startGame(); 
    view.add(new GridView(game.grid));
    view.revalidate();
    view.repaint();
  }

  public void openSettings() {
    view.remove(view.menuView);
    view.add(view.menuView.settingsView);
    view.revalidate();
    view.repaint();
  }

  public void closeSettings() {
    view.remove(view.menuView.settingsView);
    view.add(view.menuView);
    view.revalidate();
    view.repaint();
  }
}
