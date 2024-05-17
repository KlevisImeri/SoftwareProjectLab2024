package mainstring.dev.Menus.Settings;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class SettingsView extends JPanel {
  Settings settings;
  SettingsController controller;
  public ImageIcon backgroundImage;
  Dimension buttonSize = new Dimension(200, 50);

  public JLabel endTimeLabel = new JLabel("End Time:") {{
        setFont(new Font("Arial", Font.BOLD, 30));
        setForeground(Color.BLACK); 
    }};
    public JTextField endTimeText = new JTextField() {{
        setFont(new Font("Arial", Font.PLAIN, 30));
        setForeground(Color.BLACK);
        setBackground(Color.LIGHT_GRAY);
        setBorder(new LineBorder(Color.BLACK, 1));
        setPreferredSize(new Dimension(200, 40));
    }};
    public JLabel endPlayerLabel = new JLabel("Player Time:") {{
        setFont(new Font("Arial", Font.BOLD, 30));
        setForeground(Color.BLACK); 
    }};
    public JTextField endPlayerText = new JTextField() {{
        setFont(new Font("Arial", Font.PLAIN, 30));
        setForeground(Color.BLACK);
        setBackground(Color.LIGHT_GRAY);
        setBorder(new LineBorder(Color.BLACK, 1));
        setPreferredSize(new Dimension(200, 40));
    }};
    public JPanel settingsPanel = new JPanel(new GridLayout(2, 2, 20, 20)) {{
        add(endTimeLabel);
        add(endTimeText);
        add(endPlayerLabel);
        add(endPlayerText);
        setMaximumSize(getPreferredSize());
        setOpaque(false); // Make panel transparent
    }};
    public JButton backButton = new JButton("Back") {{
        setPreferredSize(buttonSize);
        setBackground(Color.YELLOW);
    }};

  public SettingsView(Settings settings) {
    this.settings = settings;
    
    controller = new SettingsController(settings, this);

    // Load background image
    backgroundImage = new ImageIcon(getClass().getResource("/Images/desertBackground.png"));
    
    endTimeText.setText(""+settings.getEndTime());
    endTimeText.addActionListener(e -> controller.setEndTime());
    endPlayerText.setText(""+settings.getPlayerTime());
    endPlayerText.addActionListener(e -> controller.setPlayerTime());
  
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
    // Custom panel with background image
    JPanel backgroundPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    };
    backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

    backgroundPanel.add(Box.createVerticalStrut(80)); // Add a vertical strut at the top to move components higher
    backgroundPanel.add(settingsPanel);
    backgroundPanel.add(Box.createVerticalStrut(50));
    backgroundPanel.add(backButton);
    backgroundPanel.add(Box.createVerticalGlue());

    add(backgroundPanel);
  }
}
