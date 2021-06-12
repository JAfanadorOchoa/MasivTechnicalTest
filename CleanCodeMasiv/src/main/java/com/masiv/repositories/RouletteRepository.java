package com.masiv.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.masiv.model.Roulette;

public interface RouletteRepository extends MongoRepository<Roulette, Long> {

	public Roulette findRouletteById(Long id);
}
