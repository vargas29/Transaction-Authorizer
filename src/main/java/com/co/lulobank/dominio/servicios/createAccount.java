package com.co.lulobank.dominio.servicios;


import java.util.ArrayList;



import com.co.lulobank.dominio.constants;
import com.co.lulobank.dominio.modelo.account;

import com.co.lulobank.dominio.repositorio.accountRepository;

public class createAccount {
	
	private accountRepository accRepoIns;

	
	public createAccount(accountRepository accRepoIns) {
		this.accRepoIns=accRepoIns;
		
	}
	
	public account createdAccount(account account) {
		ArrayList<String> list=getViolations(account.getId());
		
	 account.setViolations(list);
	 return this.accRepoIns.createdAccount(account);
		
	}
	
	private ArrayList<String> getViolations(int id) {
		ArrayList<String> violations=new ArrayList<String>();
		
		if(validateActiveAccount(id) == true ) {
			violations.add(constants.ALREADY_INITIALIZED);
		}
		
		 return violations;
	}
	
	private Boolean validateActiveAccount(int  id) {
		account  accountActive =this.accRepoIns.findAccountActive(id);
		System.out.println (accountActive);
		if(accountActive != null && accountActive.getActiveCard() == true) {
			return true;
		}
		return false;
	}
	
	
	
}
