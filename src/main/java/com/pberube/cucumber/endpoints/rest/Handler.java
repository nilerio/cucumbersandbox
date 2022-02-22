package com.pberube.cucumber.endpoints.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
@RequestMapping("reat-api")
public class Handler {

    @GetMapping("hello/{name}")
    public String helloWorld(@PathVariable String name){
        return MessageFormat.format("Hello {0}", name);
    }

}
