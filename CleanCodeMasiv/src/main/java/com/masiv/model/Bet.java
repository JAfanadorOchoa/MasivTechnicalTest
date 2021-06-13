package com.masiv.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bet")
public class Bet {

	private long idBet;
	private long idUser;
	private long idRoulette;
	private double cashAmount;
	private int betNumber;
	private String color;
	
	
	public Bet() {
		super();
	}
	
	public Bet(long idBet, long idUser, long idRoulette, double cashAmount, int betNumber) {
		super();
		this.idBet = idBet;
		this.idUser = idUser;
		this.idRoulette = idRoulette;
		this.cashAmount = cashAmount;
		this.betNumber = betNumber;
	}

	public Bet(long idBet, long idUser, long idRoulette, double cashAmount, String color) {
		super();
		this.idBet = idBet;
		this.idUser = idUser;
		this.idRoulette = idRoulette;
		this.cashAmount = cashAmount;
		this.color = color;
	}

	public long getIdBet() {
		return idBet;
	}
	public void setIdBet(long idBet) {
		this.idBet = idBet;
	}
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public int getNumber() {
		return betNumber;
	}
	public void setNumber(int betNumber) {
		this.betNumber = betNumber;
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
