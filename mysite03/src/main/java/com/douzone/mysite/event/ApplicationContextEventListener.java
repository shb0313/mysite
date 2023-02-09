package com.douzone.mysite.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

public class ApplicationContextEventListener {

	@Autowired
	private ApplicationContext applicationContext;
	
	@EventListener({ContextRefreshedEvent.class})
	public void handleContextRefreshedEvent() {
		System.out.println((Object)applicationContext.getClass());
		System.out.println("--- Context Refresh Event Received --- : " + applicationContext);
		
	}
	
}
