package com.co.lulobank;

import java.util.ArrayList;
import java.util.Date;

import com.co.lulobank.dominio.modelo.transaction;

public class transactionTestDataBuillder {
	public int id;
	public String merchant;
	public Double amount;
	public Date  time;
	public int idAccount;
	private ArrayList<String>  violations;
	

   @SuppressWarnings("deprecation")
	public transactionTestDataBuillder( ) {
		this.id=1;
		this.merchant="Burger King";
		this.amount=2000.0;
		this.time = null;
		this.idAccount=2;
		 this.violations=null;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	

	public ArrayList<String> getViolations() {
		return violations;
	}

	public void setViolations(ArrayList<String> violations) {
		this.violations = violations;
	}
	
	public transaction build() {
		return new transaction(  id, merchant, amount, time,idAccount,violations);
	}
}
