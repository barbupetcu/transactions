package com.transactions.persistence.service;

import com.transactions.persistence.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DataPersistenceSerivce {

    @Autowired
    TransactionRepository transactionRepository;



}
