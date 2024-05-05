package mainstring.dev.Controller;

import mainstring.dev.Controller.Menu.MenuController;
import mainstring.dev.Model.Game;
import mainstring.dev.View.GameView;

public class GameController {
  Game game;
  GameView view;

  public GameController(Game game, GameView view) {
    view.game = game;

    new MenuController(game.getMenu(), view.menuView);

    this.game = game;
    this.view = view;
  }


}
