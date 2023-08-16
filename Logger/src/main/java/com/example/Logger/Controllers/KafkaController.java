package com.example.Logger.Controllers;

import com.example.Logger.Module.LogMessage;
import com.example.Logger.Services.KafkaProducerService;
import com.example.Logger.Services.LogService;
import com.example.Logger.Utilities.Validators;
import org.apache.el.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

@Controller
public class KafkaController {
    @Autowired
    public Validators validators;
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public KafkaController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @KafkaListener(topics = "Logs", groupId = "G1")
    public void consumeLogMessage(LogMessage logMessage) {
        String validation = validators.logMessageValidator(logMessage);
        if(!validation.equals("")){
            System.out.println("invalid message"+ validation);
            return;
        }
        kafkaProducerService.sendMessage( logMessage,0);
        System.out.println("Received LogMessage: " + logMessage.toString());


    }

}
