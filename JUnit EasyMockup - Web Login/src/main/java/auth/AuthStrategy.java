package auth;

import java.security.NoSuchAlgorithmException;

/**
 * Strategy for validate user supplied passords with user stored passwords
 * 
 * @see AuthPlain 
 * @see AuthHashMD5
 * @see AuthManager
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public interface AuthStrategy {
	
	/**
	 * Validate password.
	 * @param suppliedPassword supplied password
	 * @param userPassword user password
	 * @return true if password match.
	 */
	boolean validate(String suppliedPassword, String userPassword);
	
	/**
	 * Crypt user supplied password before to validate.
	 * 
	 * @param password the user password
	 * @return String with crypted password.
	 * @throws NoSuchAlgorithmException if cannot find algorithm.
	 */
	String crypt(String password) throws NoSuchAlgorithmException;

}
