package com.masiv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masiv.model.Bet;
import com.masiv.model.Roulette;
import com.masiv.repositories.BetRepository;

@Service
public class BetServices {

	@Autowired
	public BetRepository betRepository;
	
	@Autowired
	public RouletteServices rouletteServices;
	
	public boolean verifyBet(Bet bet) {
		Roulette newRoulette = rouletteServices.getRoulette(bet.getIdRoulette());
		if(newRoulette == null || !newRoulette.isStatus() || bet.getCashAmount() > 10000) {
			return false;
		}
			return true;
		}
	
	public String placeBet(Bet bet) {
		if(verifyBet(bet)) {
			Bet newBet = betRepository.save(bet);
			if(newBet != null) {
				return "The bet was created succesfully";
			}else
				return "The bet was not created successfully";
		}else
			return "The data provided is not correct";
		
	}	
		
	
}
