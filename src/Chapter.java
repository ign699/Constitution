import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jan on 01.12.2016.
 */
public class Chapter implements ReadableLineBasedText {
    List<Article> articles = new LinkedList<>();
    List<String> lines = new LinkedList<>();
    String chapter;

    public Chapter(String chapter){
        this.chapter=chapter;
    }

    public void addLine(String line){
        this.lines.add(line);
    }

    public void addArticle(Article article){
        this.articles.add(article);
    }

    public void read(){
        System.out.println(chapter);
        for(String line : lines){
            System.out.println(line);
        }
        for(Article article : articles){
            article.read();
        }
    }

}
