package by.itacademy.matveenko.jd2.dao;

import by.itacademy.matveenko.jd2.bean.NewUserInfo;
import by.itacademy.matveenko.jd2.bean.UserRole;

public interface IUserDao {
	
	NewUserInfo logination(String login, String password) throws DaoException;
	boolean registration(NewUserInfo user) throws DaoException;
	public UserRole getUserRole(String login, String password) throws DaoException;
}