package Java;
import java.util.*;
public class Paragraph {
  private List<Elements> elements;
  Paragraph() {
    this.elements = new ArrayList<>();
  }
  public void addElements(Elements ele){
    elements.add(ele);

  }
  public StringBuilder render(StringBuilder sb){
    sb.append("paragraph").append('\n');
    for(Elements ele:elements){
      ele.render(sb);
    }
    return sb;
  }
}