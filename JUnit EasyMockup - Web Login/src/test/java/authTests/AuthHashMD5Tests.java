package authTests;

import auth.AuthHashMD5;
import org.easymock.TestSubject;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gorka Olalde on 15/3/16.
 */
public class AuthHashMD5Tests {

    @TestSubject
    AuthHashMD5 authHashMD5 = new AuthHashMD5();

    @Test
    public void validateNullTest() {
        boolean expectedResult = false;
        boolean result;
        result = authHashMD5.validate(null, null);
        assertFalse("Expected to be false", result);
    }

    @Test
    public void validateOkTest() {
        String suppliedPassword = "Test";
        String userPassword = "MGNiYzY2MTFmNTU0MGJkMDgwOWEzODhkYzk1YTYxNWIK";
        boolean result;
        result = authHashMD5.validate(suppliedPassword, userPassword);
        assertTrue("Expected to validate correctly", result);
    }

    @Test
    public void cryptTest() {
        String suppliedPassword = "Test";
        String expectedEncryptedPassword = "MGNiYzY2MTFmNTU0MGJkMDgwOWEzODhkYzk1YTYxNWIK";
        String encryptedPassword = null;
        try {
            encryptedPassword = authHashMD5.crypt(suppliedPassword);
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            fail("Exception thrown");
        }
        assertEquals("Expected for the passwords to match", expectedEncryptedPassword, encryptedPassword);
    }


}
