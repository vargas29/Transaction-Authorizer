package com.co.lulobank.infraestructura.repositorys;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.co.lulobank.dominio.modelo.account;
import com.co.lulobank.infraestructura.entidades.accountEntiti;
import com.co.lulobank.dominio.repositorio.accountRepository;
import com.co.lulobank.infraestructura.mapping.mappingAccount;
@Repository
public class accountRepoJPA implements  accountRepository{
	@Autowired
	private accountRepoMemoryH2  repoAcount;

	private mappingAccount  mapAccount;
	
	public accountRepoJPA(accountRepoMemoryH2  repoAcount, mappingAccount  mapAccount) {
		this.repoAcount= repoAcount;
		this.mapAccount=mapAccount;
	}
	
	@Transactional
	public account createdAccount(account accountData) {
		accountEntiti eAccount = this.repoAcount.save(mapAccount.convertToEntity(accountData));
		return mapAccount.convertToDomain(eAccount);
	}

	
	@Override
	public account findAccountActive(int id) {
		
		accountEntiti eAccount = this.repoAcount.findAccountActive(id);
		
		return mapAccount.convertToDomain(eAccount);
		
		
	}

}
