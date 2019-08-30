package com.transactions.validation.service;

import com.transactions.validation.model.Transaction;
import com.transactions.validation.producer.TransactionSender;
import com.transactions.validation.utils.TransactionType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Arrays;

import static com.transactions.validation.utils.TransactionType.IBAN_TO_IBAN;
import static com.transactions.validation.utils.TransactionType.IBAN_TO_WALLET;

@Service
public class ValidationService {

    @Autowired
    TransactionSender transactionSender;

    public void createTransaction(Transaction transaction) throws MethodArgumentNotValidException {
//        if (validateTransaction(transaction)){
            transactionSender.addToQueue(transaction);
//        }

    }


//    private boolean validateTransaction (Transaction transaction) throws MethodArgumentNotValidException {
//
//        if (Arrays.asList(IBAN_TO_IBAN.toString(), IBAN_TO_WALLET.toString()).contains(transaction.getType())){
//            if (StringUtils.isNotEmpty(transaction.getPayer().getIban())){
//
//            }
//            else {
//                throw new MethodArgumentNotValidException()
//            }
//        }
//
//
//        return false;
//    }
}
