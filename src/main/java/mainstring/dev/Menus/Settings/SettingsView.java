package mainstring.dev.Menus.Settings;


import javax.swing.*;
import java.awt.*;


public class SettingsView extends JPanel {
  Settings settings;
  SettingsController controller;

  public JLabel endTimeLabel = new JLabel("End Time:");
  public JTextField endTimeText;
  public JLabel endPlayerLabel = new JLabel("Player Time:");
  public JTextField endPlayerText;

  public SettingsView(Settings settings) {
    this.settings = settings;
    
    controller = new SettingsController(settings, this);
    
    endTimeText = new JTextField(""+settings.getEndTime());
    endTimeText.addActionListener(e -> controller.setEndTime());
    endPlayerText = new JTextField(""+settings.getPlayerTime());
    endPlayerText.addActionListener(e -> controller.setPlayerTime());
    
    setLayout(new GridLayout(2, 2));
    add(endTimeLabel);
    add(endTimeText);
    add(endPlayerLabel);
    add(endPlayerText);
  }
}
