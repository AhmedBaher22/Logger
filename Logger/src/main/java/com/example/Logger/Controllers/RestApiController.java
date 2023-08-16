package com.example.Logger.Controllers;

import com.example.Logger.Module.LogMessage;
import com.example.Logger.Services.KafkaProducerService;
import com.example.Logger.Services.LogService;
import com.example.Logger.Utilities.Validators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.Logger.Services.KafkaProducerService.logSourcesiterator;


@RequestMapping("/log")
@RestController
public class RestApiController {
    @Autowired
    public Validators validators;
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public RestApiController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }




@PostMapping("/rest-log")
public String RestLogMessage(@RequestBody LogMessage logMessage){
    String validation = validators.logMessageValidator(logMessage);
    if(!validation.equals("")){
        return "Invalid log message::" + validation;
    }

    kafkaProducerService.sendMessage( logMessage,0);
    return  "message recieved successfully";

}

}
