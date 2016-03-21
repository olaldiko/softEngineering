import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gorka Olalde on 21/3/16.
 */

public class TimeParserBlackBoxTest {

    @Test
    public void validTimeTest24hUpperLimit() {
        String testTime = "23:59:59";
        int expectedResult = 82800 + 3540 + 59;
        int result;
        result = TimeParser.parseTimeToSeconds(testTime);
        assertEquals("The returned seconds are't the expected ones", expectedResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidTimeTestUpperLimit24h() {
        String testTime = "24:60:60";
        TimeParser.parseTimeToSeconds(testTime);
    }

    @Test
    public void validTimeTestLowerLimit24h() {
        String testTime = "00:00:00";
        int expectedResult = 0;
        int result;
        result = TimeParser.parseTimeToSeconds(testTime);
        assertEquals("The returned seconds are't the expected ones", expectedResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidTimeTestLowerLimit24h() {
        String testTime = "-1:-1:-1";
        TimeParser.parseTimeToSeconds(testTime);
    }

    @Test
    public void validTimeTestUpperLimit12h() {
        String testTime = "11:59:59pm";
        int expectedResult = 82800 + 3540 + 59;
        int result;
        result = TimeParser.parseTimeToSeconds(testTime);
        assertEquals("The returned seconds are't the expected ones", expectedResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidTimeTestUpperLimit12h() {
        String testTime = "12:00:00:00pm";
        TimeParser.parseTimeToSeconds(testTime);
    }

    @Test
    public void validTimeTestLowerLimit12h() {
        String testTime = "00:00:00pm";
        int expectedResult = 43200;
        int result;
        result = TimeParser.parseTimeToSeconds(testTime);
        assertEquals("The returned seconds are't the expected ones", expectedResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidTimeTestLowerLimit12h() {
        String testTime = "-1:00:00pm";
        TimeParser.parseTimeToSeconds(testTime);
    }

    @Test(expected = NumberFormatException.class)
    public void invalidFormatTestNoNum() {
        String testTime = "::";
        TimeParser.parseTimeToSeconds(testTime);
    }

}
