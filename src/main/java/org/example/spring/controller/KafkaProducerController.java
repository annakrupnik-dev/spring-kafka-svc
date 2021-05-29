package org.example.spring.controller;

import org.example.spring.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController
{
    private final KafkaProducerService producerService;

    @Autowired
    public KafkaProducerController(KafkaProducerService producerService)
    {
        this.producerService = producerService;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) throws InterruptedException {

        this.producerService.sendMessage("START");
        for (int i=0; i<10; i++) {
            this.producerService.sendMessage(message + "  " + Integer.toString(i));
            TimeUnit.SECONDS.sleep(5);
        }
        this.producerService.sendMessage("FINISH");
    }
}
