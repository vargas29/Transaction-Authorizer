package com.co.lulobank.dominio.repositorio;

import org.springframework.stereotype.Repository;

import com.co.lulobank.dominio.modelo.account;

@Repository
public interface  accountRepository {
	
	public account createdAccount(account accountData);
	
	public account findAccountActive(int id);

}
