package org.example.spring.service.producer;

import lombok.extern.slf4j.Slf4j;
import org.example.spring.utils.AppConstants;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
public final class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String message) {
        log.info(String.format("$$$$ => Producing message: %s", message));
        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message=[ {} ] due to : {}", message, ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.warn("Sent message=[ {} ] with offset=[ {} ]", message, result.getRecordMetadata().offset());
            }
        });
    }
}