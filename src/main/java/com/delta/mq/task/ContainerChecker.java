package com.delta.mq.task;

/**
 * Ashish Mishra  
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class ContainerChecker {
	
	@Autowired
	SimpleMessageListenerContainer queueContainer;
	
	public void reportContainerStatus() throws Exception {
		if (!queueContainer.isActive() )
			throw new Exception("STATUS ERROR");
	}

}