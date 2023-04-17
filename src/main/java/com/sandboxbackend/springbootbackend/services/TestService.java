package com.sandboxbackend.springbootbackend.services;

import com.sandboxbackend.springbootbackend.baseclasses.Test;
import com.sandboxbackend.springbootbackend.repositories.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class TestService {

    @Autowired
    TestRepository testRepository;

    public Test saveEntry(){
        Test test = new Test();
        testRepository.save(new Test());
        return test;
    }
}
