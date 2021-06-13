package com.masiv.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.masiv.model.Bet;
import com.masiv.model.Roulette;
import com.masiv.repositories.BetRepository;
import com.masiv.repositories.RouletteRepository;

@Service
public class RouletteServices {

	@Autowired
	public RouletteRepository rouletteRepository;
	
	@Autowired
	public BetRepository betRepository;
	
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
	
	public Roulette getRoulette(Long id) {
		return rouletteRepository.findRouletteById(id);
	}
	
	public List<Object> closeRoulette(Long id){
		Roulette newRoulette = rouletteRepository.findRouletteById(id);
		if(newRoulette == null) {
			return Arrays.asList("The roulette could not be closed because it does not exist");		
		}else if (!newRoulette.isStatus()) {
			return Arrays.asList("The roulette could not be closed because it is already closed");
		}
		else {
			newRoulette.setStatus(false);
			rouletteRepository.save(newRoulette);
			Random randomGenerator = new Random();
			int randomWinnerNumber = randomGenerator.nextInt(37);
			List<Bet> betListForRoulette = betRepository.deleteBetByIdRoulette(id);
			List<Object> mapResponse = new ArrayList<Object>();
			mapResponse.add(Map.entry("winnerNumber", randomWinnerNumber));
			mapResponse.addAll(betListForRoulette.stream().map(bet -> 
			betToMap(bet, randomWinnerNumber)).collect(Collectors.toList())); 
			return mapResponse;
		}
	}
	
	public Map<String, Object> betToMap(Bet bet, int winnerNumber){
		Map<String, Object> newMap = new HashMap<String, Object>();
		double amountWinner = 0;
		if(bet.getBetNumber() == -1) {
			newMap.put("color", bet.getColor());
			if ((bet.getColor().equals("red") && winnerNumber % 2 == 0) || (bet.getColor().equals("black")  
				&& winnerNumber % 2 == 1)) 
				amountWinner = bet.getCashAmount()*1.8;
		}else {
			newMap.put("betNumber", bet.getBetNumber());
			if(bet.getBetNumber() == winnerNumber) {
				amountWinner = bet.getCashAmount()*5;
			}
		}
		newMap.put("idUser", bet.getIdUser());
		newMap.put("amountBet", bet.getCashAmount());
		newMap.put("amountReceived", amountWinner);
		return newMap;
	}
	
	public List<Object> showAll(){
		List<Object> objectList = new ArrayList<Object>();
		List<Roulette> newList = rouletteRepository.findAll();
		for (Roulette roulette : newList) {
			Map<String, Object> newMap = new HashMap<String, Object>();
			newMap.put("id", roulette.getId());
			if(roulette.isStatus())
				newMap.put("status", "Open");
			else
				newMap.put("status", "Closed");
			objectList.add(newMap);
		}
		return objectList;
	}
}
