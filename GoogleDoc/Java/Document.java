package Java;
import java.util.*;
import Java.User.User;

public class Document {
  private List<Paragraph>paragraphs;
  private String title;
  private User owner;
  private List<User> collaborators;
  Document(String title) {
    this.title = title;
    this.paragraphs = new ArrayList<>();
    this.owner = null;
    this.collaborators = new ArrayList<>();
  }
  public void addParagraph(Paragraph paragraph) {

      this.paragraphs.add(paragraph);
    
    
  }
  public void render(User user){
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
  public User getOwner(){
    return this.owner;
  }
  public boolean addCollaborators(User user) {

      this.collaborators.add(user);
      return true;

  }
  public List<User> getCollaborators(){
    return this.collaborators;
  }
  public boolean setOwner(User user) {

      this.owner = user;
      return true;
    
   
  }
}
