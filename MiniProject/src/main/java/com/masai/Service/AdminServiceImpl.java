package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.AdminException;
import com.masai.Repository.AdminRepo;
import com.masai.pojo.Admin;
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepo adrepo;

	@Override
	public Admin saveUser(Admin user) throws AdminException {
		// TODO Auto-generated method stub
		Optional<Admin> ad=adrepo.findById(user.getAdminId());
		if(ad.isPresent())
		{
			throw new AdminException("User already exist");
		}
		
		Admin ad1=adrepo.save(user);
		return ad1;
	}

	@Override
	public Admin updateUser(Admin user) throws AdminException {
		// TODO Auto-generated method stub
		Optional<Admin> ad=adrepo.findById(user.getAdminId());
		if(ad.isEmpty())
		{
			throw new AdminException("User with this id does not exist");
		}
		else
		{
			Admin ad1=adrepo.save(user);
			return ad1;
		}
		
	}

	@Override
	public Admin deleteUser(String adminUsername) throws AdminException {
		// TODO Auto-generated method stub
		Admin ad=adrepo.findByAdminUsername(adminUsername);
		if(ad!=null)
		{
			adrepo.delete(ad);
			return ad;
			
		}
		else
		{
			throw new AdminException("User with this adminUsername does not exist");	
		}
		
	}

	@Override
	public Admin findByAdminId(Integer adminId) throws AdminException {
		// TODO Auto-generated method stub
		
		Optional<Admin> ad=adrepo.findById(adminId);
		if(ad.isEmpty())
		{
			throw new AdminException("User with this id does not exist");
		}
		else
		{
			
			return ad.get();
		}
	
	}

	@Override
	public Admin findByUserName(String adminUserName) throws AdminException {
		// TODO Auto-generated method stub
		Admin ad=adrepo.findByAdminUsername(adminUserName);
		if(ad!=null)
		{
			adrepo.delete(ad);
			return ad;
			
		}
		else
		{
			throw new AdminException("User with this adminUsername does not exist");	
		}
	}

	@Override
	public List<Admin> findAllUsers() throws AdminException {
		// TODO Auto-generated method stub
		List<Admin> list=adrepo.findAll();
		if(list!=null)
		{
			return list;
		}
		else
		{
			throw new AdminException("Admins do not found");
		}
		
	}

}
