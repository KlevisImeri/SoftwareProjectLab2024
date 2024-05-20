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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The GameView class extends JFrame to provide the main window for the game.
 * It sets up the various views and panels needed for the game interface.
 */
public class GameView extends JFrame {
  // Constants for the window dimensions.
  public static final int WIN_WIDTH = 1600;
  public static final int WIN_HEIGHT = 900;

  // The Game instance associated with this view.
  public Game game;

  // Various views and panels used in the game.
  public GridView gridView;

  public PlayersCollectionView playersCollectionView;
  public MenuView menuView;


        // Labels and panels for the end game view.
        JLabel gameEndedLabel = new JLabel("Game Ended!") {{
            setFont(new Font("Arial", Font.BOLD, 80));
            setForeground(new Color(247, 154, 96));
            setAlignmentX(CENTER_ALIGNMENT); // Center the title horizontally
        }};

        JLabel endGameLabelPlumber = new JLabel() {{
            setFont(new Font("Arial", Font.BOLD, 30));
            setForeground(new Color(247, 154, 96));
        }};

        JLabel endGameLabelSaboteur = new JLabel() {{
            setFont(new Font("Arial", Font.BOLD, 30));
            setForeground(new Color(247, 154, 96));
        }};

        JPanel endGameView = new JPanel() {{
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            setBackground(Color.BLACK);
            add(Box.createVerticalStrut(80));
            add(gameEndedLabel);
            add(Box.createVerticalStrut(30)); // Add spacing
            add(endGameLabelPlumber);
            add(Box.createVerticalStrut(20)); // Add spacing
            add(endGameLabelSaboteur);
        }};

  // Labels and panel for the game timer.
  public JLabel endTimer = new JLabel();
  public JLabel playerTimer = new JLabel();
  public JPanel timerPanel = new JPanel() {{
    add(endTimer);
    add(playerTimer);
  }};

  /**
   * Constructs a GameView with the specified Game.
   * Sets up the initial window properties and adds the menu view.
   *
   * @param game the Game associated with this view
   */
  public GameView(Game game) {
    this.game = game;

    // Initialize the players collection view and menu view.
    playersCollectionView = new PlayersCollectionView(game.getPlayers());
    menuView = new MenuView(game.getMenu());

    // Set up the main window properties.
    setName("Pipes In The Desert");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(WIN_WIDTH, WIN_HEIGHT);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    // Add the menu view to the window.
    add(menuView);
    setVisible(true);

    // Controller should be set after the object is initialized.
    new GameController(game, this);
  }
}

