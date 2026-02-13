/**
 * 
 */
package user_login_validation_test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import user_login_validation.LoginValidation;

/**
 * 
 */
public class LoginValidationTest {
	private LoginValidation loginValidation;
	
	@BeforeEach
	void setUp() {
		loginValidation = new LoginValidation();
	}
	@Test
	@DisplayName("Test UserName")
	void suresh12UserName() {
		assertTrue(loginValidation.isValidUserName("suresh12"));
		assertFalse(loginValidation.isValidUserName("suresh12@"));
	}
	
	@Test
	@DisplayName("Test UserName")
	void suresh123UserName() {
		assertTrue(loginValidation.isValidUserName("suresh123"));
		assertFalse(loginValidation.isValidUserName("sures$%h12"));
	}
	
	@Test
	@DisplayName("Test Password")
	void sureH23AsPassword(){
		assertTrue(loginValidation.isValidPassword("sureH@23"));
	}
	
	@Test
	@DisplayName("Test Password")
	void sureH2AsPassword(){
		assertTrue(loginValidation.isValidPassword("!sureH@23"));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/login-data.csv", numLinesToSkip = 1)
	@DisplayName("Test Using CSV file")
	void csvtest(String userName, String password) {
		assertTrue(loginValidation.isValidUserName(userName));
		assertTrue(loginValidation.isValidPassword(password));
	}
}
