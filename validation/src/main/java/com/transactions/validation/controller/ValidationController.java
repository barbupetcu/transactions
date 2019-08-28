package com.transactions.validation.controller;

import com.transactions.validation.model.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class ValidationController {

    @PostMapping("createTransaction")
    public ResponseEntity<String> createTransaction(@Valid @RequestBody Transaction transaction){

        //Validarea campurilor se face cu ajutorul adnotarilor de pe fiecare atribut in parte
        //todo de apelat serviciul ce produce mesajul kafka


        return ResponseEntity.ok("Solicitarea a fost inregistrata");
    }

}
