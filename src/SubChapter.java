import java.io.IOException;
import java.nio.CharBuffer;

/**
 * Created by Jan on 10.12.2016.
 */
public class SubChapter implements ReadableText{
    String title;

    public SubChapter (String title){
        this.title = title;
    }

    public String read(){
        return this.title;
    }
}
