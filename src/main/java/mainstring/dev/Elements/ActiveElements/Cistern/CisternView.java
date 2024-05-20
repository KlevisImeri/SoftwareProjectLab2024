package mainstring.dev.Elements.ActiveElements.Cistern;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import mainstring.dev.Elements.ActiveElements.ActiveElement.ActiveElementView;
import mainstring.dev.Elements.ActiveElements.Pump.PumpView;
import mainstring.dev.Elements.Pipe.PipeView;
import mainstring.dev.Grid.GridView;
import mainstring.dev.Players.Plumber.Plumber;
import mainstring.dev.Players.Plumber.PlumberView;
import mainstring.dev.Players.Saboteur.Saboteur;
import mainstring.dev.Players.Saboteur.SaboteurView;

public class CisternView extends ActiveElementView {
  Cistern cistern;

  public CisternView(Cistern cistern, GridView gridView) {
    super(cistern, "/Images/cistern.png", gridView);
    this.cistern = cistern;
    setPreferredSize(new Dimension(300,200));
    setSize(getPreferredSize());
    setImageSize(getPreferredSize());
  }

  @Override
  public void paintComponent(Graphics g) {
    removeAll();
    
    for(var pipe : cistern.newPipes) {
      add(new PipeView(pipe, gridView));
    }

    for(var pumps : cistern.newPumps) {
      add(new PumpView(pumps, gridView));
    }
    super.paintComponent(g);
  }
}
