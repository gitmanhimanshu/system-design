package CompositeDesingPattern;
import java.util.*;
public class Folder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> children;
    public Folder(String n) {
        name = n;
        children = new ArrayList<>();
    }
    public void add(FileSystemItem item) {
        children.add(item);
    }
    @Override
    public void ls(int indent){
        String indentSpaces = " ".repeat(indent);
        System.out.println(indentSpaces + name);
        for (FileSystemItem child : children) {
           if(child.isFolder()){
            System.out.println(indentSpaces + "+ " + child.getName());
           }
           else{
            System.out.println(indentSpaces + child.getName());
           }
        }
    }


    public void openAll(int indent){
        String indt=" ".repeat(indent);
        System.out.println(indt+name);
        for(FileSystemItem child:children){
            child.openAll(indent+4);
        }   
    }
    public int getSize(){
        int c=0;
        for(FileSystemItem it:children){
            c+=it.getSize();
        }
        return c;
    }
    public FileSystemItem cd(String name){
        for(FileSystemItem it:children){
            if(it.getName().equals(name)){
                return it;
            }
        }
        return null;
    }
        public String getName(){    
            return name;
        }
        public boolean isFolder(){
            return true;
        }
}
