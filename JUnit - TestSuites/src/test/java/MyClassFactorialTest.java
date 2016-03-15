import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gorkaolalde on 7/3/16.
 */
public class MyClassFactorialTest {
    @Test
    public void testFactorial() {
        MyClass testClass = new MyClass();
        int num = 5;
        int expected = 120;
        int result = testClass.factorial(num);
        assertEquals("Factorial of 5 is 120", expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegative() {
        MyClass testClass = new MyClass();
        int num = -1;
        int result = testClass.factorial(num);
    }

    @Test
    public void testFactorialZero() {
        MyClass testClass = new MyClass();
        int num = 0;
        int expected = 1;
        int result = testClass.factorial(num);
        assertEquals("Factorial of 0 is 1", expected, result);
    }
}
