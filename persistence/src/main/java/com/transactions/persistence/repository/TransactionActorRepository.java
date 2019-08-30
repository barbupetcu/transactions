package com.transactions.persistence.repository;

import com.transactions.persistence.model.TransactionActor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionActorRepository extends JpaRepository<TransactionActor, Long> {

    TransactionActor findByCnp(String cnp);

}
