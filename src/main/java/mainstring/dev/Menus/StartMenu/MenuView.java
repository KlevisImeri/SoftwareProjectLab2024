package mainstring.dev.Menus.StartMenu;

import javax.swing.*;
import mainstring.dev.JImage;
import mainstring.dev.Menus.Settings.SettingsView;
import java.awt.*;

/**
 * The MenuView class extends JImage to provide the user interface for the start menu.
 * It includes buttons for starting the game, selecting teams, and opening settings.
 */
public class MenuView extends JImage {

  // The Menu instance being represented by this view.
  Menu menu;

  // The controller for handling menu interactions.
  MenuController controller = new MenuController(menu, this);

  // Dimensions for the buttons.
  Dimension buttonSize = new Dimension(200, 50);

  // Button for starting the game.
  public JButton startGameButton = new JButton("Start Game") {{
      setPreferredSize(buttonSize);
      setBackground(new Color(144, 238, 144));
      setFont(new Font("Arial", Font.BOLD, 16));
  }};

  // Button for selecting teams.
  public JButton selectTeamsButton = new JButton("Select Teams") {{
      setPreferredSize(buttonSize);
      setBackground(Color.orange);
      setFont(new Font("Arial", Font.BOLD, 16));
  }};
  
  // Button for opening settings.
  public JButton settingsButton = new JButton("Open Settings") {{
      setPreferredSize(buttonSize);
      setBackground(Color.lightGray);
      setFont(new Font("Arial", Font.BOLD, 16));
    }};

  // Background image for the menu view.
  public ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/desert.png"));

  // Settings view associated with the menu.
  public SettingsView settingsView;

  /**
   * Constructs a MenuView with the specified Menu.
   * Initializes the UI components and sets up the layout.
   *
   * @param menu the Menu to be represented by this view
   */
  public MenuView(Menu menu) {
    super("/Images/desert.png");
    this.menu = menu;

    // Initialize the settings view.
    settingsView = new SettingsView(menu.settings);

    // Set the layout for the menu view.
    setLayout(new GridLayout(2, 1));

    // Create a panel to hold the buttons.
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(new Color(0,0,0,0));

    // Set up the constraints for the buttons.
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 10;
    gbc.insets = new Insets(10, 10, 10, 10);
    panel.add(startGameButton, gbc);
    gbc.gridy++;
    panel.add(selectTeamsButton, gbc);
    gbc.gridy++;
    panel.add(settingsButton, gbc);

    // Add the buttons panel to the menu view.
    add(new JLabel());
    add(panel);
  }

  /**
   * Paints the background image for the menu view.
   *
   * @param g the Graphics object to protect
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
  }

}
