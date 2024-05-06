package mainstring.dev.Game;

public class GameController {
  Game game;
  GameView view;

  public GameController(Game game, GameView view) {
    this.game = game;
    this.view = view;
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
    view.add(view.gridView);
    game.startGame();
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
