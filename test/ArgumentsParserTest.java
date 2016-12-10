import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jan on 10.12.2016.
 */
public class ArgumentsParserTest {
    ArgumentsParser arguments = new ArgumentsParser(new String[] {"path", "article", "123" });
    ArgumentsParser arguments1 = new ArgumentsParser(new String[] {"path", "aricle", "123" });
    ArgumentsParser arguments2 = new ArgumentsParser(new String[] {"path", "articles", "123", "134" });

    @Test
    public void toRead() throws Exception {
        assertEquals(arguments.toRead(), "article");

    }



    @Test(expected = Exception.class)
    public void toReadException() throws Exception{
        arguments1.toRead();
    }

    @Test
    public void getRange() throws Exception {
        assertArrayEquals(new int[]{123}, arguments.getRange());
        assertArrayEquals(new int[]{123,134}, arguments2.getRange());
    }


    @Test
    public void getFilePath() throws Exception {
        assertEquals("path", arguments.getFilePath());
    }

}