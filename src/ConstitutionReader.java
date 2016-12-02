import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Jan on 02.12.2016.
 */
public class ConstitutionReader {
    public static void main(String [] args) {
        Constitution constitution = new Constitution("C:\\Users\\Jan\\IdeaProjects\\Constitution\\src\\konstytucja.txt");

        Scanner scan = new Scanner(System.in);
        System.out.print("Do you want to read: article, articles or a chapter: ");
        String whatToRead = scan.nextLine();

        if(whatToRead.equals("article")){
            System.out.print("Article number: ");
            try{
                constitution.readArticle(scan.nextInt());
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
        }
        else if (whatToRead.equals("articles")){
            System.out.print("Start and end articles numbers: ");
            try {
                constitution.readArticles(scan.nextInt(), scan.nextInt());
            } catch (Exception e) {
                System.out.print(e.toString());
            }
        }
        else if (whatToRead.equals("chapter")){
            System.out.print("Chapter number: ");
            try {
                constitution.readChapter(scan.nextInt());
            } catch (Exception e) {
                System.out.print(e.toString());
            }
        }
        else {
            System.out.print("Invalid option");
        }
    }
}
