package com.co.lulobank.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.lulobank.dominio.modelo.transaction;

import com.co.lulobank.aplicacion.command.commandTransaction;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class controllerTransaction {

	@Autowired
	private commandTransaction transActionComm;
	
	@PostMapping("/transaction")
	public ResponseEntity<transaction> createdtransaction(@RequestBody transaction transactionModel) {

		try {
			System.out.println ("createdtransaction ll");
		return new ResponseEntity<>(this.transActionComm.createdTransaction(transactionModel),HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}

		

	 	
	 
}
