package com.mingdi.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.mingdi.kafka.constants.Constants;

@Service
public class ProducerService {
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send(Constants.TOPIC_TEST, message);
    }

    public void sendMessage(String key, String message) {
        kafkaTemplate.send(Constants.TOPIC_TEST, key, message);
    }
	
}
