import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gorkaolalde on 1/3/16.
 */
public class MyClassDivisionTest {

    @Test
    public void testDivision() {
        MyClass testClass = new MyClass();
        int num1 = 12;
        int num2 = 6;
        int expected = 2;
        int result;
        result = testClass.division(num1, num2);
        assertEquals(expected, result);
    }
    @Test
    public void testDivisionZero() {
        MyClass testClass = new MyClass();
        int num1 = 12;
        int num2 = 0;
        int expected = -1;
        int result;
        result = testClass.division(num1, num2);
        assertEquals(expected, result);
    }
}
