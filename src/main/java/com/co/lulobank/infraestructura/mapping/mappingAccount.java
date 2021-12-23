package com.co.lulobank.infraestructura.mapping;



import org.springframework.stereotype.Component;

import com.co.lulobank.dominio.modelo.account;
import com.co.lulobank.infraestructura.entidades.accountEntiti;
@Component
public class mappingAccount {

	public account convertToDomain(accountEntiti eAccount ){
	
		account account;

		if (eAccount == null) {
		
			account = null;
		} else {
			account = new account(eAccount.getId(),eAccount.getactiveCard(),eAccount.getAvailableLimit(),eAccount.getViolations());
			}

		return account;
	}

	public accountEntiti convertToEntity(account account) {
		accountEntiti eAccount;
		
		if (account == null) {
			
			eAccount = null;
		} else {
		
			eAccount = new accountEntiti(account.getId(),account.getActiveCard(),account.getAvailableLimit(),account.getViolations());
		}
		return eAccount;

	}
	
}
