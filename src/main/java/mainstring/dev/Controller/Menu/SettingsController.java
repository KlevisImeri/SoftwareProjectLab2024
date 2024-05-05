package mainstring.dev.Controller.Menu;


import mainstring.dev.Model.Menu.Settings;
import mainstring.dev.View.Menu.SettingsView;

public class SettingsController {
  Settings settings;
  SettingsView view;

  public SettingsController(Settings settings, SettingsView view) {
    view.settings = settings;

    this.settings = settings;
    this.view = view;
  }
  
}
