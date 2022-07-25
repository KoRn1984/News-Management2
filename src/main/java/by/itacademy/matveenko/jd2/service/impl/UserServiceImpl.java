package by.itacademy.matveenko.jd2.service.impl;

import by.itacademy.matveenko.jd2.dao.IUserDao;
import by.itacademy.matveenko.jd2.service.IUserService;
import by.itacademy.matveenko.jd2.dao.impl.UserDao;
import by.itacademy.matveenko.jd2.util.validation.UserDataValidation;
import by.itacademy.matveenko.jd2.util.validation.ValidationProvider;
import by.itacademy.matveenko.jd2.bean.NewUserInfo;
import by.itacademy.matveenko.jd2.bean.UserRole;
import by.itacademy.matveenko.jd2.dao.DaoException;
import by.itacademy.matveenko.jd2.dao.DaoProvider;
import by.itacademy.matveenko.jd2.service.ServiceException;

public class UserServiceImpl implements IUserService{
	
	private final IUserDao userDao = DaoProvider.getInstance().getUserDao();
	private final UserDataValidation userDataValidation = ValidationProvider. getInstance().getUserDataValidation();
	
	@Override
	public String signIn(String login, String password) throws ServiceException {
		
		if(!userDataValidation.checkAuthDataLogination(login, password)) {
			throw new ServiceException("invalid login");
		}
		else {		
			if(userDao.logination(login, password) != null) {
				return userDao.getUserRole(login, password);
			}else {
				return "guest";
			}catch(DaoException e) {
				throw new ServiceException(e);
			}
		}
	}
	
	@Override
	public boolean registration(NewUserInfo user) throws ServiceException  {
	
		if(!userDataValidation.checkAuthDataRegistration(user)) {
			throw new ServiceException("invalid date");
		 }
			else {		
			try {				
				return userDao.registration(user);				
			}catch(DaoException e) {
				throw new ServiceException(e);
			   }
			}
		}
	

//	private final IUserDao userDao = DaoProvider.getInstance().getUserDao();
  //private final UserDataValidation userDataValidation = ValidationProvider.getIntsance().getUserDataVelidation();
	
	//@Override
	//public String signIn(String login, String password) throws ServiceException {
				/*
		 * if(!userDataValidation.checkAUthData(login, password)) { throw new
		 * ServiceException("login ...... "); }
		 */
		//try {
	//		if(userDao.logination(login, password)) {
	//			return userDao.getUserRole(login, password);
	//		}else {
	//			return "guest";
	//		}
			
	//	}catch(DaoException e) {
	//		throw new ServiceException(e);
	//	}		
	//}

	//@Override
	//public boolean registration(NewUserInfo user) {
		// TODO Auto-generated method stub
	//	return true;
	//}
}