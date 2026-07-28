package CompositeDesingPattern;

public class main {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        File file1 = new File("file1.txt", 100);
        File file2 = new File("file2.txt", 200);
        Folder subFolder = new Folder("subfolder");
        subFolder.add(new File("file3.txt", 300));

        root.add(file1);
        root.add(file2);
        root.add(subFolder);
        root.openAll(0);
    }
}
