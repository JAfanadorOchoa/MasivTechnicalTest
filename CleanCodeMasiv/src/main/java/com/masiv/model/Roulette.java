package com.masiv.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roulette")
public class Roulette {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	@Id
	private long id;
	private boolean status;
	
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
