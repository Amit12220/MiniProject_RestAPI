package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Exception.AdminException;
import com.masai.Exception.UserException;
import com.masai.Repository.UserRepo;
import com.masai.pojo.Admin;
import com.masai.pojo.User;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userrepo;
	

	@Override
	public User saveUser(User user) throws UserException {
		// TODO Auto-generated method stub
		Optional<User> ad=userrepo.findById(user.getUserId());
		if(ad.isPresent())
		{
			throw new UserException("User already exist");
		}
		
		User ad1=userrepo.save(user);
		return ad1;
	}

	@Override
	public User updateUser(User user) throws UserException {
		// TODO Auto-generated method stub
		Optional<User> ad=userrepo.findById(user.getUserId());
		if(ad.isEmpty())
		{
			throw new UserException("User with this id does not exist");
		}
		else
		{
			User ad1=userrepo.save(user);
			return ad1;
		}
		
	}

	@Override
	public User deleteUser(String username) throws UserException {
		// TODO Auto-generated method stub
		User ad=userrepo.findByUserName(username);
		if(ad!=null)
		{
			userrepo.delete(ad);
			return ad;
			
		}
		else
		{
			throw new UserException("User with this Username does not exist");	
		}
	}

	@Override
	public User findByUserLoginId(Integer userLoginId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String email) throws UserException {
		// TODO Auto-generated method stub
		User ad=userrepo.findByEmail(email);
		if(ad!=null)
		{
			
			return ad;
			
		}
		else
		{
			throw new UserException("User with this Email does not exist");	
		}
	}

	@Override
	public User findByUserName(String userName) throws UserException {
		// TODO Auto-generated method stub
		User ad=userrepo.findByUserName(userName);
		if(ad!=null)
		{
			
			return ad;
			
		}
		else
		{
			throw new UserException("User with this UserName does not exist");	
		}
	}

	@Override
	public User findByUserNameOrEmail(String userName, String email) throws UserException {
		// TODO Auto-generated method stub
		User ad=userrepo.findByUserNameOrEmail(userName, email);
		if(ad!=null)
		{
			
			return ad;
			
		}
		else
		{
			throw new UserException("User with this UserName or Email does not exist");	
		}
	}

	@Override
	public List<User> findAllUsers() throws UserException {
		// TODO Auto-generated method stub
		List<User> list=userrepo.findAll();
		if(list!=null)
		{
			return list;
		}
		else
		{
			throw new UserException("Users do not found");
		}
	}

}
