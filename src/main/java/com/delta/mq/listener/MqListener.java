package com.delta.mq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ashish Mishra  
 */
public class MqListener implements MessageListener {
	
	private static final Logger LOG = LoggerFactory.getLogger(MqListener.class);

	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				LOG.info("Received Message is {}",((TextMessage) message).getText());
			} catch (JMSException ex) {
				throw new RuntimeException(ex);
			}
		} else {
			throw new IllegalArgumentException("Message type must be a TextMessage");
		}
	}
}
