package com.masiv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.masiv.model.Bet;
import com.masiv.services.BetServices;

@RestController
public class BetController {

	@Autowired
	public BetServices betServices;
	
	@PostMapping(value = "/place")
	public String placeBet(@RequestBody Bet bet, @RequestHeader Long idUser) {
		bet.setIdUser(idUser);
		String betStatus = betServices.placeBet(bet);
		return betStatus;
	}
	
}
