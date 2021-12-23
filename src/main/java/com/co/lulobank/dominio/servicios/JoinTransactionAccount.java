package com.co.lulobank.dominio.servicios;


import com.co.lulobank.dominio.repositorio.transactionReporitory;
import com.co.lulobank.dominio.repositorio.accountRepository;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.co.lulobank.dominio.constants;
import com.co.lulobank.dominio.modelo.transaction;
import com.co.lulobank.dominio.modelo.account;

@Service
public class JoinTransactionAccount {

	private transactionReporitory repoTransaction;
	private accountRepository accRepoIns;
	private int num;
	private Date dtlastTr;
	
	

	public JoinTransactionAccount(transactionReporitory repoTransaction,accountRepository accRepoIns) {
		this.repoTransaction=repoTransaction;
		this.accRepoIns=accRepoIns;
		
	}
	
	private ArrayList<String> getViolations(transaction transaction) {
		ArrayList<String> violations=new ArrayList<String>();
		account dataAcc =accRepoIns.findAccountActive(transaction.getId());
		
		if(dataAcc.getActiveCard() == false) {
			violations.add(constants.CARD_NOT_ACTIVE);
		}
		if(dataAcc.getActiveCard() == null || dataAcc.getActiveCard() == null || dataAcc.getAvailableLimit() == null) {
			violations.add(constants.NOT_INITIALIZED);
		}
		
		violations.add(validateBusinessRules(transaction));
		violations.add(validateFrecuencyInterval(transaction.getTime()));
		
		
		 return violations;
	}
	private Boolean validateUpdateAmount(int id ,Double amountNew) {
		double amountUpdate,amountOld;
		account data=accRepoIns.findAccountActive(id);
		amountOld =data.getAvailableLimit();
		
		 System.out.println (data.getAvailableLimit());
		 if(amountOld > amountNew) {
			 amountUpdate = amountOld-amountOld;
			 data.setAvailableLimit(amountUpdate);
			 accRepoIns.createdAccount(data);
			 System.out.println ("mayor");
			 return true;
		 }
		return false;
		
	}
	

	private String validateBusinessRules(transaction dataTransaction) {
		
		Boolean resUpdateA =validateUpdateAmount(dataTransaction.getId(),dataTransaction.getAmount());
	
		if(resUpdateA == false ) {
			return constants.INSUFFICENT_LIMIT;
		}
		
		
		 return null;
	}

	private String validateFrecuencyInterval(Date dtGetTime) {
		if(num > 3 && dtlastTr.after(dtGetTime)  ) {
			num=0;
			dtlastTr=null;
			return constants.HIGH_FRECUENCY;
		}
		return null;
		
	}
	
	public void updateInfoTrans(Date dt) {
		if(num == 0) {
			Date dtTem = dt;
			dtTem.setMinutes(dtTem.getMinutes()+2);
			dtlastTr =dtTem;
		}
		num++;
		
	}
	
	 public transaction createdTransaction(transaction transaction) {
		 System.out.println (num);
		 updateInfoTrans(transaction.getTime());
		
		 
		transaction.setViolations(getViolations(transaction));
		
		return this.repoTransaction.createdtransaction(transaction);
		
	}
	
	
	
	

}
