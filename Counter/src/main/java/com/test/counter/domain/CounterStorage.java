package com.test.counter.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CounterStorage {
    private ConcurrentHashMap<String, Integer> counterStorage;

    public CounterStorage() {
        counterStorage = new ConcurrentHashMap<>();
    }

    public void putCounter(String name, int value) {
        counterStorage.put(name, value);
    }

    public void incrementValue(String name) {
        if (counterStorage.get(name) == null) {
            System.out.println("Счётчик с указанным именем не существует!");
        } else {
            counterStorage.put(name, counterStorage.get(name) + 1);
        }
    }

    public Integer getCounterValue(String name) {
        Integer integer = null;
        if (counterStorage.get(name) == null) {
            System.out.println("Счётчик с указанным именем не существует!");
        } else {
            integer = counterStorage.get(name);
        }
        return integer;
    }

    public void deleteCounter(String name) {
        if (counterStorage.get(name) == null) {
            System.out.println("Счётчик с указанным именем не существует!");
        } else {
            counterStorage.remove(name);
        }
    }

    public int getSumValues() {
        int sum = 0;
        for (HashMap.Entry<String, Integer> values : counterStorage.entrySet()) {
            sum += values.getValue();
        }
        return sum;
    }

    public List getCounterNames() {
        List counterNames = new ArrayList();
        for (HashMap.Entry<String, Integer> names : counterStorage.entrySet()) {
            counterNames.add(names.getKey());
        }
        return counterNames;
    }
}


