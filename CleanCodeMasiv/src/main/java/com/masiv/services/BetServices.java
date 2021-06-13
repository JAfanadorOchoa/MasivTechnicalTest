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
	
	public String verifyBet(Bet bet) {
		Roulette newRoulette = rouletteServices.getRoulette(bet.getIdRoulette());
		if(newRoulette == null) 
			return "The roulette does not exist";
		if(!newRoulette.isStatus()) 
			return "The roulette is closed";
		if(bet.getCashAmount() > 10000) 
			return "The cash limit is being overflowed";
		if(bet.getBetNumber() < -1  || bet.getBetNumber() > 36)
			return "The number bet is not accepted";
		if (bet.getBetNumber() == -1 && bet.getColor() == (null))
			return "The number bet is not accepted";
		if(bet.getBetNumber() == -1 && (!bet.getColor().equalsIgnoreCase("red") || !bet.getColor().
				equalsIgnoreCase("black")))
			return "The color bet is not available";
		return "correct";
		}
	
	public String placeBet(Bet bet) {
		String verify = verifyBet(bet);
		if(verify.equals("correct")) {
			Bet newBet = betRepository.save(bet);
			if(newBet != null) {
				return "The bet was created succesfully";
			}else
				return "The bet was not created successfully";
		}else
			return verify;
		
	}	
		
	
}
