import javax.lang.model.util.ElementScanner6;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Jan on 02.12.2016.
 */
public class ConstitutionReader {
    public static void main(String[] args) {


            ArgumentsParser arguments = new ArgumentsParser(args);
            Constitution constitution = null;

            try {
                constitution = new Constitution(arguments.getFilePath());
            }
            catch (IOException e){
                System.out.println("No such file");
            }

            String toRead = null;
            try {
                toRead = arguments.toRead();
            }
            catch (Exception e) {
                System.out.print(e.toString());
            }

            if (toRead.equals("article")) {
                try {
                    System.out.print(constitution.readArticle(arguments.getRange()));
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            } else if (toRead.equals("articles")) {
                try {
                    System.out.print(constitution.readArticles(arguments.getRange()));
                } catch (Exception e) {
                    System.out.print(e.toString());
                }
            } else if (toRead.equals("chapter")) {
                try {
                    System.out.print(constitution.readChapter(arguments.getRange()));
                } catch (Exception e) {
                    System.out.print(e.toString());
                }
            } else {
                System.out.print("Invalid option");
            }
        }


    }
