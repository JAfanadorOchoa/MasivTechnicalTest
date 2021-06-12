package com.masiv.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bet")
public class Bet {

	private long idBet;
	private long idUser;
	private int betNumber;
	private String color;
	private double cashAmount;
	public Bet() {
		super();
	}
	public Bet(long idBet, long idUser, int number, double cashAmount) {
		super();
		this.idBet = idBet;
		this.idUser = idUser;
		this.betNumber = number;
		this.cashAmount = cashAmount;
	}
	public Bet(long idBet, long idUser, String color, double cashAmount) {
		super();
		this.idBet = idBet;
		this.idUser = idUser;
		this.color = color;
		this.cashAmount = cashAmount;
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
	
	
}
