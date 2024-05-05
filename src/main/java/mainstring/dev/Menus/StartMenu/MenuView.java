package mainstring.dev.Menus.StartMenu;

import javax.swing.*;
import mainstring.dev.Menus.Settings.SettingsView;
import java.awt.*;

public class MenuView extends JPanel {
  Menu menu;
  MenuController controller = new MenuController(menu, this);

  public JButton startGameButton = new JButton("Start Game");
  public JButton selectTeamsButton = new JButton("Select Teams");
  public JButton settingsButton = new JButton("Open Settings");
  public ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/desert.png"));
  public SettingsView settingsView;

  public MenuView(Menu menu) {
    this.menu = menu;
    settingsButton.addActionListener(e -> controller.openSettings());
    settingsView = new SettingsView(menu.settings);
    setLayout(new FlowLayout(FlowLayout.CENTER));
    add(startGameButton);
    add(selectTeamsButton);
    add(settingsButton);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
  }

}
