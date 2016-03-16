import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by gorkaolalde on 6/3/16.
 */
public class MyClassMultiplyTest {

    @Test
    public void testMultiply() {
        MyClass testClass = new MyClass();
        int num1 = 10;
        int num2 = 10;
        int expected = 100;
        int result = testClass.multiply(num1, num2);
        assertEquals("Multiply result not correct", expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyBig() {
        MyClass testClass = new MyClass();
        int num1 = 1000;
        int num2 = 1000;
        testClass.multiply(num1, num2);
    }
}
