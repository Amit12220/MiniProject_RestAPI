package com.masai.Service;

import java.util.List;

import com.masai.Exception.UserException;
import com.masai.pojo.User;



public interface UserService {
	
	public User saveUser(User user) throws UserException;

	public User updateUser(User user) throws UserException;

	public User deleteUser(String username) throws UserException;

	public User findByUserLoginId(Integer userLoginId) throws UserException;

	public User findByEmail(String email) throws UserException;

	public User findByUserName(String userName) throws UserException;

	public User findByUserNameOrEmail(String userName, String email) throws UserException;

	public List<User> findAllUsers() throws UserException;

}
