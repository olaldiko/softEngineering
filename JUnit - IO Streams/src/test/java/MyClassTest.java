import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by gorkaolalde on 7/3/16.
 */
public class MyClassTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSuma() {
        MyClass testClass = new MyClass();
        String data = "12\n14\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        MyClass.suma();
        assertEquals("26", outContent.toString());
    }

    @After
    public void exit() {
        System.setOut(System.out);
        System.setIn(System.in);
    }
}
