package authTests;

import auth.AuthManager;
import auth.AuthStrategy;
import dao.UserDao;
import model.User;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gorka Olalde on 15/3/16.
 */
@RunWith(EasyMockRunner.class)
public class AuthManagerTests {

    @TestSubject
    AuthManager manager = new AuthManager();

    @Mock
    AuthStrategy strategy = EasyMock.strictMock(AuthStrategy.class);

    @Mock
    UserDao userDao = EasyMock.strictMock(UserDao.class);

    @Before
    public void before() {
        manager.setAuthStrategy(strategy);
        manager.setUserDao(userDao);
    }
    @Test
    public void authUserNullTest() {
        boolean result;
        result = manager.authUser(null, null);
        assertFalse("Expected to return false as auth error", result);
    }

    @Test
    public void authUserOkTest() {
        User user = new User();
        user.setPassword("Test");
        String inputPassword = "Test";

        boolean authResult;

        expect(strategy.validate("Test", "Test")).andReturn(true);

        replay(strategy);
        authResult = manager.authUser(user, inputPassword);
        verify(strategy);
        assertTrue("Expected to validate correctly", authResult);
    }

    @Test
    public void authUserBadTest() {
        User user = new User();
        user.setPassword("CorrectPassword");
        String inputPassword = "IncorrectPassword";

        boolean authResult;

        expect(strategy.validate( "IncorrectPassword", "CorrectPassword")).andReturn(false);
        replay(strategy);
        authResult = manager.authUser(user, inputPassword);
        verify(strategy);
        assertFalse("Expected to not validate", authResult);
    }

    @Test
    public void validateOkTest() {
        String userName = "TestUser";
        String password  = "TestPass";
        User userObject = new User();
        userObject.setUsername(userName);
        userObject.setPassword(password);
        boolean result;
        expect(userDao.findByUsername(userName)).andReturn(userObject);
        expect(strategy.validate(password, password)).andReturn(true);
        replay(userDao);
        replay(strategy);
        result = manager.validate(userName, password);
        verify(userDao);
        verify(strategy);
        assertTrue("Expected to validate ok", result);
    }

    @Test
    public void authStrategyGettersTest() {
        manager.setAuthStrategy(strategy);
        AuthStrategy returnedStrategy;
        returnedStrategy = manager.getAuthStrategy();
        assertEquals("Expected to return the same strategy", strategy, returnedStrategy);
    }

    @Test
    public void userDaoGettersTest() {
        manager.setUserDao(userDao);
        UserDao returnedDao;
        returnedDao = manager.getUserDao();
        assertEquals("Expected to return the same DAO", userDao, returnedDao);
    }
}
