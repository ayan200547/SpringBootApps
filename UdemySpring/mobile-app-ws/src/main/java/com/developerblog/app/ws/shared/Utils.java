package com.developerblog.app.ws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;
@Service
public class Utils {
	public String generateUserId() {
		System.out.println("Inside Utils Class");
		return UUID.randomUUID().toString(); 
	}
}
