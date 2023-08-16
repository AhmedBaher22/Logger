package com.example.Logger.Utilities;

import com.example.Logger.Module.LogMessage;
import org.springframework.stereotype.Service;

@Service
public class Validators {

    public String logMessageValidator(LogMessage logMessage){
        if(logMessage.getMessage() == null || logMessage.getMessage().equals("")){
            return "parameter: message is missed" ;
        } else if (logMessage.getTimestamp() == null || logMessage.getTimestamp().equals("")) {
            return  "parameter: timestamp is missed";
        } else if (logMessage.getCorrelationId() == null || logMessage.getCorrelationId().equals("")) {
            return "parameter: correlationId is missed";
        } else if (logMessage.getSource() == null || logMessage.getSource().toString().equals("")) {
            return "parameter: source is missed";
        } else if (logMessage.getDestination() == null || logMessage.getDestination().equals("")) {
            return "parameter: destination is missed";
        } else if (logMessage.getLogLevel() == null ) {
            return "parameter:log-level is missed";
        }else if (logMessage.getUserId() == null || logMessage.getUserId().equals("")){
            return "parameter:userId is missed";
        }
        else{
            return "";
        }


    }



}
