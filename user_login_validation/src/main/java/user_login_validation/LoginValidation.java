/**
 * 
 */
package user_login_validation;

/**
 * 
 */
public class LoginValidation {
	private String userName;
	private String password;
	
	/**
	 * 
	 */
	public LoginValidation() {
		super();
	}
	/**
	 * @param userName
	 * @param password
	 */
	public LoginValidation(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	/**
	 * @return the userName
	 */
	public final String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public final void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isValidUserName(String userName) {
		if(userName == null || userName.length() <= 5 || userName.length() >= 15) return false;
		for(int i = 0; i < userName.length(); i++) {
			char ch = userName.charAt(i);
			if(!(Character.isDigit(ch)) && !(Character.isAlphabetic(ch))) return false;
		}
		return true;
	}
	
	public boolean isValidPassword(String password) {
		if(password == null || password.length() < 8) return false;
		boolean characterFlag = false, digitFlag = false, specialFlag = false;
		String splChar = "@$!%*?&";
		for(int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if(Character.isAlphabetic(ch)) characterFlag = true;
			if(Character.isDigit(ch)) digitFlag = true;
			for(int j = 0; j < splChar.length(); j++) {
				char spl = splChar.charAt(j);
				if(ch == spl) {
					specialFlag = true;
					break;
				}
			}
		}
		return (characterFlag && digitFlag && specialFlag);
	}
}
