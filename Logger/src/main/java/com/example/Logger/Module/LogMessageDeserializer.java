package com.example.Logger.Module;

import com.example.Logger.Module.LogMessage;
import com.google.gson.Gson;
import org.apache.kafka.common.serialization.Deserializer;

public class LogMessageDeserializer implements Deserializer<LogMessage> {

    private final Gson gson = new Gson();

    @Override
    public LogMessage deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }

        String jsonString = new String(data);
        return gson.fromJson(jsonString, LogMessage.class);
    }
}