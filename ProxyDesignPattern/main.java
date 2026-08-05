package ProxyDesignPattern;

public class main {
    public static void main(String[] args) {
        IImage image1 = new ImageProxy("image1.jpg");
        IImage image2 = new ImageProxy("image2.jpg");

        // Displaying images
        image1.display(); // Loads and displays image1
        image2.display(); // Loads and displays image2
        image1.display(); // Displays image1 without loading again
    }
}
