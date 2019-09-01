package com.transactions.persistence.kafka.consumer;

import com.transactions.persistence.model.Transaction;
import com.transactions.persistence.service.DataPersistenceSerivce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class TransactionListener {
    private static final Logger LOG = LoggerFactory.getLogger(TransactionListener.class);

    @Autowired
    DataPersistenceSerivce dataPersistenceSerivce;

    /*
    * Fiecare tranzactie disponibila in coada de mesaje Kafka este preluata de consumer apoi trimisa serviciului de persistenta
     */
    @KafkaListener(topics = "${app.topic.transactions}")
    public void receive(@Payload Transaction transaction, @Headers MessageHeaders headers) {

        try{
            LOG.info("received data='{}'", transaction);
            dataPersistenceSerivce.saveTransaction(transaction);
        }
        catch (Exception ex){
            //ToDo in cazul in care apare o eroare la scrierea in baza de date
            // informatiile pot fi scrise intr-un alt topic kafka
            // (eventual adaugam si metadate in care sa descriem eroarea)
            LOG.error("error persisting data = {}", ex);
        }


    }

}
