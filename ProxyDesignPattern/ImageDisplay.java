package ProxyDesignPattern;

public class ImageDisplay implements IImage {
    String fileName;
    
    public ImageDisplay(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}
