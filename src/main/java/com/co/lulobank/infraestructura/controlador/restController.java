package com.co.lulobank.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.lulobank.aplicacion.command.commandAccount;
import com.co.lulobank.dominio.modelo.account;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class restController {
	
	@Autowired
	private commandAccount commAccount;

	
	
	
	@PostMapping("/account")
	public ResponseEntity<account> createdAccount(@RequestBody account accountModel) {

		try {
			System.out.println ("createdAccount");
		return new ResponseEntity<>(this.commAccount.createdAccount(accountModel),HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}

		

	 	
	 


}
