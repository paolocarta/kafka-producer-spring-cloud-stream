package me.paolocarta.kafka.producer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class ProducerScheduler {

    @Resource
    private ProducerService producerService;

    private long messageNumber;

    @Scheduled(fixedRate = 100, initialDelay = 5000)
    public void sendTimeMessage(){

        messageNumber++;

        producerService.send(messageNumber);
    }
}
