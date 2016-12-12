import javax.lang.model.util.ElementScanner6;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Jan on 02.12.2016.
 */
public class ConstitutionReader {
    public static void main(String[] args) {

        try {
            ArgumentsParser arguments = null;
            arguments = new ArgumentsParser(args);
            Constitution constitution = null;
            constitution = new Constitution(arguments.getFilePath());


            String toRead = null;

            toRead = arguments.toRead();


            if (toRead.equals("article")) {

                    System.out.print(constitution.readArticle(arguments.getRange()));

            } else if (toRead.equals("articles")) {

                    System.out.print(constitution.readArticles(arguments.getRange()));

            } else if (toRead.equals("chapter")) {

                    System.out.print(constitution.readChapter(arguments.getRange()));
            }
        } catch(Exception e){
            System.out.print(e.toString());
        }

    }
}