package com.sai.sandeep.rest.webservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	public static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "Sai", new Date()));
		users.add(new User(2, "Sandeep", new Date()));
		users.add(new User(3, "Vasantha", new Date()));
	}
	private static int userCount = 3;

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users)
			if (user.getId() == id)
				return user;
		return null;

	}

}
