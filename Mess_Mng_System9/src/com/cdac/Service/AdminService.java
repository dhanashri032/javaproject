package com.cdac.Service;

import com.cdac.dto.Admin;

public interface AdminService {

	void addAdmin(Admin admin);
	boolean findAdmin(Admin admin);
	String forgotPassword(String userName);
}
