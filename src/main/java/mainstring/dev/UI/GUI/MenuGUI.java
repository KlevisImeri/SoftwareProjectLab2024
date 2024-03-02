package mainstring.dev.UI.GUI;

import javax.swing.JButton;
import javax.swing.JComponent;
import mainstring.dev.Menu.Menu;
import java.awt.GridLayout;

public class MenuGUI extends JComponent {
  Menu menu;
  JButton newGameButton = new JButton("StartGame");
  JButton settingsButton = new JButton("Settings");

  public MenuGUI(Menu menu) {
    this.menu = menu;
    setLayout(new GridLayout(2, 1));

    newGameButton.addActionListener(menu.startGame);
    settingsButton.addActionListener((e)->addSettingsGUI());

    add(newGameButton);
    add(settingsButton);
  }

  private void addSettingsGUI(){
    add(new SettingsGUI(menu.settings));
    this.revalidate();
  }
}
