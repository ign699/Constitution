import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jan on 01.12.2016.
 */
public class Constitution {
    public static void main(String [ ] args)
    {
        List<Article> articles = new LinkedList<>();
        List<Chapter> chapters = new LinkedList<>();



        //Loads all chapters
        try(BufferedReader br = new BufferedReader(new FileReader("src//konstytucja.txt"))) {
            String line = br.readLine();
            while (line != null) {
                //Check if is Article
                if (Pattern.matches("^Rozdział\\s[IVXLCDM]++$", line)) {
                    Chapter chapter = new Chapter(line);
                    line = br.readLine();
                    while(line!=null && !Pattern.matches("^Art\\.\\s[0-9]{1,3}\\.$", line) && !Pattern.matches("^Rozdział\\s[IVXLCDM]++$", line)){
                        chapter.addLine(line);
                        line = br.readLine();
                    }
                    chapters.add(chapter);
                }
                else {
                    line = br.readLine();
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        //Loads all articles
        try(BufferedReader br = new BufferedReader(new FileReader("src//konstytucja.txt"))) {
            String line = br.readLine();
            int chapter = -1;
            while (line != null) {
                if (Pattern.matches("^Rozdział\\s[IVXLCDM]++$", line)){
                    chapter++;
                }
                //Check if is Article and add it to corresponding chapter and to article list
                if (Pattern.matches("^Art\\.\\s[0-9]{1,3}\\.$", line)) {
                    Article article = new Article(line);
                    line = br.readLine();
                    while(line!=null && !Pattern.matches("^Art\\.\\s[0-9]{1,3}\\.$", line) && !Pattern.matches("^©Kancelaria\\sSejmu$", line) && !Pattern.matches("^Rozdział\\s[IVXLCDM]++$", line)){
                        article.addLine(line);
                        line = br.readLine();
                    }
                    article.removeHyphens();
                    articles.add(article);
                    chapters.get(chapter).addArticle(article);
                }
                else {
                    line = br.readLine();
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        articles.get(1).read();
    }



}
