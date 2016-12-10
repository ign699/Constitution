import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jan on 10.12.2016.
 */
public class ChapterTest {
    @Test
    public void read() throws Exception {
        Article article1 = new Article("art1");
        article1.addLine("line1");
        article1.addLine("line 2");
        SubChapter sub = new SubChapter("sub");
        Article article2 = new Article("art 2");
        article2.addLine("line 2");
        article2.addLine("line 2");
        Chapter chapter = new Chapter("chapter");
        chapter.addContent(article1);
        chapter.addContent(sub);
        chapter.addContent(article2);

        assertEquals("chapter\nart1\nline1\nline 2\nsub\nart 2\nline 2\nline 2", chapter.read());
    }

}