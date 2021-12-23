package com.co.lulobank.infraestructura.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.co.lulobank.dominio.repositorio.accountRepository;

import com.co.lulobank.dominio.servicios.createAccount;
import com.co.lulobank.dominio.servicios.JoinTransactionAccount;
import com.co.lulobank.aplicacion.command.commandTransaction;
import com.co.lulobank.dominio.repositorio.transactionReporitory;

@Configuration
public class configuradorBean {

	
	@Bean
    public createAccount createdAccount(accountRepository rAcccount){
        return new createAccount(rAcccount);

	}
	
	
	@Bean
	@Primary
    public JoinTransactionAccount createdTransaction(transactionReporitory serviceTransaction,accountRepository accRepoIns){
        return new JoinTransactionAccount(serviceTransaction,accRepoIns);

	}
	
	
	
}
