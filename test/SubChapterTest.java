import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jan on 10.12.2016.
 */
public class SubChapterTest {
    @Test
    public void read() throws Exception {
        SubChapter sub1 = new SubChapter("sub1");
        SubChapter sub2 = new SubChapter("sub 2 sub 2");
        assertEquals("sub1", sub1.read());
        assertEquals("sub 2 sub 2", sub2.read());
    }

}