package mainstring.dev;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

public class Model {
  List<Component> views = new ArrayList<>();
  public Component focusedView;


  public void updateViews() {
    for (var view : views) {
      view.invalidate();
      view.repaint();
    }
  }

  public void active() {
    focusedView.requestFocusInWindow();
  };

}
