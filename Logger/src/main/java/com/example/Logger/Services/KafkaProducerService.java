package com.example.Logger.Services;

import com.example.Logger.Module.LogMessage;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
//hello
@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, LogMessage> kafkaTemplate;
    private static List<LogMessage.Sources> logsources = new ArrayList<>(Arrays.asList(
            LogMessage.Sources.SOURCE_1,
            LogMessage.Sources.SOURCE_2,
            LogMessage.Sources.SOURCE_3
    ));

    public static Iterator<LogMessage.Sources> logSourcesiterator = logsources.iterator();




    @Autowired
    public KafkaProducerService(KafkaTemplate<String, LogMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(LogMessage message, int partition) {

        if (!logSourcesiterator.hasNext()) {
            // Reset the iterator to point to the first element
            logSourcesiterator = logsources.iterator();
        }
        LogMessage.Sources source = logSourcesiterator.next();
        String topicName = source.toString();
        Message<LogMessage> mess = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .setHeader(KafkaHeaders.PARTITION, partition)
                .build();
        kafkaTemplate.send(mess);

    }
//    public void sendMessage(String topicName,LogMessage message, int partition) {
//
//        Message<LogMessage> mess = MessageBuilder
//                .withPayload(message)
//                .setHeader(KafkaHeaders.TOPIC, topicName)
//                .setHeader(KafkaHeaders.PARTITION, partition)
//                .build();
//        kafkaTemplate.send(mess);
//
//    }



}
