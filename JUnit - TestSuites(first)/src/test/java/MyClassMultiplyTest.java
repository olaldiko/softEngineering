import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gorkaolalde on 6/3/16.
 */
public class MyClassMultiplyTest {
    MyClass testClass;

    @Before
    public void before() {
        testClass = new MyClass();
    }

    @Test
    public void testMultiply() {
        int num1 = 10;
        int num2 = 10;
        int expected = 100;
        int result = testClass.multiply(num1, num2);
        assertEquals("Multiply result not correct", expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyBig() {
        int num1 = 1000;
        int num2 = 1000;
        testClass.multiply(num1, num2);
    }
}
