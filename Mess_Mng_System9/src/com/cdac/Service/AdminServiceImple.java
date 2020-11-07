package com.cdac.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.AdminDao;
import com.cdac.dto.Admin;

@Service
public class AdminServiceImple implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public void addAdmin(Admin admin) {
		adminDao.insertAdmin(admin);
		
	}

	@Override
	public boolean findAdmin(Admin admin) {
		return adminDao.checkAdmin(admin);
	}

	@Override
	public String forgotPassword(String userName) {
		return adminDao.forgetPassword(userName);
	}

}
