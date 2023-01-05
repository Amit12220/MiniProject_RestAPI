package com.masai.Service;

import java.util.List;

import com.masai.Exception.AdminException;
import com.masai.pojo.Admin;



public interface AdminService {
	
	public Admin saveUser(Admin user) throws AdminException;

	public Admin updateUser(Admin user) throws AdminException;

	public Admin deleteUser(String adminUsername) throws AdminException;

	public Admin findByAdminId(Integer adminId) throws AdminException;

	public Admin findByUserName(String adminUserName) throws AdminException;

	public List<Admin> findAllUsers() throws AdminException;

}
