package com.demo.producer;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class KafkaProducerStream {

    // Supplier to send riderlocation to a kafka topic.
    // This is a stream that will send riderlocation to a kafka topic.
    @Bean
    public Supplier<RiderLocation> sendRiderLocation(){
        return () -> {
            RiderLocation riderLocation = new RiderLocation("rider123", 28.61, 77.23);
            System.out.println("Sending riderlocation to kafka topic : " + riderLocation.getRiderId());
            return riderLocation;
        };
    }
}

