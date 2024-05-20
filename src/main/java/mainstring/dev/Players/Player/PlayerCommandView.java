package mainstring.dev.Players.Player;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Saboteur.Saboteur;

public class PlayerCommandView extends JPanel {

  public PlayerCommandView(Player player) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Set the layout to BoxLayout
    JLabel nameLabel = new JLabel(player.name) {{
      setFont(new Font("Arial", Font.BOLD, 30)); // Set the font to Arial, bold, size 30
    }};
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
      add(plumberCommands);
    } else if (player instanceof Saboteur) {
      JLabel saboteurCommands = new JLabel("<html>" +
        "changePump[D]irection()<br>" +
        "[m]ove<br>" +
        "[p]uncturePipe()" +
      "</html>");
      add(saboteurCommands);
    }
  }
}
