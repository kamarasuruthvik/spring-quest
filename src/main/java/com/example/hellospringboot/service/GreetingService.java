package com.example.hellospringboot.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getString(){
        return "Hello from the GreetingService!";
    }

}
