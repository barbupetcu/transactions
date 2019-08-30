package com.transactions.validation.controller;

import com.transactions.validation.model.Transaction;
import com.transactions.validation.producer.TransactionSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ValidationController {

    @Autowired
    TransactionSender transactionSender;

    //Validarea campurilor se face cu ajutorul adnotarilor de pe fiecare atribut in parte
    @PostMapping("createTransaction")
    public ResponseEntity<Map<String, Object>> createTransaction(@Valid @RequestBody Transaction transaction){

        //Daca datele tranzactiei sunt validate atunci aceastea sunt trimise in coada de mesaje Kafka
        transactionSender.addToQueue(transaction);

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("message", "Solicitarea a fost inregistrata");

        return ResponseEntity.ok(body);
    }

}
