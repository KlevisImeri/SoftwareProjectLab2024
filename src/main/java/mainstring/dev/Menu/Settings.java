package mainstring.dev.Menu;

import java.util.HashMap;
import java.util.Map;

public class Settings {
  private int endTime = 5; // minutes
  private int playerTime = 30; // secound

  public void setSettings(int endTime, int playerTime) {
    System.out.println("setSettings(" + endTime + "," + playerTime + ")");
    this.endTime = endTime;
    this.playerTime = playerTime;
  }

  public Map<String, Integer> getSettings() {
    System.out.println("getSettings()");
    Map<String, Integer> settings = new HashMap<>();
    settings.put("endTime", endTime);
    settings.put("playerTime", playerTime);
    return settings;
  }
}
