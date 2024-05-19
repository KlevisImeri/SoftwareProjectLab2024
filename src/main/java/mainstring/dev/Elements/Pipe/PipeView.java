package mainstring.dev.Elements.Pipe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import mainstring.dev.Elements.Element.ElementView;
import mainstring.dev.Grid.GridView;
import mainstring.dev.Players.Player.PlayerView;


public class PipeView extends ElementView {
  Pipe pipe;
  String healthyImage = "/Images/pipe1.png";
  String brokenImage = "/Images/brokenpipe.png";

  public PipeView(Pipe pipe, GridView gridView) {
    super(pipe, "/Images/pipe1.png", gridView);
    this.pipe = pipe;
    setPreferredSize(new Dimension(400, 200));
    setSize(getPreferredSize());
    setImageSize(getPreferredSize());
    
    new PipeController(pipe, this);
  }

  //https://www.reddit.com/r/learnprogramming/comments/1xz70r/javahow_can_i_rotate_a_jpanel_i_found_one_way_to/
  @Override
  public void paint(Graphics g) {
  
    Dimension d1  = neighborViews.get(0).getSize();
    Dimension d2  = neighborViews.get(1).getSize();
    Point p1 = neighborViews.get(0).getLocation();
    Point p2 = neighborViews.get(1).getLocation();
    

    p1.setLocation(p1.getX()+d1.getWidth()/2, p1.getY()+d1.getHeight()/2);
    p2.setLocation(p2.getX()+d2.getWidth()/2, p2.getY()+d2.getHeight()/2);
    double dx = p2.getX() - p1.getX();
    double dy = p2.getY() - p1.getY();
    double dis = Math.sqrt(dx*dx + dy*dy);

    // Padding is needed so when the size becomes small, the image which has 40 width
    // doesn't disappera becuause the saize fo the panel is [0,0].
    int padding = 70;
    setSize((int) Math.abs(dx)+padding, (int)(Math.abs(dy))+padding); 
    setLocation(
      (int)((p1.getX() + p2.getX())/2 - getWidth()/2),
      (int)((p1.getY() + p2.getY())/2 - getHeight()/2)
    );
    setImageSize((int)dis, 40);
    setImageLocation(0,getHeight()/2-20);

    
    Graphics2D g2d = (Graphics2D) g;
    double angle = Math.atan2(dy, dx);
    int w2 = getWidth() / 2;
    int h2 = getHeight() / 2;
    g2d.rotate(angle, w2, h2);
    
    super.paint(g);
    
    g2d.dispose();
  }
}
