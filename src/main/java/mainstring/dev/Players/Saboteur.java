package mainstring.dev.Players;

import mainstring.dev.Elements.Pipe;

public class Saboteur extends Player {
  public void puncturePipe(){
    if(location instanceof Pipe){
      ((Pipe)location).puncture();
    }else{
      System.out.println("You can only punctire Pipes!");
    }
  }
}
