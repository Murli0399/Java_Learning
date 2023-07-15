package dao;

import entities.User;
import exceptions.UserException;

public interface UserDAO {

	void addUser(User user) throws UserException;
    
	User getUserById(int id) throws UserException;
    
	void updateUser(User user) throws UserException;
    
	void deleteUser(User user) throws UserException;
}
