package dao;

import model.User;

/**
 * Interface for User DAOs
 * 
 * @author Jose Luis Martin - (chelu.es@gmail.com)
 */
public interface UserDao  {
	
	/**
	 * Find a User by username
	 * @param username the user name
	 * @return the User that match username
	 */
	User findByUsername(String username);

}
