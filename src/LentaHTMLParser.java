import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LentaHTMLParser {
    public static void main(String[] args) throws IOException {
        String htmlFile = parseFile("Data/lenta.html");
       // Document doc = Jsoup.parse(htmlFile);
        Document doc = Jsoup.connect("https://vk.com/vk.drug").get();
        Elements elements = doc.select("img");
        List<String> urlList = new ArrayList<>();
        elements.forEach(element -> {
            if (!element.attr("abs:src").equals("")) {
                urlList.add(element.attr("abs:src"));
            }

        });

        for (String strImageURL : urlList) {


            try {

                //open the stream from URL
                URL urlImage = new URL(strImageURL);
                InputStream in = urlImage.openStream();

                byte[] buffer = new byte[4096];
                int n = -1;

                OutputStream os =
                        new FileOutputStream("C:\\Users\\KS\\IdeaProjects\\SkillBoxLessons\\images" + "/" + strImageURL.substring(strImageURL.lastIndexOf("/") + 1));

                //write bytes to the output stream
                while ((n = in.read(buffer)) != -1) {
                    os.write(buffer, 0, n);
                }

                //close the stream
                os.close();

                System.out.println("Image saved");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    private static String parseFile(String s) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(s));
            lines.forEach(line -> builder.append(line).append("\n"));
        }
        catch (Exception ex){
            System.err.println(ex.getMessage()); // печать красным цветом
        }
        return  builder.toString();
    }
}
