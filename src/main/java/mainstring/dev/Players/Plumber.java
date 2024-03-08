package mainstring.dev.Players;

public class Plumber extends Player {
  public void fixBrokenPump(){
    if(location.isPump()){
      pump.fixPump();
    }
  }
  public void repairLeakingPipe(){}
  public void connectPipe(){}
  public void insertPump(){
    /*
     * Pump pipe = grid.cister.getPump();
     * Slected pipe = gird.selecteedpipe;
     * chekc if selected pipe can be reached:
     * if pipe is in location.getpipes{
     *   pipe.gettheothervertex.
     *   create a new pipe.
     *   set the end and start vetices accordingly
     *   grid.addPump();
     * }
     */
  }
  public void changePumpInAndOutPipe(){}
} 
