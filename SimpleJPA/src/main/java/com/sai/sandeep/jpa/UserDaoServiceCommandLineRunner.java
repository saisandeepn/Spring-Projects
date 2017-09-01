package com.sai.sandeep.jpa;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sai.sandeep.jpa.entities.User;
import com.sai.sandeep.jpa.service.UserDaoService;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

	private static final Logger log = (Logger) LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	
	@Autowired
	private UserDaoService userDaoService;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Sai", "Admin");
		long insert = userDaoService.insert(user);
		log.info("New user is created"+user);

	}

}
