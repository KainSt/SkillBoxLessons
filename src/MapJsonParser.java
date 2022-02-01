import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MapJsonParser {
    public static void main(String[] args){
             try{
                 Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
                 Elements elements = doc.select(".name");
                 System.out.println();
             }
             catch (IOException exception){
                 exception.getStackTrace();
             }
        System.out.println();
    }
}
