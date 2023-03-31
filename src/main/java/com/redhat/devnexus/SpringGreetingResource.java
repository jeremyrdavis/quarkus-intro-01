package com.redhat.devnexus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/springgreeting")
public class SpringGreetingResource {

    @GetMapping
    public List<Greeting> allGreeting() {
        return Greeting.listAll();
    }

    
}
