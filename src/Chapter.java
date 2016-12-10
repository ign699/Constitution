import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jan on 01.12.2016.
 */
public class Chapter {
    List<ReadableText> chapterContent = new LinkedList<>();
    String chapterNumber;

    public Chapter(String chapterNumber){
        this.chapterNumber=chapterNumber;
    }

    public void addContent(ReadableText content){
        this.chapterContent.add(content);
    }


    public String read(){
        String fullChapter = chapterNumber;
        for(ReadableText contentPart : chapterContent){
            fullChapter +="\n";
            fullChapter += contentPart.read();
        }
        return fullChapter;
    }



}
