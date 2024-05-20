package mainstring.dev.Menus.Settings;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * The SettingsController class is responsible for handling changes to the settings.
 * It implements the DocumentListener interface to respond to changes in the settings view.
 */
public class SettingsController implements DocumentListener {

  // The Settings instance being controlled.
  private Settings settings;

  // The view associated with the settings.
  private SettingsView view;

  /**
   * Constructs a SettingsController with the specified Settings and SettingsView.
   * Adds this controller as a document listener to the relevant text fields in the view.
   *
   * @param settings the Settings to control
   * @param view the SettingsView associated with the Settings
   */
  public SettingsController(Settings settings, SettingsView view) {
    this.settings = settings;
    this.view = view;

    // Add document listeners to the end time and player time text fields.
    view.endTimeText.getDocument().addDocumentListener(this);
    view.endPlayerText.getDocument().addDocumentListener(this);
  }

  /**
   * Updates the end time setting based on the text field input.
   */
  private void setEndTime() {
    try {
      int newEndTime = Integer.parseInt(view.endTimeText.getText());
      settings.setEndTime(newEndTime);
    } catch (NumberFormatException e) {
        // Handle the exception silently, as it indicates invalid input.
    }
  }

  /**
   * Updates the player time setting based on the text field input.
   */
  private void setPlayerTime() {
    try {
      int newPlayerTime = Integer.parseInt(view.endPlayerText.getText());
      settings.setPlayerTime(newPlayerTime);
    } catch (NumberFormatException e) {
        // Handle the exception silently, as it indicates invalid input.
    }
  }

   /**
   * Called when text is inserted into the document.
   * 
   * @param e the document event
   */
  @Override
  public void insertUpdate(DocumentEvent e) {
    updateSettings(e);
  }

  /**
   * Called when text is removed from the document.
   * 
   * @param e the document event
   */
  @Override
  public void removeUpdate(DocumentEvent e) {
    updateSettings(e);
  }

  /**
   * Called when the document's attributes are changed.
   * This is usually not needed for plain text fields.
   * 
   * @param e the document event
   */
  @Override
  public void changedUpdate(DocumentEvent e) {
    // Usually not needed for plain text fields
  }

  /**
   * Updates the settings based on the document event.
   * 
   * @param e the document event
   */
  private void updateSettings(DocumentEvent e) {
    if (e.getDocument() == view.endTimeText.getDocument()) {
      setEndTime();
    } else if (e.getDocument() == view.endPlayerText.getDocument()) {
      setPlayerTime();
    }
  }
}
