package mainstring.dev.Elements.Element;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.LineBorder;
import mainstring.dev.JImage;
import mainstring.dev.Grid.GridView;
import mainstring.dev.Players.Player.PlayerView;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Plumber.PlumberView;
import mainstring.dev.Players.Saboteur.Saboteur;
import mainstring.dev.Players.Saboteur.SaboteurView;

public class ElementView extends JImage {
  Element element;
  ElementController controller;
  public List<PlayerView> playerViews = new ArrayList<>();
  public List<ElementView> neighborViews = new ArrayList<>();
  public GridView gridView;
  protected GridBagConstraints gbc;

  public ElementView(Element element, String image, GridView gridView) {
    super(image);
    this.gridView = gridView;
    this.element = element;
    controller = new ElementController(element, this);

    setLayout(new GridBagLayout());
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 0.0;
    gbc.weighty = 0.0;
    gbc.anchor = GridBagConstraints.CENTER;

    for (Plumber plumber : element.players.getPlumbers()) {
      PlumberView plumberView = new PlumberView(plumber, this);
      add(plumberView, gbc);
      gbc.gridx++;
      playerViews.add(plumberView);
    }

    for (Saboteur saboteur : element.players.getSaboteurs()) {
      SaboteurView saboteurView = new SaboteurView(saboteur, this);
      add(saboteurView, gbc);
      gbc.gridx++;
      playerViews.add(saboteurView);
    }

    
  }

  public void addNeighborView(ElementView elemView) {
    neighborViews.add(elemView);
    elemView.neighborViews.add(this);
  }

}
