package com.masiv.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.masiv.model.Bet;

public interface BetRepository extends MongoRepository<Bet, Long> {

	public Bet findBetById(long id);
}
