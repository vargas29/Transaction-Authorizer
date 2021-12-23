package com.co.lulobank.infraestructura.mapping;

import org.springframework.stereotype.Component;

import com.co.lulobank.dominio.modelo.transaction;
import com.co.lulobank.infraestructura.entidades.transactionEntity;
@Component
public class transactionMapping {

	public transaction convertToDomain(transactionEntity eTransaction ){
		
		transaction transaction;

		if (eTransaction == null) {
		
			transaction = null;
		} else {
			transaction = new transaction(eTransaction.getId(),eTransaction.getMerchant(),eTransaction.getAmount(),eTransaction.getTime(),eTransaction.getIdAccount(),eTransaction.getViolations());
			}

		return transaction;
	}

	public transactionEntity convertToEntity(transaction transaction) {
		transactionEntity eTransaction;
		
		if (transaction == null) {
			
			eTransaction = null;
		} else {
		
			eTransaction = new transactionEntity(transaction.getId(),transaction.getMerchant(),transaction.getAmount(),transaction.getTime(),transaction.getIdAccount(),transaction.getViolations());
		}
		return eTransaction;

	}
}
