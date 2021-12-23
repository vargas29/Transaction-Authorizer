package com.co.lulobank.infraestructura.entidades;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="account")
@Data
public class accountEntiti {

	@Id
	@Column 
	 private int id;
	@Column
	 private Boolean activeCard;
	@Column
	 private Double availableLimit;
	@Column
	private ArrayList<String> violations;
	
	
	
 public accountEntiti() {
		 
	 }
	 
	public accountEntiti(
	 int id,
	 Boolean activeCard,
	 Double availableLimit,
	 ArrayList<String> violations) {
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

	public Boolean getactiveCard() {
		return activeCard;
	}

	public void setactiveCard(Boolean activeCard) {
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
	 
	 
	
}
