package com.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

//    @KafkaListener(topics = "my-topic", groupId = "my-new-group")
//    public void listen1(String message){
//        System.out.println("Received message 1: " + message);
//    }
//
//    @KafkaListener(topics = "my-topic", groupId = "my-new-group-1")
//    public void listen2(String message){
//        System.out.println("Received message 2: " + message);
//    }

    @KafkaListener(topics = "my-topic", groupId = "my-new-group-rider")
    public void listen2(RiderLocation riderLocation){
        System.out.println("Received location: " + riderLocation.getRiderId() + " : " +
                riderLocation.getLatitude() + " : " + riderLocation.getLongitude());
    }
}
