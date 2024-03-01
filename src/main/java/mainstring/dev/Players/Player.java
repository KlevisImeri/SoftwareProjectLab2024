package mainstring.dev.Players;

import mainstring.dev.Elements.ActiveElements.ActiveElement;

public abstract class Player {

    public enum Role {
        PLUMBER, SABOTEUR
    }

    protected String name;
    protected ActiveElement location;
    protected Role role;

    public Player(String name, ActiveElement location, Role role) {
        this.name = name;
        this.location = location;
        this.role = role;
    }

    // Method for changing game settings
    public abstract void changeSettings();

    // Method to start the game. This initializes player positions and set the game state to active.
    public abstract void startGame();

    // Method to select teams. Players Are assigned to either the Plumbers or the Saboteurs
    public abstract void selectTeams();

    // Abstract method for moving the player to a new location on the game map.
    public abstract void move(ActiveElement newLocation);

    // Method for changing the direction of a pump
    public abstract void changePumpDirection(ActiveElement pump);

    // This trigger the calculation of the final score and clean up the game state.
    // - Or just the player exits the game
    public abstract void endGame();

    // Getters and setters for name and location
    public String getName() {
        return name;
    }

    public ActiveElement getLocation() {
        return location;
    }

    public void setLocation(ActiveElement location) {
        this.location = location;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
