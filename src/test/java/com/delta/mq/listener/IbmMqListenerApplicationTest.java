package com.delta.mq.listener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IbmMqListenerApplicationTest {

	@Autowired
	private JmsTemplate queueTemplate;

	private String queue = "DEV.QUEUE.1";

	@Test
	public void sendMessageToQueue() {

		queueTemplate.convertAndSend(queue, "hello world to MQ");
	}

	@Test
	public void receiveMessageFromQueue() {

		queueTemplate.receiveAndConvert(queue);
	}

	@Test
	public void sendMessageToQueueWithSelector() {

		queueTemplate.convertAndSend(queue, "hello world", (MessagePostProcessor) (message) -> {
			{
				message.setStringProperty("name", "test");
				return message;
			}
		});
	}

	@Test
	public void receiveMessageFromQueueWithSelector() {

		queueTemplate.receiveSelected(queue, "name='tony'");
	}


}
