package mainstring.dev.Menus.Settings;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class SettingsView extends JPanel {
  Settings settings;
  SettingsController controller;
  public ImageIcon backgroundImage;
  Dimension buttonSize = new Dimension(200, 50);

  public JLabel titleLabel = new JLabel("Setting") {{
    setFont(new Font("Arial", Font.BOLD, 80));
    setForeground(new Color(247, 154, 96));
    setAlignmentX(CENTER_ALIGNMENT); // Center the title horizontally
}};

  public JLabel endTimeLabel = new JLabel("End Time:") {{
        setFont(new Font("Arial", Font.BOLD, 30));
        setForeground(new Color(247, 154, 96)); 
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
        setForeground(new Color(247, 154, 96)); 
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
        setOpaque(false); 
    }};
    public JButton backButton = new JButton("Back") {{
        setPreferredSize(buttonSize);
        setBackground(new Color(247, 154, 96));
        setFont(new Font("Arial", Font.BOLD, 16));
    }};

  public SettingsView(Settings settings) {
    this.settings = settings;
    
    controller = new SettingsController(settings, this);

    backgroundImage = new ImageIcon(getClass().getResource("/Images/desertBackground.png"));
    
    endTimeText.setText(""+settings.getEndTime());
    endTimeText.addActionListener(e -> controller.setEndTime());
    endPlayerText.setText(""+settings.getPlayerTime());
    endPlayerText.addActionListener(e -> controller.setPlayerTime());
  
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    JPanel backgroundPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    };
    backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

    JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)) {{
        setOpaque(false);
        add(backButton);
    }};

    backgroundPanel.add(Box.createVerticalStrut(50)); 
    backgroundPanel.add(titleLabel);
    backgroundPanel.add(Box.createVerticalStrut(30)); 
    backgroundPanel.add(settingsPanel);
    backgroundPanel.add(Box.createVerticalStrut(50));
    backgroundPanel.add(backButtonPanel);
    backgroundPanel.add(Box.createVerticalGlue());

    add(backgroundPanel);
  }
}
