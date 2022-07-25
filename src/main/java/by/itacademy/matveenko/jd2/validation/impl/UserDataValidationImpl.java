package by.itacademy.matveenko.jd2.validation.impl;

import by.itacademy.matveenko.jd2.bean.NewUserInfo;
import by.itacademy.matveenko.jd2.dao.SQLDataBase;
import by.itacademy.matveenko.jd2.service.ServiceException;
import by.itacademy.matveenko.jd2.util.validation.UserDataValidation;

public class UserDataValidationImpl implements UserDataValidation{

	private SQLDataBase dataBase = SQLDataBase.getInstance ();
	private final String SYMBOL_COMMERCIAL_AT = "@";
	private final String SYMBOL_DOT = ".";
	
	@Override
	public boolean checkAuthDataLogination (String login, String password) {
		boolean result = false;
		if (login != null | password != null) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean checkAuthDataRegistration (NewUserInfo user) throws ServiceException {
		boolean result = false;
		if (!isLoginUsed (user) && !isEmailUsed (user) && isEmailRight(user)) {
			result = true;
		}
		else if (isLoginUsed (user)) {
			throw new ServiceException("Used login");
		}
		else if (isEmailUsed (user)) {
			throw new ServiceException("Used email");
		}
			
		else if (!isEmailRight (user)) {
			throw new ServiceException("Invalid email"); 
		}
		return result;
	}
	
	public boolean isLoginUsed (NewUserInfo user) {
		boolean result = false;
		for (NewUserInfo userRegistered : dataBase.getDataBase()) {
            if (user.getLogin().equals(userRegistered.getLogin()) ) {
            	result = true;
            }
        }
		return result;
	}
	
	public boolean isEmailUsed (NewUserInfo user) {
		boolean result = false;
		for (NewUserInfo userRegistered : dataBase.getDataBase()) {
            if (user.getEmail().equals(userRegistered.getEmail()) ) {
            	result = true;
            }
        }
		return result;
	}
	
	public boolean isEmailRight (NewUserInfo user) {
		boolean result = false;		
            if (user.getEmail().contains(SYMBOL_COMMERCIAL_AT) && user.getEmail().contains(SYMBOL_DOT)) {
            	result = true;
            }        
		return result;
	}	
}