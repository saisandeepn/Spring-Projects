package com.sai.sandeep;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sai.sandeep.domain.Player;
import com.sai.sandeep.domain.Team;

@RestController
public class WelcomeController {

	private Team team;
	
	@PostConstruct
	public void init(){
		Set<Player> players = new HashSet<>();
		players.add(new Player("Sai","Batsman"));
		players.add(new Player("Sandeep","Bowler"));
		players.add(new Player("Vasantha","WicketKeeper"));

		team = new Team("India","Hyderabad",players);

	}
	@RequestMapping("/welcome")
	public Team welcomeTeam(){
		return team;
	}
	 
/*	@RequestMapping("/welcome/{name }")
	public String welcome(Map model, @PathVariable String name){
		model.put("name", name);
		return "welcome";
	}*/
	
	
}
