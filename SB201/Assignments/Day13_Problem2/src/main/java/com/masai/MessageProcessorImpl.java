package com.masai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessorImpl implements MessageProcessor {

	@Autowired
	private MessageService messageService;

	@Override
	public void processMessage(String message) {
		messageService.sendMessage(message);
	}

}
