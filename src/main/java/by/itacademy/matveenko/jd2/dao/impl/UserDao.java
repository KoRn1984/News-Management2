package by.itacademy.matveenko.jd2.dao.impl;

import java.sql.SQLException;

import by.itacademy.matveenko.jd2.bean.UserRole;
import by.itacademy.matveenko.jd2.dao.SQLDataBase;
import by.itacademy.matveenko.jd2.bean.NewUserInfo;
import by.itacademy.matveenko.jd2.dao.DaoException;
import by.itacademy.matveenko.jd2.dao.IUserDao;

public class UserDao implements IUserDao{
	
	private SQLDataBase dataBase = SQLDataBase.getInstance ();
	//private SQLDataBase dataBase = null;
		 
	public void isSQLDataBase (String login, String password) throws DaoException {
        if (dataBase == null) {			
            try {
                throw new SQLException("Database not available");
			}catch(SQLException e) {
				throw new DaoException(e);
			}
        }	
		else {
			logination(login, password);
	   }
	}
	
	@Override
	public NewUserInfo logination(String login, String password) throws DaoException {
		NewUserInfo usersData = null;
		
		 for (NewUserInfo user : dataBase.getDataBase()) {
	            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {	            		            	
	            	usersData = setUsersData (login, password);	            		            
	            break;	            
	            }	            
		 }	     
	return usersData;		
	}
		
	@Override
	public UserRole getUserRole(String login, String password) throws DaoException {
    	UserRole role = UserRole.UNKNOWN;
        for (NewUserInfo user : dataBase.getDataBase()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
            	role = user.getRole();            	
            }
        }
        return role;
    }
	
	public NewUserInfo setUsersData (String login, String password) throws DaoException {	
	UserRole role = getUserRole(login, password);
	NewUserInfo usersDatas = new NewUserInfo (login, password, role);
	return usersDatas;	
    }
	
	@Override
	public boolean registration(NewUserInfo user) throws DaoException  {
		boolean result = false;
		if (!isUserAlreadyRegistered (user)) {
			addDataBase (user);
			System.out.println ("DAO ok!");
			result = true;
		}
			else {
				System.out.println ("DAO error!");
			}
		return result;
        }
	
	public SQLDataBase addDataBase (NewUserInfo user) {
		dataBase.getDataBase().add(user);
		System.out.println (dataBase);
	   	return dataBase;
    }	
	
	private boolean isUserAlreadyRegistered (NewUserInfo user) {
		boolean result = false;
		for (NewUserInfo registredUsers : dataBase.getDataBase()) {
		if (user.equals(registredUsers)) {
			result = true;
		    }
		}
		return result;				
	}

	//@Override
	//public boolean logination(String login, String password) throws DaoException {		
		/*
		 * Random rand = new Random(); int value = rand.nextInt(1000);
		 * 
		 * if(value % 3 == 0) { try { throw new SQLException("stub exception");
		 * }catch(SQLException e) { throw new DaoException(e); } }else if (value % 2 ==
		 * 0) { return true; }else { return false; }
		 */		
		//return true;		
	//}
	
	//public String getRole(String login, String password) {
	//	return "user";
	//}

	//@Override
	//public boolean registration(NewUserInfo user) throws DaoException  {
		//NewUserInfo findUser = userDao.findByLogin(user.getLogin()); 
		// TODO Auto-generated method stub
	//	return true;
	//}
}