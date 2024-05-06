package mainstring.dev.Menus.StartMenu;

import javax.swing.*;
import mainstring.dev.Menus.Settings.SettingsView;
import java.awt.*;

public class MenuView extends JPanel {
  Menu menu;
  MenuController controller = new MenuController(menu, this);

  Dimension buttonSize = new Dimension(200, 50);
  public JButton startGameButton = new JButton("Start Game") {{
      setPreferredSize(buttonSize);
      setBackground(new Color(144, 238, 144));
  }};

  public JButton selectTeamsButton = new JButton("Select Teams") {{
      setPreferredSize(buttonSize);
      setBackground(Color.orange);
  }};

  public JButton settingsButton = new JButton("Open Settings") {{
      setPreferredSize(buttonSize);
      setBackground(Color.lightGray);
    }};
  public ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/desert.png"));
  public SettingsView settingsView;

  public MenuView(Menu menu) {
    this.menu = menu;
    settingsView = new SettingsView(menu.settings);
    setLayout(new GridLayout(2, 1));

    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(new Color(0,0,0,0));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 10;
    gbc.insets = new Insets(5, 5, 5, 5);
    panel.add(startGameButton, gbc);
    gbc.gridy++;
    panel.add(selectTeamsButton, gbc);
    gbc.gridy++;
    panel.add(settingsButton, gbc);

    add(new JLabel());
    add(panel);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
  }

}
