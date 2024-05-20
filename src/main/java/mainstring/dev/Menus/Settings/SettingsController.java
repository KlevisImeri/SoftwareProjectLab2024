package mainstring.dev.Menus.Settings;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SettingsController implements DocumentListener {
  private Settings settings;
  private SettingsView view;



  public SettingsController(Settings settings, SettingsView view) {
    this.settings = settings;
    this.view = view;

    view.endTimeText.getDocument().addDocumentListener(this);
    view.endPlayerText.getDocument().addDocumentListener(this);
  }

  private void setEndTime() {
    try {
      int newEndTime = Integer.parseInt(view.endTimeText.getText());
      settings.setEndTime(newEndTime);
    } catch (NumberFormatException e) {
    }
  }

  private void setPlayerTime() {
    try {
      int newPlayerTime = Integer.parseInt(view.endPlayerText.getText());
      settings.setPlayerTime(newPlayerTime);
    } catch (NumberFormatException e) {
    }
  }

  @Override
  public void insertUpdate(DocumentEvent e) {
    updateSettings(e);
  }

  @Override
  public void removeUpdate(DocumentEvent e) {
    updateSettings(e);
  }

  @Override
  public void changedUpdate(DocumentEvent e) {
    // Usually not needed for plain text fields
  }

  private void updateSettings(DocumentEvent e) {
    if (e.getDocument() == view.endTimeText.getDocument()) {
      setEndTime();
    } else if (e.getDocument() == view.endPlayerText.getDocument()) {
      setPlayerTime();
    }
  }
}
