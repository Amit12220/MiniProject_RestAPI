package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.pojo.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

	public Admin findByAdminUsername(String userName);

}
