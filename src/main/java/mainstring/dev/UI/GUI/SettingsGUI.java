package mainstring.dev.UI.GUI;

import mainstring.dev.Menu.Settings;
import javax.swing.*;
import java.awt.Container;

public class SettingsGUI extends JPanel {
    private Settings settings;
    JLabel endTimeLabel = new JLabel("End Time (minutes):");
    JTextField endTimeField;
    JLabel playerTimeLabel = new JLabel("Player Time (seconds):");
    JTextField playerTimeField;
    JLabel pipeCapacityLabel = new JLabel("Pipe Capacity:");
    JTextField pipeCapacityField;
    JButton closeSettingsButton = new JButton("Close");

    public SettingsGUI(Settings settings) {
        this.settings = settings;

        setLabels();
    
        add(endTimeLabel);
        add(endTimeField);
        add(playerTimeLabel);
        add(playerTimeField);
        add(pipeCapacityLabel);
        add(pipeCapacityField);
        closeSettingsButton.addActionListener((e)->{
          Container parent = getParent();
          parent.remove(SettingsGUI.this);
          parent.revalidate();
          parent.repaint();
          
          settings.endTime = Integer.parseInt(endTimeField.getText());
          settings.playerTime = Integer.parseInt(playerTimeField.getText());
          settings.pipeCapacity = Integer.parseInt(pipeCapacityField.getText());
        });
        add(closeSettingsButton);
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
