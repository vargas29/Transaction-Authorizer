package com.co.lulobank.aplicacion.command;

import org.springframework.stereotype.Service;


import com.co.lulobank.dominio.modelo.transaction;


import com.co.lulobank.dominio.servicios.JoinTransactionAccount;
@Service
public class commandTransaction {
	
	public JoinTransactionAccount  creTransactionServ;

	public commandTransaction(JoinTransactionAccount  creTransactionServ) {
		this.creTransactionServ=creTransactionServ;

	}
	
	public transaction createdTransaction(transaction transactionModel) {
		
		return this.creTransactionServ.createdTransaction(new transaction(transactionModel.getId(),transactionModel.getMerchant(),transactionModel.getAmount(),transactionModel.getTime(),transactionModel.getIdAccount(),transactionModel.getViolations()));
		
	}
	
	

}
