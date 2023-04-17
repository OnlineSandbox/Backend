package com.sandboxbackend.springbootbackend.controller;

import com.sandboxbackend.springbootbackend.baseclasses.Test;
import com.sandboxbackend.springbootbackend.services.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.CREATED)
    public Test saveOverworldGameResult() {
        return testService.saveEntry();
    }
}
