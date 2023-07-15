package com.masai;

import org.springframework.stereotype.Component;

@Component
public class TwitterService implements MessageService {

	@Override
	public void sendMessage(String message) {
		System.out.println("Twitter " + message);
	}

}
