package mainstring.dev;

import mainstring.dev.Menu.*;
import mainstring.dev.UI.GUI.*;
/**
 * The Main class represents the entry point of the application.
 */
public class Main {
  private static MainFrame frame = new MainFrame();
  private static Menu menu = new Menu();
  /*
   * The main method is the entry point of the application.
   * 
   * @param args command-line arguments (not used in this application)
   */
  public static void main(String[] args) {
    menu.setStartGameFunction((e)->startGame());
    frame.add(new MenuGUI(menu));
    frame.revalidate();
  }

  public static void startGame(){
    frame.getContentPane().removeAll();
    frame.revalidate();
    frame.repaint();
    System.out.println("Hello");
  }
}
