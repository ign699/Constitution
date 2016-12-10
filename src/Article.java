import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jan on 01.12.2016.
 */
public class Article implements ReadableText {
    private String articleTitle;
    List<String> lines = new LinkedList<>();

    public Article(String article){
        this.articleTitle = article;
    }


    public void addLine(String line){
        this.lines.add(line);
    }



    public String read(){
        String finalArticle = articleTitle;
        for (String line : lines){
            finalArticle += "\n";
            finalArticle += line;
        }
        return finalArticle;
    }

    private void addAtBegginig(int line, String toAdd){
        lines.set(line, toAdd+ lines.get(line));
    }

    public void removeHyphens (){
        String buffer = null;
        for (int i = 0; i < lines.size(); i++){
            if(buffer!=null){
                addAtBegginig(i, buffer);
                buffer = null;

            }
            String line = lines.get(i);
            if(line.charAt(line.length()-1)=='-'){
                buffer = line.substring(line.lastIndexOf(" ")+1, line.length()-1);
                lines.set(i, line.substring(0,line.lastIndexOf(" ")));
            }
        }
    }
}
