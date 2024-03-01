package mainstring.dev.Menu;

import java.awt.event.ActionEvent;
import mainstring.dev.UI.GUI.MenuGUI;

public class Menu {
  MenuGUI gui = new MenuGUI((ActionEvent e)->startGame(), (ActionEvent e)->changeSettings());
  Settings Settings = new Settings();


  void startGame(){}
  void changeSetting(){}
}
