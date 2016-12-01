import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jan on 01.12.2016.
 */
public class Article {
    private String article;
    List<String> lines = new LinkedList<>();

    public Article(String article){
        this.article = article;
    }


    public void addLine(String line){
        this.lines.add(line);
    }

    public void read(){
        System.out.println(article);
        for (String line : lines){
            System.out.println(line);
        }
    }

    public void removeHyphens (){
        String buffer = null;
        for (int i = 0; i < lines.size(); i++){
            String line = lines.get(i);
            if(buffer!=null){
                lines.set(i, buffer + line);
                buffer = null;
            }
            if(line.charAt(line.length()-1)=='-'){
                buffer = line.substring(line.lastIndexOf(" ")+1, line.length()-1);
                lines.set(i, line.substring(0,line.lastIndexOf(" ")));
            }
        }
    }
}
