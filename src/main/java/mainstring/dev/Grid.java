package mainstring.dev;

import java.util.List;
import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Elements.*;

public class Grid {
  //Fields
  Cistern cistern = new Cistern();
  Spring spring = new Spring();
  List<Pump> pumps; //here the pipes are also stored
  int waterInDesert;
  Pipe selectedPipe;
  ActiveElement selectedActiveElement;
  
  
  public void setSelectedPipe(Pipe pipe){} //used
  public void getSelectedPipe(){} //used
  public void setSelectedActiveElement(ActiveElement activeElement){} //used
  public void getSelectedActiveElement(){} //used
  public void caculateFlow(){
    
  }
} 