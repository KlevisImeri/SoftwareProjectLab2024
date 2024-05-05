package mainstring.dev.View;

import mainstring.dev.Model.Game;
import mainstring.dev.View.Menu.MenuView;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class GameView extends JFrame {
  public Game game;
  public MenuView menuView;

  public GameView(Game game) {
    this.game = game;
    menuView = new MenuView(game.getMenu());
    setName("Pipes In The Desert");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1200, 675);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());
    add(menuView);
    setVisible(true);
  }
}

