package org.example.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.example.spring.utils.AppConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafKaConsumerService
{

    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void consume(String message)
    {
        log.info(String.format("Message recieved -> %s", message));
    }
}
