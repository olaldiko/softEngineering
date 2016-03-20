package test.unitary;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import model.LoginService;
import model.LoginServiceFacade;
import model.User;
import model.UserDAO;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gorka Olalde on 20/3/16.
 */
@RunWith(EasyMockRunner.class)
public class LoginServiceFacadeMockTest {

    @TestSubject
    LoginServiceFacade loginService = new LoginServiceFacade();

    @Mock
    UserDAO userDao = EasyMock.strictMock(UserDAO.class);

    @Before
    public void before() {


        loginService.setUserDAO(userDao);
    }

    @Test
    public void testCorrectLogin() {
        String userName = "TestUser";
        String plainPass = "TestPass";
        String hashedPass = "����Ӌ��\u0007\u0019��z��";
        User testUser = new User();
        boolean result;
        expect(userDao.loadByUsernameAndPassword(userName, hashedPass)).andReturn(testUser);
        replay(userDao);
        result = loginService.login(userName, plainPass);
        verify(userDao);
        assertTrue("Expected to validate", result);
    }

    @Test
    public void testIncorrectLogin() {
        String userName = "BadUser";
        String plainPass = "BadPass";
        String hashedPass = "\u0019\u0011�S\u001E�\\�\u0007���Z��r";
        boolean result;
        expect(userDao.loadByUsernameAndPassword(userName, hashedPass)).andReturn(null);
        replay(userDao);
        result = loginService.login(userName, plainPass);
        verify(userDao);
        assertFalse("Expected to not validate", result);
    }
}
