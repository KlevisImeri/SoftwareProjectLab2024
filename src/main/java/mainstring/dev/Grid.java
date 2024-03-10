package mainstring.dev;

import java.util.List;
import mainstring.dev.Elements.ActiveElements.*;
import mainstring.dev.Elements.*;

public class Grid {
  // Fieldsp
  private List<ActiveElement> activeElements; // here the pipes are also stored

  private int waterInDesert=0;

  private Element selectedElement;
  private ActiveElement selectedActiveElement;
  private Pipe selectedPipe;
  private Pump selectedPump;

  public Grid(){
    activeElements.add(new Spring());
    activeElements.add(new Cistern());
  }

  public Element getSelectedElement() {
    return selectedElement;
  }

  public void setSelectedElement(Element selectedElement) {
    this.selectedElement = selectedElement;
  }

  public ActiveElement getSelectedActiveElement() {
    return selectedActiveElement;
  }

  public void setSelectedActiveElement(ActiveElement selectedActiveElement) {
    this.selectedElement = selectedActiveElement;
    this.selectedActiveElement = selectedActiveElement;
  }

  public Pipe getSelectedPipe() {
    return selectedPipe;
  }

  public void setSelectedPipe(Pipe selectedPipe) {
    this.selectedElement = selectedPipe;
    this.selectedPipe = selectedPipe;
  }

  public Pump getSelectedPump() {
    return selectedPump;
  }

  public void setSelectedPump(Pump selectedPump) {
    this.selectedElement = selectedPump;
    this.selectedActiveElement = selectedPump;
    this.selectedPump = selectedPump;
  }

  public void addPump(Pump pump){
    activeElements.add(pump);
  }


  public void addWaterToDesert(){
    this.waterInDesert++;
  }
}
