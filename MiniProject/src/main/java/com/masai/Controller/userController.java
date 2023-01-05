package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.UserException;
import com.masai.Service.UserService;
import com.masai.pojo.User;
@RestController
public class userController {
	
	@Autowired
	private UserService userserv;
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) throws UserException
	{
		User us=userserv.saveUser(user);
		return new ResponseEntity<User>(us,HttpStatus.CREATED);
	}
     
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws UserException
	{
		User us=userserv.updateUser(user);
		return new ResponseEntity<User>(us,HttpStatus.OK);
	}

	@DeleteMapping("/user/{username}")
	public ResponseEntity<User> deleteUser(@PathVariable ("username") String username) throws UserException
	{
		User us=userserv.deleteUser(username);
		return new ResponseEntity<User>(us,HttpStatus.OK);
	}

	@GetMapping("/user/{userid}")
	public ResponseEntity<User> findByUserLoginId(@PathVariable ("userid") Integer userLoginId) throws UserException
	{
		User us=userserv.findByUserLoginId(userLoginId);
		return new ResponseEntity<User>(us,HttpStatus.OK);
	}
	@GetMapping("/user/{useremail}")
	public ResponseEntity<User> findByEmail(@PathVariable ("useremail") String email) throws UserException
	{
		User us=userserv.findByEmail(email);
		return new ResponseEntity<User>(us,HttpStatus.OK);
	}

	@GetMapping("/user/{username}")
	public ResponseEntity<User> findByUserName(@PathVariable ("username") String userName) throws UserException
	{
		User us=userserv.findByUserName(userName);
		return new ResponseEntity<User>(us,HttpStatus.OK);
	}
	@GetMapping("/user/{username}/{useremail}")
	public ResponseEntity<User> findByUserNameOrEmail(@PathVariable ("username") String userName,@PathVariable ("useremail") String email) throws UserException
	{
		User us=userserv.findByUserNameOrEmail(userName, email);
		return new ResponseEntity<User>(us,HttpStatus.OK);
	}
	@GetMapping("/user")
	public ResponseEntity<List<User>> findAllUsers() throws UserException
	{
		List<User> us=userserv.findAllUsers();
		return new ResponseEntity<List<User>>(us,HttpStatus.OK);
	}

}
