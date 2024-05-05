package mainstring.dev.Menus.Settings;

public class SettingsController {
  Settings settings;
  SettingsView view;

  public SettingsController(Settings settings, SettingsView view) {
    this.settings = settings;
    this.view = view;
  }

  public void setEndTime() {
    settings.setEndTime(Integer.parseInt(view.endTimeText.getText()));
  }

  public void setPlayerTime() {
    settings.setPlayerTime(Integer.parseInt(view.endPlayerText.getText()));
  }
  
}
