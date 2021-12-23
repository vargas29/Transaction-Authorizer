package com.co.lulobank.infraestructura.entidades;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class transactionEntity {
	
	
		
		@Id
		@Column 
		public int id;
		@Column
		public String merchant;
		@Column
		public Double amount;
		@Column
		public Date  time;
		@Column
		public int idAccount;
		@Column
		private ArrayList<String> violations;
		
		public transactionEntity() {}
		
		public transactionEntity( int id,
				 String merchant,
				 Double amount,
				 Date  time,
				 int idAccount,
				 ArrayList<String> violations) {
			this.id=id;
			this.merchant=merchant;
			this.amount=amount;
			this.time=time;
			this.idAccount=idAccount;
			this.violations=violations;
		}

		
		public ArrayList<String> getViolations() {
			return violations;
		}

		public void setViolations(ArrayList<String> violations) {
			this.violations = violations;
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

		

}
