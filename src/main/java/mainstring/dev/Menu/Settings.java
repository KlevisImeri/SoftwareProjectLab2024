package mainstring.dev.Menu;

import java.util.HashMap;
import java.util.Map;

/**
 * The Settings class stores and manages game settings, specifically end time and player time. It
 * allows for the retrieval and updating of these settings.
 */
public class Settings {
  /**
   * The end time of the game in minutes.
   */
  private int endTime = 5; // Default value is 5 minutes.

  /**
   * The time allocated to each player in seconds.
   */
  private int playerTime = 30; // Default value is 30 seconds.

  @Override
  public String toString() {
    return "[Game Time: %s, Player Time: %s]".formatted(endTime,playerTime);
  }
  /**
   * Updates the game settings for end time and player time.
   * 
   * @param endTime The new end time to be set, in minutes.
   * @param playerTime The new player time to be set, in seconds.
   */
  public void setSettings(int endTime, int playerTime) {
    this.endTime = endTime;
    this.playerTime = playerTime;
  }

  /**
   * Retrieves the current game settings, including end time and player time.
   * 
   * @return A Map containing the keys "endTime" and "playerTime" along with their respective
   *         integer values.
   */
  public Map<String, Integer> getSettings() {
    Map<String, Integer> settings = new HashMap<>();
    settings.put("endTime", endTime);
    settings.put("playerTime", playerTime);
    return settings;
  }
}
