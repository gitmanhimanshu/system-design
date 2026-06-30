package Java;
class Main{
  public static void main(String[] args) {
    Document d1=new Document("Document 1");
    Paragraph p1=new Paragraph();
    d1.addParagraph(p1);
    p1.addElements(new TextElement("himanhu"));
    p1.addElements(new ImageElement("i am image path"));
    d1.render();
    SaveStrategy server=new SaveinDB();
    server.save(d1);
  }
}