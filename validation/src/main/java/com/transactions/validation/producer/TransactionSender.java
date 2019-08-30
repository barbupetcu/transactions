package com.transactions.validation.producer;

import com.transactions.validation.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class TransactionSender {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionSender.class);

    @Autowired
    private KafkaTemplate<String, Transaction> kafkaTemplate;

    @Value("${app.topic.transactions}")
    private String topic;

    /*
    *Adaugare tranzactie in coada de mesaje Kafka
    *
     */
    public void addToQueue(Transaction transaction){
        LOG.info("sending data='{}' to topic='{}'", transaction, topic);

        Message<Transaction> message = MessageBuilder
                .withPayload(transaction)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        kafkaTemplate.send(message);
    }


}
