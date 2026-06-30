package Java;
public class TextElement implements Elements {
  private String text;
  TextElement(String text) {
    this.text = text;
  }

  @Override
  public void render(StringBuilder sb){
      sb.append("text ").append(text);
  }
}