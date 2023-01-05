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

import com.masai.Exception.AdminException;
import com.masai.Service.AdminService;
import com.masai.pojo.Admin;

@RestController
public class adminController {
	
	@Autowired
	private AdminService adserv;
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> saveUser(@RequestBody Admin user) throws AdminException
	{
		Admin ad=adserv.saveUser(user);
		return new ResponseEntity<Admin>(ad, HttpStatus.CREATED);
	}

	@PutMapping("/admin")
	public ResponseEntity<Admin> updateUser(@RequestBody Admin user) throws AdminException
	{
		Admin ad=adserv.updateUser(user);
		return new ResponseEntity<Admin>(ad, HttpStatus.OK);
	}

	@DeleteMapping("/admin/{adminUsername}")
	public ResponseEntity<Admin> deleteUser(@PathVariable ("adminUsername") String adminUsername) throws AdminException
	{
		Admin ad=adserv.deleteUser(adminUsername);
		return new ResponseEntity<Admin>(ad, HttpStatus.OK);
	}

	@GetMapping("/adminId/{adminId}")
	public ResponseEntity<Admin> findByAdminId( @PathVariable ("adminId") Integer adminId) throws AdminException
	{
		Admin ad=adserv.findByAdminId(adminId);
		return new ResponseEntity<Admin>(ad, HttpStatus.OK);
	}

	@GetMapping("/admin/{adminUserName}")
	public ResponseEntity<Admin> findByUserName(@PathVariable ("adminUsername") String adminUserName) throws AdminException
	{
		Admin ad=adserv.findByUserName(adminUserName);
		return new ResponseEntity<Admin>(ad, HttpStatus.OK);
	}

	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> findAllUsers() throws AdminException
	{
		Admin ad=(Admin) adserv.findAllUsers();
		return new ResponseEntity<List<Admin>>(HttpStatus.OK);
	}

}
