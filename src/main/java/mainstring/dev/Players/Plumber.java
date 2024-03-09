package mainstring.dev.Players;

import mainstring.dev.Elements.ActiveElements.Pump;
import java.awt.event.*;

public class Plumber extends Player {
  Pump carryPump;

  public void fixPump(){ //used 
    // if(location instanceof Pump){
    //   ((Pump)location).fixPump();
    // }else if (location instanceof Cistern)){
    //   "You can't fix a cistern"
    // }else if (location instanceof Spring)) {
    //     You can't fix a spring"
    // }
  }
  public void fixPipe(){ //used
    //if(location.isConencted(grid.getSelectedPipe())){
    //    grid.getSelectedPipe.fixPipe()
    //  }
    //}else {
    //  "The pump is to far away"
    //}
  }
  public void connectPipe(){ //used
    /*
     * check if the Selected pipe is connected at the locatoin of player and
     * check that the selected pump is a neighbor of the location: 
     * if(isConnected(grid.getCurentPipe()) and location.isConencted(grid.getSelectedActiveElement)){
     *    connect the end at location of the selcted pipe ot the new selected pump
     *    location.removePipe(grid.getSelectedPipe());
     *    grid.getSelectedPump().connectPipe(grid.getSelectedPipe());
     *    move the player to the selected pump
     *    move()(grid.getSelectedActiveElement is in neighbors)) can also be checked here
     * }else{
     *    msg="Pipe is to far away" (maybe dialog box)
     * }
     * 
     */
    
  }
  public void insertPump(){
    /* 
     * Pipe selectedPipe = grid.getSelectedPipe();
     * if(carryPump!=null){
     *  if(location.isConencted(grid.getSelectedPipe())){
     *      Pipe newPipe = new Pipe();
     *      newPipe.addVertex(carryPump)
     *      AcitveElement theOtherVertex = selectdPipe.getTheOtherVertex(location)l
     *      newPipe.addVertex(theOtherVertex);
     *      carryPump.setInPipe(selectedPipe);
     *      carryPump.setOutPipe(newPipe);
     *      selectdPipe.removeVertex(theOtherVertex)
     *      selectdPipe.addVertex(carryPump)       
     *      carryPump=null;
     *  }
     * }else{
     *  "You don't have a Pump"
     * }
     */
  }
  public void pickPump(){
    // if (location instanceof Cistern)){
    //   carryPump = location.getPump();
    // }else {
    //    "You are not at the cistern"
    // }
  }
  public void keyTyped(KeyEvent e){
    //big stiwch 
    // e.getCharType()="c" -> connectPipe()
    // e.getCharType()="f" -> fixPump()
    // e.getCharType()="r" -> fixPipe()
    // d -> changePumpDirection()
    // i -> insertPump()
  }
} 
