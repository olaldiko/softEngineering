package auth;

/**
 * An Auth Service to validate Users
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */

public interface AuthService {
	
	/**
	 * Validate a username.
	 * @param username the user name
	 * @param password the supplied user password
	 * @return true if password match
	 */
	boolean validate(String username, String password);

}
