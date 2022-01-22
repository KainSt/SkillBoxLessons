import java.io.File;

public class Main {
    public static void main(String[] args){
        File file = new File("/data/info.txt");
        System.out.println(file.getName());
        System.out.println(file.isDirectory());
        System.out.println(file.getName());
    }


}
