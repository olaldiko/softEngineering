package auth;

import java.security.NoSuchAlgorithmException;

/**
 * An Auth Strategy that use plain passwords.
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class AuthPlain implements AuthStrategy {

	/**
	 * Compare  supplied password wiht stored user password
	 * @param suppliedPassword the supplied password
	 * @param userPassword the user password
	 * @return true if both passwords are equals and not null
	 */
	public boolean validate(String suppliedPassword, String userPassword) {
		if (suppliedPassword == null || userPassword == null) {
			return false;
		}
		
		return suppliedPassword.equals(userPassword);
	}

	/**
	 * Crypt user supplied password before to validate.
	 * 
	 * @param password the user password
	 * @return String with crypted password.
	 * @throws NoSuchAlgorithmException if cannot find algorithm.
	 */
	public String crypt(String password) {
		return password;
	}
}
