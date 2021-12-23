package com.co.lulobank.infraestructura.repositorys.transaction;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.lulobank.infraestructura.entidades.transactionEntity;

@Repository
public interface repoMemoryH2 extends CrudRepository<transactionEntity, Integer> {

}
