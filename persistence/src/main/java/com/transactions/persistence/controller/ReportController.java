package com.transactions.persistence.controller;

import com.transactions.persistence.model.projection.ReportDto;
import com.transactions.persistence.service.DataPersistenceSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ReportController {

    @Autowired
    DataPersistenceSerivce dataPersistenceSerivce;

    @GetMapping({"getReport/{cnp}", "getReport/"})
    public ReportDto getReport(@PathVariable(value = "cnp") String cnp){

        return dataPersistenceSerivce.getTransactionReport(cnp);
    }
}
