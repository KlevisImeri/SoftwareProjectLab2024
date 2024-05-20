package mainstring.dev.Menus.StartMenu;

/**
 * The MenuController class is responsible for managing the interactions and logic
 * related to the Menu and its view. It handles opening and closing the settings view.
 */
public class MenuController {
  // The Menu instance being controlled.
  Menu menu;

  // The view associated with the Menu.
  MenuView view;

  /**
   * Constructs a MenuController with the specified Menu and MenuView.
   *
   * @param menu the Menu to control
   * @param view the MenuView associated with the Menu
   */
  public MenuController(Menu menu, MenuView view) {
    this.menu = menu;
    this.view = view;
  }

  /**
   * Opens the settings view by adding it to the main view.
   * Updates the settings button text and its action listener.
   */
  public void openSettings() {
    view.add(view.settingsView);
    view.settingsButton.setText("Close Settings");
    view.settingsButton.removeActionListener(view.settingsButton.getActionListeners()[0]);
    view.settingsButton.addActionListener(e -> closeSettings());
    view.repaint();
  }

  /**
   * Closes the settings view by removing it from the main view.
   * Updates the settings button text and its action listener.
   */
  public void closeSettings() {
    view.remove(view.settingsView);
    view.settingsButton.setText("Open Settings");
    view.settingsButton.removeActionListener(view.settingsButton.getActionListeners()[0]);
    view.settingsButton.addActionListener(e -> openSettings());
    view.repaint();
  }
}
