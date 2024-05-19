package mainstring.dev.Game;

import mainstring.dev.Grid.GridView;
import mainstring.dev.Menus.StartMenu.MenuView;
import mainstring.dev.Players.PlayersCollection.PlayersCollectionView;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class GameView extends JFrame {
  public static final int WIN_WIDTH = 1600;
  public static final int WIN_HEIGHT = 900;

  public Game game;
  
  public GridView gridView;
  public PlayersCollectionView playersCollectionView;
  public MenuView menuView;

  public GameView(Game game) {
    this.game = game;
    
    playersCollectionView = new PlayersCollectionView(game.getPlayers());
    menuView = new MenuView(game.getMenu());
    
    setName("Pipes In The Desert");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(WIN_WIDTH, WIN_HEIGHT);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());
    add(menuView);
    setVisible(true);

    //Contoller should be set after the object is inicilized
    new GameController(game, this); 
  }
}

