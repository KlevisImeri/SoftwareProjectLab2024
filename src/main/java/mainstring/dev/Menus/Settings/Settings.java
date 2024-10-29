package mainstring.dev.Menus.Settings;

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


  public int getEndTime() {
    return endTime;
  }

  public int getPlayerTime() {
    return playerTime;
  }

  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  public void setPlayerTime(int playerTime) {
    this.playerTime = playerTime;
  }

  @Override
  public String toString() {
    return "[Game Time: %s, Player Time: %s]".formatted(endTime,playerTime);
  }

}
