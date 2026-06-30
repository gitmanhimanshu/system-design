package Java;
import java.util.*;
public class Document {
  private List<Paragraph>paragraphs;
  private String title;
  Document(String title) {
    this.title = title;
    this.paragraphs = new ArrayList<>();
  }
  public void addParagraph(Paragraph paragraph) {
    this.paragraphs.add(paragraph);
  }
  public void render(){
    StringBuilder sb=new StringBuilder();
    sb.append("title: ").append(title).append("\n");
    for(Paragraph paragraph: paragraphs) {
      paragraph.render(sb);
    }
    System.out.println(sb.toString());
  }

  public String getTitle() {
    return title;
  }
}
