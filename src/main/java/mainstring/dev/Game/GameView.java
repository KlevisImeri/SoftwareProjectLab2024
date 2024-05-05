package mainstring.dev.Game;

import mainstring.dev.Grid.GridView;
import mainstring.dev.Menus.StartMenu.MenuView;
import mainstring.dev.Players.PlayersCollection.PlayersCollectionView;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class GameView extends JFrame {
  public Game game;
  public GameController controller;

  public GridView gridView;
  public PlayersCollectionView playersCollectionView;
  public MenuView menuView;

  public GameView(Game game) {
    this.game = game;
    controller = new GameController(game, this);

    playersCollectionView = new PlayersCollectionView(game.getPlayers());
    gridView = new GridView(game.getGrid());
    menuView = new MenuView(game.getMenu());
    playersCollectionView.backButton.addActionListener(e -> controller.hideTeams());
    menuView.selectTeamsButton.addActionListener(e -> controller.displayTeams());
    menuView.startGameButton.addActionListener(e -> controller.startGame());

    setName("Pipes In The Desert");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1200, 675);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());
    add(menuView);
    setVisible(true);
  }
}

