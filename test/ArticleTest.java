import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by Jan on 10.12.2016.
 */
public class ArticleTest {

    @org.junit.Test
    public void read() throws Exception {
        Article article = new Article("art 1");
        assertEquals("art 1", article.read());
        article.addLine("first line");
        article.addLine("second line");
        article.addLine("third line");
        assertEquals(article.read(), "art 1\nfirst line\nsecond line\nthird line");
    }

    @org.junit.Test
    public void removeHyphens() throws Exception {
        Article article = new Article("art 1");
        article.addLine("first pa-");
        article.addLine("rt second par-");
        article.addLine("t");
        article.removeHyphens();
        assertEquals("art 1\nfirst\npart second\npart", article.read());
    }

}