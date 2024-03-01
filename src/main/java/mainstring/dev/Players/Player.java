package mainstring.dev.Players;

import mainstring.dev.Elements.ActiveElements.ActiveElement;

public abstract class Player {
  int ID;
  protected String name;
  protected ActiveElement location;

  public Player(String name, ActiveElement location, int ID) {
    this.name = name;
    this.location = location;
    this.ID = ID;
  }


  // Abstract method for moving the player to a new location on the game map.
  public void moveToLocation(ActiveElement newLocation) {
    this.location = newLocation;
  }
  // Method for changing the direction of a pump
  public void changePumpDirection(ActiveElement pump){}
  public void endGame(){}




  // Getters and setters for name and location
  // public String getName() {
  //   return name;
  // }

  // public ActiveElement getLocation() {
  //   return location;
  // }

  // public void setLocation(ActiveElement location) {
  //   this.location = location;
  // }

}
