package com.masiv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masiv.model.Roulette;
import com.masiv.services.RouletteServices;

@RestController
public class RouletteController {
	
	@Autowired
	public RouletteServices rouletteServices;
	
	@PostMapping(value = "/create")
	public String createRoulette(@RequestBody Roulette roulette) {
		Roulette insertedRoulette = rouletteServices.createRoulette(roulette);
		return "The roulette was created with the following id: " + insertedRoulette.getId();
	}
	
	@PutMapping(value = "/open/{id}")
	public String openRoulette(@PathVariable("id") Long id) {
		String status = rouletteServices.openRoulette(id);
		return status;
	}
	
}
