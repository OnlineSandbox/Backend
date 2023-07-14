package com.sandboxbackend.springbootbackend.controller;

import com.sandboxbackend.springbootbackend.baseclasses.Counter;
import com.sandboxbackend.springbootbackend.services.CounterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class TestController {

    @Autowired
    CounterService testService;

    @PostMapping("/counter")
    @ResponseStatus(HttpStatus.CREATED)
    public Counter increaseCounter() {
        return testService.increaseCounter();
    }
}
