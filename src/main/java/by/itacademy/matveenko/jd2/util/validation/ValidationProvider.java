package by.itacademy.matveenko.jd2.util.validation;

import by.itacademy.matveenko.jd2.validation.impl.UserDataValidationImpl;

public final class ValidationProvider {
 	private static final ValidationProvider instance = new ValidationProvider();
	
	private ValidationProvider() {}
	
	private final UserDataValidation userDataValidation = new UserDataValidationImpl();
	
	public UserDataValidation getUserDataValidation() {
		return userDataValidation;
	}
	
	public static ValidationProvider getInstance() {
		return instance;
	}
}