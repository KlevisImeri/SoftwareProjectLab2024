package mainstring.dev.Game;

import java.util.Random;
import javax.swing.Timer;
import mainstring.dev.Output;
import mainstring.dev.Output.Color;
import mainstring.dev.Grid.GridView;
import mainstring.dev.Players.Player.Player;

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
    game.setUp(); 
    view.add(new GridView(game.grid));
    view.revalidate();
    view.repaint();
    Output.println("\n[Game Started]", Color.LIGHT_BLUE);
    new Timer(10, (e) -> mainLoop());
    new Timer(10, (e) -> game.grid.caculateFlow());
  }

  int endTime = game.menu.settings.getEndTime() * 60 * 1000; //millisecounds.
  int playerTime = game.menu.settings.getPlayerTime() * 1000;
  int currentPlayerTime = playerTime;
  void mainLoop() {
      if(endTime <= 0) {
        stop(); 
        endGame();
        return;
      }
      endTime-=10;
      if(playerTime <= 0) { 
        currentPlayerTime = playerTime;
        view.gridView.playerViews.get(new Random());
      }
    }
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
