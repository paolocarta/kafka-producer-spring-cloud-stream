package me.paolocarta.kafka.producer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class ProducerService {

    @Resource(name = "output")
    private MessageChannel messageChannel;

//    @Publisher(channel = Source.OUTPUT)
//    @SendTo(Source.OUTPUT)
    public void send(long messageNumber) {

        long timestamp = System.currentTimeMillis();
        log.debug("Sending message with id: {} ", messageNumber);

        messageChannel.send(MessageBuilder.createMessage(new MessageDto(messageNumber, timestamp), new MessageHeaders(null)));

    }
}
