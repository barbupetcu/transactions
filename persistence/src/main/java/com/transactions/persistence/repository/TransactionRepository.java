package com.transactions.persistence.repository;

import com.transactions.persistence.model.Transaction;
import com.transactions.persistence.model.projection.TransactionDetailsDto;
import com.transactions.persistence.model.projection.TransactionTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("select new com.transactions.persistence.model.projection.TransactionTypeDto(t.type, count(t), sum(t.amount)) " +
            "from Transaction t where t.payer.cnp = :cnp group by t.type")
    List<TransactionTypeDto> getAggTransactionsByUser (@Param("cnp") String cnp);

    @Query("select new com.transactions.persistence.model.projection.TransactionDetailsDto(t.description, t.amount, t.payer.name, t.payer.cnp, t.payer.iban)" +
            " from Transaction t where t.type = :type and t.payer.cnp = :cnp")
    List<TransactionDetailsDto> getDetailedTranByTypeAndCnp(@Param("type") String type, @Param("cnp") String cnp);




}
