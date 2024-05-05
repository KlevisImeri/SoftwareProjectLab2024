package mainstring.dev.View.Menu;

import mainstring.dev.Model.Menu.Menu;
import javax.swing.*;
import java.awt.*;

public class MenuView extends JPanel {
  public Menu menu;

  public JButton startGameButton = new JButton("Start Game");
  public JButton settingsButton = new JButton("Open Settings");
  public ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/desert.png"));
  public SettingsView settingsView;

  public MenuView(Menu menu) {
    this.menu = menu;
    settingsView = new SettingsView(menu.settings);
    setLayout(new FlowLayout(FlowLayout.CENTER));
    add(startGameButton);
    add(settingsButton);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
  }

}
