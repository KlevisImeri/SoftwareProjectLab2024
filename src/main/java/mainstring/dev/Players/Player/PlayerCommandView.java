package mainstring.dev.Players.Player;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Saboteur.Saboteur;

public class PlayerCommandView extends JPanel {

  public PlayerCommandView(Player player) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Set the layout to BoxLayout

    add(new JLabel(player.name) {{
      // Set the font here, if needed
    }});

    if (player instanceof Plumber) {
      add(new JLabel("<html>" +
        "[m]ove<br>" +
        "changePump[D]irection()<br>" +
        "[d]isconnectPipe()<br>" +
        "[c]onnectPipe()<br>" +
        "[f]ix()<br>" +
        "[i]nsertPump()<br>" +
        "[p]ickPump()<br>" +
        "[P]ickPipe()" +
      "</html>"));
    } else if (player instanceof Saboteur) {
      add(new JLabel("<html>" +
        "changePump[D]irection()<br>" +
        "[m]ove<br>" +
        "[p]uncturePipe()" +
      "</html>"));
    }
  }
}
