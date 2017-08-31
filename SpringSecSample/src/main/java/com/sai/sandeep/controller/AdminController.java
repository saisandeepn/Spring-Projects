package com.sai.sandeep.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	@RequestMapping(value="/admin", method= RequestMethod.GET)
	public String adminPage(ModelMap map, Principal principal){
		//System.out.println(principal.getName());
		return "admin";
		
	}
}
