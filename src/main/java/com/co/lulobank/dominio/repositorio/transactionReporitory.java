package com.co.lulobank.dominio.repositorio;


import org.springframework.stereotype.Repository;

import com.co.lulobank.dominio.modelo.transaction;


@Repository
public interface transactionReporitory {
	
	
	public transaction createdtransaction(transaction transactionData);
	

}
