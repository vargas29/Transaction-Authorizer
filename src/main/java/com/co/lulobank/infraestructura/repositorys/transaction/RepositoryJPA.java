package com.co.lulobank.infraestructura.repositorys.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.co.lulobank.dominio.modelo.transaction;
import com.co.lulobank.dominio.repositorio.transactionReporitory;
import com.co.lulobank.infraestructura.entidades.transactionEntity;

import com.co.lulobank.infraestructura.mapping.transactionMapping;

@Repository
public class RepositoryJPA  implements transactionReporitory{
	
	@Autowired
	private repoMemoryH2 repTransaction;
	private transactionMapping mapTransaction;
	
	public RepositoryJPA(repoMemoryH2 repTransaction, transactionMapping mapTransaction) {
		this.repTransaction= repTransaction;
		this.mapTransaction=mapTransaction;
	}
	

	@Transactional
	public transaction createdtransaction(transaction transactionData) {
		System.out.println ("---------createdtransaction----");
		transactionEntity eTransaction = this.repTransaction.save(mapTransaction.convertToEntity(transactionData));
		return mapTransaction.convertToDomain(eTransaction);
	}

}
