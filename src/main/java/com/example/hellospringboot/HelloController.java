package com.example.hellospringboot;
import com.example.hellospringboot.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final GreetingService greetingService;

    @Autowired
    public HelloController(GreetingService greetingService){
        this.greetingService = greetingService;
    }
    @GetMapping("/greet")
    public String hello(){
        return greetingService.getString();
    }
}
