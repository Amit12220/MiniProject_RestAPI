package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.pojo.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	public User findByUserName(String username);
	
	public User findByEmail(String email);
	
	

	public User findByUserNameOrEmail(String userName, String email);
	
}
