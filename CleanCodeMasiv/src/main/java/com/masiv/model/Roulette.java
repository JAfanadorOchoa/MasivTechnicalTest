package com.masiv.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roulette")
public class Roulette {
	
	@Id
	private long id;
	private boolean status;
	@DBRef(db = "bet")
	private Set<Bet> betList = new HashSet<Bet>();
	
	public Roulette() {
		super();
	}
	
	public Roulette(long id) {
		super();
		this.id = id;
		this.status = false;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

}
