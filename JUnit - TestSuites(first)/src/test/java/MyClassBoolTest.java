import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static junit.framework.TestCase.assertFalse;

/**
 * Created by gorkaolalde on 7/3/16.
 */
public class MyClassBoolTest {

    @Test
    public void boolTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MyClass.class.getDeclaredMethod("methodToBeTested", String.class);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(new MyClass(), "");
        assertFalse("Expected to return false", result);
    }
}
