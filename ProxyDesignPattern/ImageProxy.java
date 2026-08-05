package ProxyDesignPattern;

public class ImageProxy implements IImage{
    String fileName;

    ImageDisplay imageDisplay;
   public  ImageProxy(String fileName){
        this.fileName=fileName;
        this.imageDisplay=null;
        System.out.println("ImageProxy created for file: " + fileName);
    }
    public void display() {
        if(imageDisplay==null){
            imageDisplay=new ImageDisplay(fileName);
        }
        imageDisplay.display();
    }
    
}
