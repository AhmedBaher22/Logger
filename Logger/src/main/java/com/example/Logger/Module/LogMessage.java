package com.example.Logger.Module;


import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class LogMessage {
    // Timestamp of the log entry
    private String timestamp;



    // Correlation ID associated with the log entry
    private String correlationId;

    // Log level indicating the severity of the log entry (e.g., INFO, WARNING, ERROR)
    private LogLevels logLevel;

    // Source of the log message
    private String source;

    // Destination of the log message
    private String destination;

    // Message content of the log entry
    private String message;
    //message userid
    private String userId;
    // Error code of the log entry
    private String errorCode;

    public enum LogLevels{
        TRACE, DEBUG, INFO, WARN, ERROR, FATAL ;
        @Override
        public String toString() {
            switch (this) {
                case TRACE:
                    return "Trace";
                case DEBUG:
                    return "Debug";
                case INFO:
                    return "Info";
                case WARN:
                    return "Warn";
                case ERROR:
                    return "Error";
                case FATAL:
                    return "Fatal";
                default:
                    return super.toString(); // Fallback to default behavior
            }
        }
    }
    public enum Sources{
        SOURCE_1,SOURCE_2,SOURCE_3;
        @Override
        public String toString() {
            switch (this) {
                case SOURCE_1:
                    return "Source_1";
                case SOURCE_2:
                    return "Source_2";
                case SOURCE_3:
                    return "Source_3";

                default:
                    return super.toString(); // Fallback to default behavior
            }
        }

    }

}
