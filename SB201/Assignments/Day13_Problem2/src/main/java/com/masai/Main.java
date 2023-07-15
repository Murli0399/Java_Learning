package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
		MessageProcessor messageProcessor = ctx.getBean(MessageProcessorImpl.class);
		messageProcessor.processMessage("Murli");
	}

	@Bean
	public MessageService twitterService() {
		return new SMSService();
	}

	@Bean
	public MessageProcessor messageProcessor() {
		return new MessageProcessorImpl();
	}
}
