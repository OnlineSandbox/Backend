package com.sandboxbackend.springbootbackend.services;

import com.sandboxbackend.springbootbackend.baseclasses.Counter;
import com.sandboxbackend.springbootbackend.repositories.CounterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class CounterService {

    @Autowired
    CounterRepository counterRepository;

    public Counter increaseCounter(){
        Counter counter = counterRepository.findFirstByOrderById();
        if (counter != null) {
            counter.setCounterValue(counter.getCounterValue() + 1);
        } else {
            counter = new Counter();
            counter.setCounterValue(1);
        }
        return counterRepository.save(counter);
    }
}
