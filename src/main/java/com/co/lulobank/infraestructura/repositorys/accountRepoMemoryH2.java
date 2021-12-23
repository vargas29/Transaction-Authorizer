package com.co.lulobank.infraestructura.repositorys;

import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.lulobank.infraestructura.entidades.accountEntiti;

public interface accountRepoMemoryH2  extends CrudRepository<accountEntiti, Integer>{
	
	@Query("SELECT p FROM accountEntiti p WHERE p.id = :id")
	accountEntiti findAccountActive(@Param("id") int id);
	
	 
}
