package Java;

import Java.User.Role;
import Java.PermissionChecker.PermissionChecker;
import Java.User.Admin;
import Java.User.Editor;
import Java.User.User;

class Main{
  public static void main(String[] args) {
    Document d1=new Document("Document 1");
    Paragraph p1=new Paragraph();
    PermissionChecker permission=new PermissionChecker();
    User owner=new User("John Doe", "john.doe@example.com", "1", new Admin());
    d1.addParagraph(p1);
    d1.setOwner(owner);
    if(permission.canEdit(owner)) {
      p1.addElements(new TextElement("himanhu"));
      p1.addElements(new ImageElement("i am image path"));
    }
    if(permission.canView(owner)) {
      d1.render(owner);
    }
    SaveStrategy server=new SaveinDB();
    server.save(d1);
  }
}