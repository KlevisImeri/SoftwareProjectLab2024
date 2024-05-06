package mainstring.dev.Menus.StartMenu;


public class MenuController {
  Menu menu;
  MenuView view;

  public MenuController(Menu menu, MenuView view) {
    this.menu = menu;
    this.view = view;
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
