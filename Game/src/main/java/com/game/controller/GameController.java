package com.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.game.entity.Game;
import com.game.repository.GameRepository;

@RestController
@RequestMapping("/text")
public class GameController {
	
	@Autowired
	private GameRepository gameRepository;
	
	@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = { "application/json" })
    public List<Game> save(@RequestBody List<Game> games) {
        List<Game> savedGames = gameRepository.saveAll(games);
        return savedGames;
    }
	
	@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json" })
	public List<Game> getAll(){
		List<Game> user = gameRepository.findAll();
		return user;
	}

}
