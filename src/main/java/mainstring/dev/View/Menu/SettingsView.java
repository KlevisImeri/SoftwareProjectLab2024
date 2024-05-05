package mainstring.dev.View.Menu;


import mainstring.dev.Model.Menu.Settings;
import javax.swing.*;
import java.awt.*;


public class SettingsView extends JPanel {
  public Settings settings;
  public JLabel endTimeLabel = new JLabel("End Time:");
  public JTextField endTimeText = new JTextField(settings.getEndTime());
  public JLabel endPlayerLabel = new JLabel("Player Time:");
  public JTextField endPlayerText = new JTextField(settings.getPlayerTime());

  public SettingsView(Settings settings) {
    this.settings = settings;
    setLayout(new GridLayout(2, 2));
    add(endTimeLabel);
    add(endTimeText);
    add(endPlayerLabel);
    add(endPlayerText);
  }
}
