package com.test.counter.controllers;

import com.test.counter.dto.CreateCounterRequest;
import com.test.counter.services.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CounterController {
    @Autowired
    private CounterService counterService;

    @PutMapping("/counters/create")
    public ResponseEntity putCounter(@RequestBody CreateCounterRequest createCounterRequest) {
        counterService.createCounter(createCounterRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/counters/increment/{name}")
    public ResponseEntity incrementValue(@PathVariable("name") String name) {
        counterService.incrementValue(name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/counters/get-counter-value/{name}")
    public ResponseEntity getValue(@PathVariable("name") String name) {
        Integer counterValue = counterService.getCounterValue(name);
        return new ResponseEntity(counterValue, HttpStatus.OK);
    }

    @GetMapping("/counters/delete/{name}")
    public ResponseEntity deleteByName(@PathVariable("name") String name) {
        counterService.deleteCounter(name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/counters/sum-counter-values")
    public ResponseEntity sumValues() {
        int sumValue = counterService.getSumValues();
        return new ResponseEntity(sumValue, HttpStatus.OK);
    }

    @GetMapping("/counters/get-counter-names")
    public ResponseEntity getNames() {
        List list = counterService.getCounterNames();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
