package com.mingdi.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mingdi.kafka.constants.Constants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {
	@KafkaListener(topics = Constants.TOPIC_TEST)
    public void listener(ConsumerRecord<String, String> record) {
        String value = record.value();
        log.info("[receive]:{}", value);
    }
}
