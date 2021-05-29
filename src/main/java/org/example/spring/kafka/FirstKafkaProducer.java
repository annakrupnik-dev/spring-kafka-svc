package org.example.spring.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.Closeable;
import java.io.IOException;
import java.util.Properties;

public class FirstKafkaProducer implements Closeable {

    String bootstrapServer = "localhost:9092";
    String keySerializer = StringSerializer.class.getName();
    String valueSerializer = StringSerializer.class.getName();
    String producerId = "simpleProducer";
    int retries = 2;
    String topicName;
    Properties properties = new Properties();
    Producer producer;

    public FirstKafkaProducer(String topicName) {
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,keySerializer);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,valueSerializer);
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, producerId);
        properties.put(ProducerConfig.RETRIES_CONFIG,retries);
        this.topicName = topicName;
        producer = new KafkaProducer(properties);
    }

    private Producer getProducer(){
        return producer;
    }

    public void send (String key, String message) {
        producer.send( new ProducerRecord(topicName,key,message));
    }

    @Override
    public void close() throws IOException {
        producer.close();
    }
}