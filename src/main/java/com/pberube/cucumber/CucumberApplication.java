package com.pberube.cucumber;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class CucumberApplication {

    public static void main(String[] args) {
        SpringApplication.run(CucumberApplication.class, args);
    }

}
