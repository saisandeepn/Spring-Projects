package com.sai.sandeep.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sai.sandeep.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/admin", method= RequestMethod.GET)
	public String adminPage(ModelMap map, Principal principal){
		//System.out.println(principal.getName());
		return "admin";
		
	}
	
	@RequestMapping(value="/adminservice", method= RequestMethod.GET)
	public String adminServicePage(ModelMap map){
		adminService.performAdminService();
		return "admin";
		
	}
}
