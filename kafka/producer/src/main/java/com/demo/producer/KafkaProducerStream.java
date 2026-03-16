package com.demo.producer;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import java.util.Random;
import java.util.function.Supplier;

@Component
public class KafkaProducerStream {

    // Supplier to send riderlocation to a kafka topic.
    // This is a stream that will send riderlocation to a kafka topic.
    @Bean
    public Supplier<RiderLocation> sendRiderLocation(){
        Random random = new Random();
        return () -> {
            // since kafka uses a hash to determine the partition, we need to make sure that the riderId is distributed evenly.
            // Kafka hashes the key riderId to determine the partition, so we append a random number to the riderId to make sure that the riderId is distributed evenly.
            String riderId = "rider" + random.nextInt(20);
            RiderLocation riderLocation = new RiderLocation(riderId, 28.61, 77.23);
            System.out.println("Sending riderlocation to kafka topic : " + riderLocation.getRiderId());
            return riderLocation;
        };
    }

    // Produce messages for multiple topics, so we added one more supplier which will send status updates to a
    // different topic.
    @Bean
    public Supplier<Message<String>> sendRiderStatus(){
        Random random = new Random();
        return () -> {
            // since kafka uses a hash to determine the partition, we need to make sure that the riderId is distributed evenly.
            // Kafka hashes the key riderId to determine the partition, so we append a random number to the riderId to make sure that the riderId is distributed evenly.
            String riderId = "rider" + random.nextInt(20);
            String status = random.nextBoolean()? "ride started" : "ride completed";
            System.out.println("Sending rider status to kafka topic : " + status);
            return MessageBuilder.withPayload(riderId + " : " + status)
                    .setHeader(KafkaHeaders.KEY, riderId.getBytes())
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_PLAIN)
                    .build();
        };
    }
}

