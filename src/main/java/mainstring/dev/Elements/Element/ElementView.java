package mainstring.dev.Elements.Element;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import mainstring.dev.JImage;
import mainstring.dev.Players.Player.PlayerView;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Plumber.PlumberView;
import mainstring.dev.Players.Saboteur.Saboteur;
import mainstring.dev.Players.Saboteur.SaboteurView;

public class ElementView extends JImage {
  Element element;
  ElementController controller;
  List<PlayerView> playerViews = new ArrayList<>();

  public ElementView(Element element, String image) {
    super(image);
    this.element = element;
    controller = new ElementController(element, this);


    for (Plumber plumber : element.players.getPlumbers()) {
      add(new PlumberView(plumber){{
        setPreferredSize(new Dimension(30, 20));
      }});
    }

    // for (Saboteur saboteur : element.players.getSaboteurs()) {
    //   add(new SaboteurView(saboteur));
    // }

  }
}
