package mainstring.dev.Players.Player;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Saboteur.Saboteur;

public class PlayerCommandView extends JPanel {

  public PlayerCommandView(Player player) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Set the layout to BoxLayout
    setBackground(Color.BLACK); // Set the background color of the panel
    setOpaque(true); // Make sure the panel is opaque

    JLabel nameLabel = new JLabel(player.name);
    nameLabel.setForeground(new Color(247, 154, 96)); // Set the font color for the name label
    add(nameLabel);

    if (player instanceof Plumber) {
      JLabel plumberCommands = new JLabel("<html>" +
        "[m]ove<br>" +
        "changePump[D]irection()<br>" +
        "[d]isconnectPipe()<br>" +
        "[c]onnectPipe()<br>" +
        "[f]ix()<br>" +
        "[i]nsertPump()<br>" +
        "[p]ickPump()<br>" +
        "[P]ickPipe()" +
      "</html>");
      plumberCommands.setForeground(Color.BLUE); // Set the font color for the plumber commands
      add(plumberCommands);
    } else if (player instanceof Saboteur) {
      JLabel saboteurCommands = new JLabel("<html>" +
        "changePump[D]irection()<br>" +
        "[m]ove<br>" +
        "[p]uncturePipe()" +
      "</html>");
      saboteurCommands.setForeground(Color.RED); // Set the font color for the saboteur commands
      add(saboteurCommands);
    }
  }
}
