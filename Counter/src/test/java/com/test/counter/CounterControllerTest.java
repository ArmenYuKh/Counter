package com.test.counter;

import com.test.counter.domain.CounterStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CounterControllerTest {

    @Test
    public void testCounterStorageSumMethod(){
        CounterStorage counterStorage = new CounterStorage();
        counterStorage.putCounter("name1", 1);
        counterStorage.putCounter("name2", 2);
        counterStorage.putCounter("name3", 3);
        assertThat(counterStorage.getSumValues()).isEqualTo(6);
        System.out.println("Тест пройдёен успешно! Полученная сумма верна.");
    }

    @Test
    public void testCounterStorageNameMethod(){
        CounterStorage counterStorage = new CounterStorage();
        counterStorage.putCounter("name1", 1);
        counterStorage.putCounter("name2", 2);
        counterStorage.putCounter("name3", 3);
        assertThat(counterStorage.getCounterNames().size()).isEqualTo(3);
        assertThat(counterStorage.getCounterNames().contains("name1")).isEqualTo(true);
        assertThat(counterStorage.getCounterNames().contains("name2")).isEqualTo(true);
        assertThat(counterStorage.getCounterNames().contains("name3")).isEqualTo(true);
        System.out.println("Тест пройдёен успешно! Получен верный список счётчиков.");
    }
}
