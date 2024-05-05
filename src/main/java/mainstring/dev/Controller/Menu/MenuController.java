package mainstring.dev.Controller.Menu;

import mainstring.dev.Model.Menu.Menu;
import mainstring.dev.View.Menu.MenuView;
import javax.swing.JPanel;

public class MenuController extends JPanel  {
  private Menu menu;
  private MenuView view;

  public MenuController(Menu menu, MenuView view) {
    view.startGameButton.addActionListener(e -> startGame());
    view.settingsButton.addActionListener(e -> openSettings());
    new SettingsController(menu.settings, view.settingsView);
    
    this.menu = menu;
    this.view = view;
  }

  public void startGame() {
    menu.game.startGame();
  }

  public void openSettings() {
    view.add(view.settingsView);
    view.settingsButton.setText("Close Settings");
    view.settingsButton.removeActionListener(view.settingsButton.getActionListeners()[0]);
    view.settingsButton.addActionListener(e -> closeSettings());
    view.repaint();
  }

  public void closeSettings() {
    view.remove(view.settingsView);
    view.settingsButton.setText("Open Settings");
    view.settingsButton.removeActionListener(view.settingsButton.getActionListeners()[0]);
    view.settingsButton.addActionListener(e -> openSettings());
    view.repaint();
  }
}
