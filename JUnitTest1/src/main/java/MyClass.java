/**
 * Created by gorkaolalde on 1/3/16.
 */
public class MyClass {
    public int multiply(int x, int y) {
        // the following is just an example
        if (x > 999) {
            throw new IllegalArgumentException("X should be less than 1000");
        }
        return x * y;
    }
    private int suma(int x, int y) {
        // the following is just an example
        return x + y;
    }
    public int division(int x, int y) {
        if (y == 0) {
            return (-1);
        }
        return x / y;
    }
    private Boolean methodToBeTested(String argument) {

        return false;
    }

    public int factorial(int x) {
        int result = 1;
        if (x >= 0) {
            while (x != 0) {
                result = result * x;
                x--;
            }
        } else {
            throw new IllegalArgumentException("X should be greater or equal than 0");
        }
        return result;
    }
}
