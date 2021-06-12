package com.masiv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masiv.model.Bet;
import com.masiv.repositories.BetRepository;

@Service
public class BetServices {

	@Autowired
	public BetRepository betRepository;
	
	public String placeBet(Bet bet) {
		Bet newBet = betRepository.save(bet);
		if(newBet != null) {
			return "The bet was created succesfully";
		}else
			return "The bet was not created successfully";
	}
}
