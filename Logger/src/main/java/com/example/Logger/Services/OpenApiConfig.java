package com.example.Logger.Services;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                description = "This API serves to accept log data from clients, process it, and dispatch it to the corresponding Kafka topic for further handling.",
                title = "Log Processing API",
                version = "2.0"
        )
)
public class OpenApiConfig {
}
