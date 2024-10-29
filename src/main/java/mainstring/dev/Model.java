package mainstring.dev;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * This class manages a collection of {@link Component} objects, providing functionality to update,
 * focus, and manage these components.
 */
public class Model {

  /**
   * A list to hold {@link Component} objects that this model manages.
   */
  private List<Component> views = new ArrayList<>();

  /**
   * The currently focused {@link Component} within this model.
   */
  private Component focusedView;

  /**
   * Updates all managed {@link Component} objects by invalidating and repainting them.
   * This method ensures that all components are refreshed on the screen.
   */
  public void updateViews() {
    for (var view : views) {
      view.invalidate();
      view.repaint();
    }
  }

  /**
   * Requests focus for the currently focused {@link Component}.
   * This method is typically called after setting a component as the focused view.
   */
  public void active() {
    focusedView.requestFocusInWindow();
  }

  /**
   * Adds a {@link Component} to the list of managed components.
   *
   * @param view The {@link Component} to be added.
   */
  public void addView(Component view) {
    views.add(view);
  }

  /**
   * Sets a {@link Component} as the focused view.
   * After calling this method, subsequent calls to {@code active()} will request focus for this component.
   *
   * @param view The {@link Component} to be set as the focused view.
   */
  public void setFocusable(Component view) {
    focusedView = view;
  }
}
