import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gorka Olalde on 21/3/16.
 */
public class TimeParserWhiteBoxTest {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


    @Before
    public void before() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void after() {
        System.setOut(System.out);
    }

    @Test
    public void validFormatTest24h() {
        String testTime = "22:00:00";
        int expectedResult = 79200;
        int result;
        result = TimeParser.parseTimeToSeconds(testTime);
        assertEquals(expectedResult, result);
    }

    @Test
    public void validFormatTest12h() {
        String testTime = "11:00:00pm";
        int expectedResult = 82800;
        int result;
        result = TimeParser.parseTimeToSeconds(testTime);
        assertEquals(expectedResult, result);
    }

    @Test(expected = NumberFormatException.class)
    public void invalidFormatTestFirstCond() {
        String testTime = "";
        TimeParser.parseTimeToSeconds(testTime);
    }

    @Test(expected = NumberFormatException.class)
    public void invalidFormatTestSecondCond() {
        String testTime = ":";
        TimeParser.parseTimeToSeconds(testTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void outOfRangeTest() {
        String testTime = "24:00:00";
        TimeParser.parseTimeToSeconds(testTime);
    }

    @Test
    public void printHourTest() {
        Class timeParserClass = TimeParser.class;
        Object timeParserInstance;
        Method printTimeMethod;
        String expectedOutput = "43932";
        try {
            printTimeMethod = timeParserClass.getDeclaredMethod("printHour");
            printTimeMethod.setAccessible(true);
            timeParserInstance = timeParserClass.newInstance();
            printTimeMethod.invoke(timeParserInstance);
            assertEquals(outputStream.toString(), expectedOutput);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}