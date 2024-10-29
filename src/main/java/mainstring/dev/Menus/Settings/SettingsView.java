package mainstring.dev.Menus.Settings;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * The SettingsView class extends JPanel to provide the user interface
 * for adjusting game settings. It includes fields for setting the end time
 * and player time, and a back button to return to the previous menu.
 */
public class SettingsView extends JPanel {
  // The Settings instance being represented by this view.
  Settings settings;

  // The background image for the settings view.
  public ImageIcon backgroundImage;
  // Dimensions for the buttons.
  Dimension buttonSize = new Dimension(200, 50);

  // Title label for the settings view.
  public JLabel titleLabel = new JLabel("Setting") {{
    setFont(new Font("Arial", Font.BOLD, 80));
    setForeground(new Color(247, 154, 96));
    setAlignmentX(CENTER_ALIGNMENT); // Center the title horizontally
  }};

  // Label and text field for setting the end time.
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

    // Label and text field for setting the player time.
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

    // Panel to hold the settings components.
    public JPanel settingsPanel = new JPanel(new GridLayout(2, 2, 20, 20)) {{
        add(endTimeLabel);
        add(endTimeText);
        add(endPlayerLabel);
        add(endPlayerText);
        setMaximumSize(getPreferredSize());
        setOpaque(false); 
    }};

    // Back button to return to the previous menu.
    public JButton backButton = new JButton("Back") {{
        setPreferredSize(buttonSize);
        setBackground(new Color(247, 154, 96));
        setFont(new Font("Arial", Font.BOLD, 16));
    }};

  /**
   * Constructs a SettingsView with the specified Settings.
   * Initializes the UI components and sets up the layout.
   *
   * @param settings the Settings to be represented by this view
   */
  public SettingsView(Settings settings) {
    this.settings = settings;
    
    // Load the background image.
    backgroundImage = new ImageIcon(getClass().getResource("/Images/desertBackground.png"));
    
    // Set the initial values for the text fields from the settings.
    endTimeText.setText(""+settings.getEndTime());
    endPlayerText.setText(""+settings.getPlayerTime());
  
    // Set the layout for the settings view.
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    // Create a panel to hold the background image.
    JPanel backgroundPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    };
    backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

    // Create a panel to hold the back button.
    JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)) {{
        setOpaque(false);
        add(backButton);
    }};

    // Add the components to the background panel with spacing.
    backgroundPanel.add(Box.createVerticalStrut(50)); 
    backgroundPanel.add(titleLabel);
    backgroundPanel.add(Box.createVerticalStrut(30)); 
    backgroundPanel.add(settingsPanel);
    backgroundPanel.add(Box.createVerticalStrut(50));
    backgroundPanel.add(backButtonPanel);
    backgroundPanel.add(Box.createVerticalGlue());

    // Add the background panel to the main panel.
    add(backgroundPanel);

    // Initialize the controller for this view.
    new SettingsController(settings, this);
  }
}
