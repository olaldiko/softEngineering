package model;

import model.User;
import model.UserDAO;

/**
 * Created by Gorka Olalde on 20/3/16.
 */
public class UserDaoManualMock implements UserDAO{
    User testUser = new User();
    String testUsername = "TestUser";
    String testPassword = "����Ӌ��\u0007\u0019��z��";

    public User loadByUsernameAndPassword(String userName, String password) {
        User returnUser = null;
        if (userName.equals(testUsername) && password.equals(testPassword)) {
            returnUser = testUser;
        }
        return returnUser;
    }

    public void setTestUser(User user) {
        this.testUser = user;
    }
    public void setTestUsername(String userName) {
        this.testUsername = userName;
    }

    public void setTestPassword(String password) {
        this.testPassword = password;
    }

}
