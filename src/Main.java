import java.io.File;

public class Main {

    public static void main(String[] args) {
        try{
            File folder = new File("C:\\Users\\KS\\Documents\\Манн Иванов Фербер\\");
            System.out.println(  convertLength( directorySize(folder) ) );
        } catch (NullPointerException exception){
            System.out.println(exception.getStackTrace());
        }





    }

    public static long directorySize(File folder){

        if (!folder.isDirectory()) {
            System.out.println(folder.getAbsolutePath());
            return folder.length();
        } else {
            File[] fileArray = folder.listFiles();
            long currentSize = 0;
            for (File element : fileArray) {
                currentSize+= directorySize(element);
           }
            return currentSize;
        }


    }

    public static String convertLength(long length) {

        if (length < 1024) {
            return length + " " + "Б";
        }
        if (length >= Math.pow(2, 10) & length < Math.pow(2, 20)) {
            return String.format("%.2f",length / Math.pow(2, 10)) + " " + "КБ";
        }

        if (length >= Math.pow(2, 20) & length < Math.pow(2, 30)) {
            return String.format("%.2f",length / Math.pow(2, 20)) + " " + "Мб";
        }

        return String.format("%.2f",length / Math.pow(2, 30) )+ " " + "Гб";


    }

}