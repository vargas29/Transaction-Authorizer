package com.co.lulobank.aplicacion.command;

import org.springframework.stereotype.Service;

import com.co.lulobank.dominio.servicios.createAccount;
import com.co.lulobank.dominio.modelo.account;
import com.co.lulobank.dominio.modelo.transaction;

@Service
public class commandAccount {
	private final createAccount  creAccountServ;
	
	
	public commandAccount(createAccount  creAccountServ) {
		this.creAccountServ=creAccountServ;

	}
	
	public account createdAccount(account accountModel) {
		
		return this.creAccountServ.createdAccount(new account(accountModel.getId(),accountModel.getActiveCard(),accountModel.getAvailableLimit(),accountModel.getViolations()));
		
	}
	
	
	
    


}
