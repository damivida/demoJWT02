package com.example.demoJWT02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * class for exposing a GET REST API-
 */
@RestController
public class HelloWorldController {

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }
}
