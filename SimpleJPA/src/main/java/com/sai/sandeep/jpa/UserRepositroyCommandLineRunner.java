package com.sai.sandeep.jpa;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sai.sandeep.jpa.entities.User;
import com.sai.sandeep.jpa.service.UserDaoService;
import com.sai.sandeep.jpa.service.UserRepository;

@Component
public class UserRepositroyCommandLineRunner implements CommandLineRunner {

	private static final Logger log = (Logger) LoggerFactory.getLogger(UserRepositroyCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Sandeep", "Admin");
		userRepository.save(user);
		log.info("New user is created"+user);
		
		Optional<User> retrieve = userRepository.findById(1L);
		log.info("User is retrived"+retrieve);
		
		List<User> findAll = userRepository.findAll();
		log.info("All users"+findAll);
		



	}

}
