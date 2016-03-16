import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * Created by gorkaolalde on 1/3/16.
 */
public class MyClassSumaTest {

    @Test
    public void testSuma() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = MyClass.class.getDeclaredMethod("suma", int.class, int.class);
        method.setAccessible(true);
        int num1 = 2;
        int num2 = 2;
        int expected = 4;
        int result;
        result = (Integer) method.invoke(new MyClass(), num1, num2);
        assertEquals(expected, result);
    }
}
