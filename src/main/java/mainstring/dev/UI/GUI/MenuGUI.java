package mainstring.dev.UI.GUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;

public class MenuGUI {
  JButton newGameButton = new JButton();
  JButton settingsButton = new JButton();

  public MenuGUI(ActionListener x, ActionListener y) {
    newGameButton.addActionListener(x);
    settingsButton.addActionListener(y);
  }
}
