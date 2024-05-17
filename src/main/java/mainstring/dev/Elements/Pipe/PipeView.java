package mainstring.dev.Elements.Pipe;

import java.awt.Graphics;
import java.awt.Graphics2D;
import mainstring.dev.Elements.Element.ElementView;


public class PipeView extends ElementView {
  Pipe pipe;
  String healthyImage = "/Images/pipe1.png";
  String brokenImage = "/Images/brokenpipe.png";
  

  public PipeView(Pipe pipe) {
    super(pipe, "/Images/pipe1.png");
    this.pipe = pipe;

  }

  //https://www.reddit.com/r/learnprogramming/comments/1xz70r/javahow_can_i_rotate_a_jpanel_i_found_one_way_to/
  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    int w2 = getWidth() / 2;
    int h2 = getHeight() / 2;
    g2d.rotate(-Math.PI / 4, w2, h2);
    super.paintComponent(g);
    g2d.dispose();
  }
}
