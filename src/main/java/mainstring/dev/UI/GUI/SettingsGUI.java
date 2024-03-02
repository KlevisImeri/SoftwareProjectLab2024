package mainstring.dev.UI.GUI;

import mainstring.dev.Menu.Settings;
import javax.swing.*;

public class SettingsGUI extends JPanel {
    private Settings settings;
    JLabel endTimeLabel = new JLabel("End Time (minutes):");
    JTextField endTimeField;
    JLabel playerTimeLabel = new JLabel("Player Time (seconds):");
    JTextField playerTimeField;
    JLabel pipeCapacityLabel = new JLabel("Pipe Capacity:");
    JTextField pipeCapacityField;

    public SettingsGUI(Settings settings) {
        this.settings = settings;

        setLabels();
        
        add(endTimeLabel);
        add(endTimeField);
        add(playerTimeLabel);
        add(playerTimeField);
        add(pipeCapacityLabel);
        add(pipeCapacityField);
      }
      
      private void setLabels(){
        endTimeField = new JTextField(Integer.toString(settings.endTime), 5);
        endTimeField.addActionListener((e)->settings.endTime = Integer.parseInt(endTimeField.getText()));
  
        playerTimeField = new JTextField(Integer.toString(settings.playerTime), 5);
        playerTimeField.addActionListener((e)->settings.playerTime = Integer.parseInt(playerTimeField.getText()));
  
        pipeCapacityField = new JTextField(Integer.toString(settings.pipeCapacity), 5);
        pipeCapacityField.addActionListener((e)->settings.pipeCapacity = Integer.parseInt(pipeCapacityField.getText()));
    }
}
