package modelTests;

import model.User;
import org.easymock.TestSubject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gorka Olalde on 16/3/16.
 */
public class UserTests {

    @TestSubject
    User testUser = new User();

    @Test
    public void passwordGetterTest() {
        String expectedPass = "TestPassword";
        String returnedPass;
        testUser.setPassword(expectedPass);
        returnedPass = testUser.getPassword();
        assertEquals("Entered password does not match"
                , expectedPass, returnedPass);
    }

    @Test
    public void idGettersTest() {
        Long expectedId = 1l;
        Long returnedId;
        testUser.setId(expectedId);
        returnedId = testUser.getId();
        assertEquals("Entered ID does not match returned one"
                , expectedId, returnedId);
    }

    @Test
    public void usernameGettersTest() {
        String expectedUName = "Test";
        String returnedUName;
        testUser.setUsername(expectedUName);
        returnedUName = testUser.getUsername();
        assertEquals("Entered username does not match the returned one"
                , expectedUName, returnedUName);
    }

    @Test
    public void nameGettersTest() {
        String expectedName = "Test";
        String returnedName;
        testUser.setName(expectedName);
        returnedName = testUser.getName();
        assertEquals("Entered name does not match returned one"
                , expectedName, returnedName);
    }

    @Test
    public void surnameGettersTest() {
        String expectedSurname = "Test";
        String returnedSurname;
        testUser.setSurname(expectedSurname);
        returnedSurname = testUser.getSurname();
        assertEquals("Entered surname does not match the returned one"
                , expectedSurname, returnedSurname);
    }
}
