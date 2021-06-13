package com.masiv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping(value = "/roulette/create")
	public String createRoulette(@RequestBody Roulette roulette) {
		Roulette insertedRoulette = rouletteServices.createRoulette(roulette);
		return "The roulette was created with the following id: " + insertedRoulette.getId();
	}
	
	@PutMapping(value = "/roulette/open/{id}")
	public String openRoulette(@PathVariable("id") Long id) {
		String status = rouletteServices.openRoulette(id);
		return status;
	}
	
	@GetMapping(value = "/roulette/close/{id}")
	public ResponseEntity<List<Object>> closeRoulette(@PathVariable("id") Long id){
		List<Object> newList = rouletteServices.closeRoulette(id);
		return ResponseEntity.ok(newList);
	}
	
	@GetMapping(value = "/roulette/showAll")
	public ResponseEntity<List<Object>> showAllRoulette(){
		List<Object> roulettes = rouletteServices.showAll();
		return ResponseEntity.ok(roulettes);
	}
	
}
