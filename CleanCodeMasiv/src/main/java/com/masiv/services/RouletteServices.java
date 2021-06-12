package com.masiv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masiv.model.Roulette;
import com.masiv.repositories.RouletteRepository;

@Service
public class RouletteServices {

	@Autowired
	public RouletteRepository rouletteRepository;
	
	public Roulette createRoulette(Roulette roulette) {
		return rouletteRepository.save(roulette);
	}

	public String openRoulette(Long id) {
		Roulette newRoulette = rouletteRepository.findRouletteById(id);
		if(newRoulette != null) {		
		if(newRoulette.isStatus()) {
			return "Error: The roulette is already open";
		}else {
			newRoulette.setStatus(true);
			rouletteRepository.save(newRoulette);
			return "Successfull: The roulette has been opened";
		}
		}else
			return "Error: The roulette does not exist";
	}
}
