package integration;

import model.LoginServiceFacade;
import model.UserDAO;
import model.UserDAOXml;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Gorka Olalde on 20/3/16.
 */

public class LoginServiceXMLIntegration {
    LoginServiceFacade loginService = new LoginServiceFacade();

    UserDAO testDao = new UserDAOXml();

    @Before
    public void before() {

        loginService.setUserDAO(testDao);
    }

    @Test(timeout = 100)
    public void correctLoginTest() {
        String username = "TestUser";
        String password = "TestPassword";
        boolean result;
        result = loginService.login(username, password);
        assertTrue("Expected to log in", result);
    }

    @Test(timeout = 100)
    public void incorrectLoginTest() {
        String username = "BadUser";
        String password = "BadPassword";
        boolean result;
        result = loginService.login(username, password);
        assertFalse("Expected to give login error", result);
    }




}
