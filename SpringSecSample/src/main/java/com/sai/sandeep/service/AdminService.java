package com.sai.sandeep.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Secured("ROLE_ADMIN")
	public void performAdminService(){
		System.out.println("Perform some admin service");
		//Only users with Admin role can access this method
	}
}
