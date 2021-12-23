package com.co.lulobank.dominio.modelo;


import java.util.ArrayList;

import lombok.Data; 

public class account {
 private int id;
 private Boolean activeCard;
 private Double availableLimit;
 private ArrayList<String>  violations;
 
 public account() { 
 }
 
 public account(
 int id,
 Boolean activeCard,
 Double availableLimit,
 ArrayList<String>  violations) {
	 this.id=id;
	 this.activeCard=activeCard;
	 this.availableLimit=availableLimit;
	 this.violations=violations;
	 
	 
 }

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Boolean getActiveCard() {
	return activeCard;
}

public void setActiveCard(Boolean activeCard) {
	this.activeCard = activeCard;
}

public Double getAvailableLimit() {
	return availableLimit;
}

public void setAvailableLimit(Double availableLimit) {
	this.availableLimit = availableLimit;
}
 


public ArrayList<String> getViolations() {
	return violations;
}

public void setViolations(ArrayList<String> violations) {
	this.violations = violations;
}

@Override
public String toString(){
   return "p1: "+id;
}

 
}
