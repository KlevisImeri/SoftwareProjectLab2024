package mainstring.dev.Game;

import mainstring.dev.JImage;
import mainstring.dev.Grid.GridView;
import mainstring.dev.Menus.StartMenu.MenuView;
import mainstring.dev.Players.PlayersCollection.PlayersCollectionView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends JFrame {
  public static final int WIN_WIDTH = 1600;
  public static final int WIN_HEIGHT = 900;

  public Game game;


  public GridView gridView;

  public PlayersCollectionView playersCollectionView;
  public MenuView menuView;


  JLabel gameEndedLabel = new JLabel("Game Ended!") {{
      setFont(new Font("Arial", Font.BOLD, 80));
      setForeground(new Color(247, 154, 96));
      setAlignmentX(CENTER_ALIGNMENT); // Center the title horizontally
  }};

  JLabel endGameLabelPlumber = new JLabel() {{
      setFont(new Font("Arial", Font.BOLD, 30));
      setForeground(new Color(247, 154, 96));
      setAlignmentX(CENTER_ALIGNMENT);
  }};

  JLabel endGameLabelSaboteur = new JLabel() {{
      setFont(new Font("Arial", Font.BOLD, 30));
      setForeground(new Color(247, 154, 96));
      setAlignmentX(CENTER_ALIGNMENT);
  }};

  JImage endGameView = new JImage("/Images/desertBackground.png") {{
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
    setBackground(Color.BLACK);
    add(Box.createVerticalStrut(80));
    add(gameEndedLabel);
    add(Box.createVerticalStrut(30)); // Add spacing
    add(endGameLabelPlumber);
    add(Box.createVerticalStrut(20)); // Add spacing
    add(endGameLabelSaboteur);
  }};

  

  public JLabel endTimer = new JLabel();
  public JLabel playerTimer = new JLabel();
  public JPanel timerPanel = new JPanel() {{
      add(endTimer);
      add(playerTimer);
  }};

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

    // Contoller should be set after the object is inicilized
    new GameController(game, this);
  }
}

