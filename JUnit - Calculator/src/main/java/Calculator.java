/**
 * Created by Gorka Olalde on 21/3/16.
 */
public class Calculator {
    final int MAX_INT  = 9999999;

    public int add(int num1, int num2) throws IllegalArgumentException {
        int result;
        if(!checkInput(num1, num2)) {
            throw new IllegalArgumentException();
        }
        result = num1 + num2;
        if(!checkOutput(result)) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public int substract(int num1, int num2) {
        int result;
        if(!checkInput(num1, num2)) {
            throw new IllegalArgumentException();
        }
        result = num1 - num2;
        if(!checkOutput(result)) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public int multiply(int num1, int num2) {
        int result;
        if(!checkInput(num1, num2)) {
            throw new IllegalArgumentException();
        }
        result = num1 * num2;
        if(!checkOutput(result)) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public int divide(int num1, int num2) {
        int result;
        if(!checkInput(num1, num2)) {
            throw new IllegalArgumentException();
        }
        if (num2 == 0) {
            throw new IllegalArgumentException();
            //TODO:Add to changes doc. Modified to allow negatives,
        }
        result = num1 / num2;
        if(!checkOutput(result)) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    private boolean checkInput(int num1, int num2) {
        boolean retVal = false;
        if (num1 <= MAX_INT && num2 <= MAX_INT) {
            //TODO:Add to changes document. Changed to admit 9999999 as valid.
            retVal = true;
        }
        return retVal;
    }

    private boolean checkOutput(int result) {
        if (result <= MAX_INT) {
            //TODO:Add to changes document. Changed to admit 9999999 as valid.
            return true;
        } else {
            return false;
        }
    }
}
