package mainstring.dev.Game;

import java.awt.BorderLayout;
import java.sql.Time;
import java.util.Random;
import javax.swing.Timer;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;
import mainstring.dev.Grid.GridView;
import mainstring.dev.Players.Player.Player;
import mainstring.dev.Players.Player.PlayerCommandView;

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
    view.add(view.timerPanel, BorderLayout.NORTH);
    game.setUp();
    view.add(new GridView(game.grid));
    view.revalidate();
    view.repaint();
    Output.println("\n[Game Started]", Color.LIGHT_BLUE);
    endTime = game.menu.settings.getEndTime() * 60 * 1000;
    playerTime = game.menu.settings.getPlayerTime() * 1000;
    mainLoopTimer = new Timer(1000, (e) -> mainLoop());
    flowCalculationTimer = new Timer(1000, (e) -> game.grid.caculateFlow());
    mainLoopTimer.start();
    flowCalculationTimer.start();
  }

  Timer mainLoopTimer;
  Timer flowCalculationTimer;
  int endTime; // millisecounds.
  int playerTime;
  int currentPlayerTime = 0;
  Player currentPlayer;

  private void mainLoop() {
    if (endTime <= 0) {
      mainLoopTimer.stop();
      flowCalculationTimer.stop();
      endGame();
      return;
    }
    endTime -= 1000;
    view.endTimer.setText("Time: " + formatTime(endTime));
    if(currentPlayer!=null) currentPlayer.active();
    if (currentPlayerTime <= 0) {
      currentPlayerTime = playerTime;
      currentPlayer = game.players.selectRandom();
      currentPlayer.active();
      view.add(new PlayerCommandView(currentPlayer), BorderLayout.EAST);
    }
    currentPlayerTime -= 1000;
    view.playerTimer.setText(currentPlayer.getName()+": " + formatTime(currentPlayerTime));
  }

  private String formatTime(int milliseconds) {
    int seconds = milliseconds / 1000;
    int hours = seconds / 3600;
    int minutes = (seconds % 3600) / 60;
    seconds = seconds % 60;
    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
  }

  private void endGame() {
    game.endGame();
    view.endGameLabelPlumber
        .setText("The plumber gathered: " + game.grid.getWaterAtCistern() + "liters of water");
    view.endGameLabelSaboteur
        .setText("The saboteurs leaked: " + game.grid.getWaterAtDesert() + "liters of water");
    view.remove(view.gridView);
    view.add(view.endGameView);
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
