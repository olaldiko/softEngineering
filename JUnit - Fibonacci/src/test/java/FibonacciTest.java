import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.*;

/**
 * Created by gorkaolalde on 8/3/16.
 */
@RunWith(Parameterized.class)
public class FibonacciTest extends TestCase {

    private int input;
    private int expectedResult;
    private Fibonacci testSubject;

    public FibonacciTest(int input, int output) {
        this.input = input;
        this.expectedResult = output;
    }

    @Parameters
    public static Collection<Object[]> numbers() {
        return Arrays.asList( new Object[][]{
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8}
            }
        );
    }

    @Before
    public void before() {
        testSubject = new Fibonacci();
    }


    @Test
    public void testCompute() throws Exception {
        int result;
        result = testSubject.compute(input);
        assertEquals("Computed result does not match expected one", expectedResult, result);

    }
}