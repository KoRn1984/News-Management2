package by.itacademy.matveenko.jd2.dao;

public class NewsDaoException extends Exception{
	private static final long serialVersionUID = 1L;

	public NewsDaoException(String message) {
		super(message);
	}
	
	public NewsDaoException(String message, Exception e) {
		super(message, e);
	}
}