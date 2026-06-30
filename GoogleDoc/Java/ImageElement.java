package Java;
public class ImageElement implements Elements {
  private String path;

  public ImageElement(String path) {
    this.path = path;
  }
  @Override
  public void render(StringBuilder sb){
    sb.append("Image ").append(path);
  }
}
