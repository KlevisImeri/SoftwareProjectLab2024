package mainstring.dev.Menus.Settings;


import javax.swing.*;
import java.awt.*;


public class SettingsView extends JPanel {
  Settings settings;
  SettingsController controller;

  public JLabel endTimeLabel = new JLabel("End Time:");
  public JTextField endTimeText = new JTextField();
  public JLabel endPlayerLabel = new JLabel("Player Time:");
  public JTextField endPlayerText = new JTextField();
  public JPanel settingsPanel = new JPanel(new GridLayout(2, 2, 10, 10)) {{
    add(endTimeLabel);
    add(endTimeText);
    add(endPlayerLabel);
    add(endPlayerText);
    setMaximumSize(getPreferredSize());
  }};
  public JButton backButton = new JButton("Back"){{
    setAlignmentX(Component.CENTER_ALIGNMENT);
    setBackground(Color.lightGray);
  }};

  public SettingsView(Settings settings) {
    this.settings = settings;
    
    controller = new SettingsController(settings, this);
    
    endTimeText.setText(""+settings.getEndTime());
    endTimeText.addActionListener(e -> controller.setEndTime());
    endPlayerText.setText(""+settings.getPlayerTime());
    endPlayerText.addActionListener(e -> controller.setPlayerTime());
  
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
    
    add(Box.createVerticalGlue()); 
    add(settingsPanel);
    add(Box.createVerticalStrut(10));
    add(backButton);
    add(Box.createVerticalGlue()); 
  }
}
