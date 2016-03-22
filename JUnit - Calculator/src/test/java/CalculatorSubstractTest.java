import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Gorka Olalde on 22/3/16.
 */
public class CalculatorSubstractTest {
    Calculator testSubject;

    @Before
    public void before() {
        testSubject = new Calculator();
    }

    @Test
    public void testInputInLimit() {
        int num1 = 9999999;
        int num2 = 9999999;
        int expected = 0;
        int result = testSubject.substract(num1, num2);
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputOverLimit() {
        int num1 = 10000000;
        int num2 = 0;
        int result = testSubject.substract(num1, num2);
    }

    @Test
    public void testOutputInLimit() {
        int num1 = 9999998;
        int num2 = -1;
        int expected = 9999999;
        int result = testSubject.substract(num1, num2);
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutputOverLimit() {
        int num1 = 9999999;
        int num2 = -1;
        int result = testSubject.substract(num1, num2);
    }

}
