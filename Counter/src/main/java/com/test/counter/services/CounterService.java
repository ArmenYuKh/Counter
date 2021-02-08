package com.test.counter.services;

import com.test.counter.domain.CounterStorage;
import com.test.counter.dto.CreateCounterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterService {

    @Autowired
    private CounterStorage counterStorage;

    public void createCounter(CreateCounterRequest createCounterRequest){
        counterStorage.putCounter(createCounterRequest.getName(), createCounterRequest.getValue());
    }

    public void incrementValue(String name){
        counterStorage.incrementValue(name);
    }

    public Integer getCounterValue(String name){
        return counterStorage.getCounterValue(name);
    }

    public void deleteCounter(String name){
        counterStorage.deleteCounter(name);
    }

    public int getSumValues(){
        return counterStorage.getSumValues();
    }

    public List getCounterNames(){
        return counterStorage.getCounterNames();
    }
}