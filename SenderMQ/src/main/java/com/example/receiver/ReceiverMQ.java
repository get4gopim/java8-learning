package com.example.receiver;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class ReceiverMQ {

	private final static Logger LOGGER = Logger.getLogger(ReceiverMQ.class);
	
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] args) {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
			
			Consumer callback = new DefaultConsumer(channel) {
				  @Override
				  public void handleDelivery(String consumerTag, Envelope envelope,
				                             AMQP.BasicProperties properties, byte[] body)
				      throws IOException {
				    String message = new String(body, "UTF-8");
				    System.out.println(" [x] Received '" + message + "'");
				  }
				};
			
			channel.basicConsume(QUEUE_NAME, true, callback);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
