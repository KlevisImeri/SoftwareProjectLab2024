package mainstring.dev.Elements.Element;

import mainstring.dev.JImage;

public class ElementView extends JImage {
  Element element;
  ElementController controller;

  public ElementView(Element element, String image) {
    super(image);
    this.element = element;
    controller = new ElementController(element, this);
  }
}
