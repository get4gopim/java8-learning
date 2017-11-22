package com.example.sender;

import org.apache.log4j.Logger;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SenderMQ {
	
	private final static Logger LOGGER = Logger.getLogger(SenderMQ.class);

	private final static String QUEUE_NAME = "hello";

	public static void main(String[] args) {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();

			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "Hello World!";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			LOGGER.info(" [x] Sent '" + message + "'");

			channel.close();
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
