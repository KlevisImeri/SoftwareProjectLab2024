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

/**
 * The GameController class is responsible for managing the game flow,
 * handling user interactions, and updating the game view.
 */
public class GameController {
  // The Game instance being controlled.
  Game game;

  // The view associated with the game.
  GameView view;

  /**
   * Constructs a GameController with the specified Game and GameView.
   * Sets up the action listeners for the view's buttons.
   *
   * @param game the Game to control
   * @param view the GameView associated with the Game
   */
  public GameController(Game game, GameView view) {
    this.game = game;
    this.view = view;

    // Set up action listeners for the buttons in the view.
    view.playersCollectionView.backButton.addActionListener(e -> hideTeams());
    view.menuView.selectTeamsButton.addActionListener(e -> displayTeams());
    view.menuView.startGameButton.addActionListener(e -> startGame());
    view.menuView.settingsButton.addActionListener(e -> openSettings());
    view.menuView.settingsView.backButton.addActionListener(e -> closeSettings());
  }

  /**
   * Displays the teams view by replacing the menu view.
   */
  public void displayTeams() {
    view.remove(view.menuView);
    view.add(view.playersCollectionView);
    view.revalidate();
    view.repaint();
  }

  /**
   * Hides the teams view and returns to the menu view.
   */
  public void hideTeams() {
    view.remove(view.playersCollectionView);
    view.add(view.menuView);
    view.revalidate();
    view.repaint();
  }

  /**
   * Starts the game by setting up the game, initializing the grid view,
   * and starting the main loop and flow calculation timers.
   */
  public void startGame() {
    view.remove(view.menuView);
    view.add(view.timerPanel, BorderLayout.NORTH);
    game.setUp();
    view.gridView = new GridView(game.grid);
    view.add(view.gridView);
    view.revalidate();
    view.repaint();
    Output.println("\n[Game Started]", Color.LIGHT_BLUE);
    endTime = game.menu.settings.getEndTime() * 60 * 1000;
    playerTime = game.menu.settings.getPlayerTime() * 1000;

    // Initialize and start the main loop and flow calculation timers.
    mainLoopTimer = new Timer(1000, (e) -> mainLoop());
    flowCalculationTimer = new Timer(1000, (e) -> game.grid.caculateFlow());
    mainLoopTimer.start();
    flowCalculationTimer.start();
  }

  // Timers for the main game loop and flow calculation.
  Timer mainLoopTimer;
  Timer flowCalculationTimer;

  // Time variables for the game and players.
  int endTime; // millisecounds.
  int playerTime;
  int currentPlayerTime = 0;

  // The current player and their command view.
  Player currentPlayer;
  PlayerCommandView playerView;

  /**
   * The main game loop, executed at regular intervals.
   * Manages the game timer, player turns, and updates the view.
   */
  private void mainLoop() {
    if (endTime <= 0) {
      // If the game time has ended, stop the timers and end the game.
      mainLoopTimer.stop();
      flowCalculationTimer.stop();
      endGame();
      return;
    }
    endTime -= 1000;
    view.endTimer.setText("Time: " + formatTime(endTime));

    if (currentPlayer != null)
      currentPlayer.active();

    if (currentPlayerTime <= 0) {
      // If the current player's time has ended, select a new player and reset the timer.
      currentPlayerTime = playerTime;
      currentPlayer = game.players.selectRandom();
      currentPlayer.active();
      if(playerView != null) view.remove(playerView);
      playerView = new PlayerCommandView(currentPlayer);
      view.add(playerView, BorderLayout.EAST);
    }
    currentPlayerTime -= 1000;
    view.playerTimer.setText(currentPlayer.getName() + ": " + formatTime(currentPlayerTime));
  }

  /**
   * Formats the given time in milliseconds to a string in the format HH:MM:SS.
   *
   * @param milliseconds the time in milliseconds to format
   * @return the formatted time string
   */
  private String formatTime(int milliseconds) {
    int seconds = milliseconds / 1000;
    int hours = seconds / 3600;
    int minutes = (seconds % 3600) / 60;
    seconds = seconds % 60;
    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
  }

  /**
   * Ends the game by stopping the timers, updating the end game view,
   * and displaying the results.
   */
  private void endGame() {
    game.endGame();
    view.endGameLabelPlumber
        .setText("The plumber gathered: " + game.grid.getWaterAtCistern() + " liters of water");
    view.endGameLabelSaboteur
        .setText("The saboteurs leaked: " + game.grid.getWaterAtDesert() + " liters of water");
    view.remove(view.gridView);
    view.remove(view.timerPanel);
    view.remove(playerView);
    view.add(view.endGameView, BorderLayout.CENTER);
    view.endGameView.setImageSize(view.getSize());
    view.revalidate();
    view.repaint();
  }

  /**
   * Opens the settings view by replacing the menu view.
   */
  public void openSettings() {
    view.remove(view.menuView);
    view.add(view.menuView.settingsView);
    view.revalidate();
    view.repaint();
  }

  /**
   * Closes the settings view and returns to the menu view.
   */
  public void closeSettings() {
    view.remove(view.menuView.settingsView);
    view.add(view.menuView);
    view.revalidate();
    view.repaint();
  }
}
