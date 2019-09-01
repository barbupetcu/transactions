package com.transactions.persistence.service;

import com.transactions.persistence.model.Transaction;
import com.transactions.persistence.model.TransactionActor;
import com.transactions.persistence.model.projection.ReportDto;
import com.transactions.persistence.model.projection.TransactionTypeDto;
import com.transactions.persistence.repository.TransactionActorRepository;
import com.transactions.persistence.repository.TransactionRepository;
import com.transactions.persistence.util.TypesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class DataPersistenceSerivce {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionActorRepository transactionActorRepository;

    public Transaction saveTransaction(Transaction transaction){
        /*
        * In cazul in care actorii exista deja in baza de date atunci doar le atribuim id-urile
        * Acesta regula merge doar pentru scenariul nostru in care o persoana poate avea doar un IBAN,
        * altfel avem nevoie de o entitate suplimentara Account descrisa in clasa Transaction.java
         */
        TransactionActor dbPayer = transactionActorRepository.findByCnp(transaction.getPayer().getCnp());
        if (dbPayer != null){
            transaction.setPayer(dbPayer);
        }
        TransactionActor dbPayee = transactionActorRepository.findByCnp(transaction.getPayee().getCnp());
        if (dbPayee != null){
            transaction.setPayee(dbPayee);
        }
        transactionRepository.save(transaction);

        return transaction;
    }

    /*
    * Metoda ce returneaza raportul cu tranzactii
     */

    public ReportDto getTransactionReport(String cnp){
        if (StringUtils.isEmpty(cnp)){
            return null;
        }

        TransactionActor transactionActor = transactionActorRepository.findByCnp(cnp);
        //populam headerul raportului
        ReportDto report = new ReportDto(transactionActor);

        //populam lista cu tipurile tranzactiei
        List<TransactionTypeDto> dbTransType = transactionRepository.getAggTransactionsByUser(cnp );

        //pentru fiecare tip de tranzactie popula lista detaliilor
        for (TransactionTypeDto t : dbTransType){
            t.setDetails(transactionRepository.getDetailedTranByTypeAndCnp(t.getType(),transactionActor.getCnp()));
        }

        //verificam daca toate tipurile de tranzactie sunt in lista
        for (TypesEnum t : TypesEnum.class.getEnumConstants()){

            if (!containsType(dbTransType, t.toString())){
                dbTransType.add(new TransactionTypeDto(t.toString()));
            }
        }

        //sortam lista tipurilor de tranzactie
        dbTransType.sort(Comparator.comparing( a -> a.getType()));
        report.setTransactions(dbTransType);
        return report;

    }

    //verifica daca un anumit tip de tranzactie este in lista
    private boolean containsType(final List<TransactionTypeDto> list, final String type){
        return list.stream().filter(o -> o.getType().equals(type)).findFirst().isPresent();
    }

}
