package com.fisc.gestiondeclaration.web.rest;

import com.fisc.gestiondeclaration.service.GestiondeclarationKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gestiondeclaration-kafka")
public class GestiondeclarationKafkaResource {

    private final Logger log = LoggerFactory.getLogger(GestiondeclarationKafkaResource.class);

    private GestiondeclarationKafkaProducer kafkaProducer;

    public GestiondeclarationKafkaResource(GestiondeclarationKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
