package com.mingdi.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mingdi.kafka.service.ProducerService;

@RestController("/message")
public class MessageReceiver {

	@Autowired
	ProducerService producer;
	
	@GetMapping("/")
	public String addMessage(@RequestParam String message) {
		producer.sendMessage(message);
		return "success";
	}
}
