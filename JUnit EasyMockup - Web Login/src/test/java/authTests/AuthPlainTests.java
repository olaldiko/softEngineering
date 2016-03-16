package authTests;

import auth.AuthPlain;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gorka Olalde on 16/3/16.
 */

public class AuthPlainTests {

    @TestSubject
    AuthPlain authenticator = new AuthPlain();

    @Test
    public void validateNullTest() {
        String suppliedPassword = null;
        String userPassword = null;
        boolean returnedValue;
        returnedValue = authenticator.validate(suppliedPassword, userPassword);
        assertFalse("Expected to return false authentication", returnedValue);
    }

    @Test
    public void validateOkTest() {
        String suppliedPassword = "Test";
        String userPassword = "Test";
        boolean returnedValue;
        returnedValue = authenticator.validate(suppliedPassword, userPassword);
        assertTrue("Expected to validate ok", returnedValue);
    }

    @Test
    public void validateBadTest() {
        String suppliedPassword = "BadPassword";
        String userPassword = "OkPassword";
        boolean returnedValue;
        returnedValue = authenticator.validate(suppliedPassword, userPassword);
        assertFalse("Expected to return false authentication", returnedValue);
    }

    @Test
    public void cryptTest() {
        String suppliedPassword = "Test";
        String expectedPassword = "Test";
        String returnValue;
        returnValue = authenticator.crypt(suppliedPassword);
        assertEquals("Expected to be the same password", expectedPassword, returnValue);
    }
}
