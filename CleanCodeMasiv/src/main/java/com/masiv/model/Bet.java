package com.masiv.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bet")
public class Bet {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	@Id
	private long id;
	private long idUser;
	private long idRoulette;
	private double cashAmount;
	private int betNumber = -1;
	private String color;
	
	public Bet() {
		super();
	}
	
	public Bet(long id, long idUser, long idRoulette, double cashAmount, int betNumber) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idRoulette = idRoulette;
		this.cashAmount = cashAmount;
		this.betNumber = betNumber;
	}

	public Bet(long id, long idUser, long idRoulette, double cashAmount, String color) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idRoulette = idRoulette;
		this.cashAmount = cashAmount;
		this.color = color;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
		public String isColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public long getIdRoulette() {
		return idRoulette;
	}

	public void setIdRoulette(long idRoulette) {
		this.idRoulette = idRoulette;
	}

	public int getBetNumber() {
		return betNumber;
	}

	public void setBetNumber(int betNumber) {
		this.betNumber = betNumber;
	}

	public String getColor() {
		return color;
	}
	
	
}
