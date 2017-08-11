package com.wisn.core.factory;

import com.wisn.core.Message;

import java.util.Vector;
/**
 * 
 * @author Wisn
 * 2016年9月30日   上午9:23:49
 *
 */
public class MessageQueueFactory {
	private Vector<Message> queue = null;
	private static MessageQueueFactory messageQueue = null;
	public  static  int  MessageCount=0;
	public static MessageQueueFactory getInstance() {
		if (messageQueue == null) {
			synchronized (MessageQueueFactory.class) {
				if (messageQueue == null) {
					messageQueue = new MessageQueueFactory();
				}
				return messageQueue;
			}
		}
		return messageQueue;
	}
	private MessageQueueFactory(){}
	public MessageQueueFactory init() {
		if (queue == null) {
			synchronized (MessageQueueFactory.class) {
				if (queue == null) {
					queue = new Vector<>();
				}
			}
		}
		return messageQueue;
	}

	public synchronized void MessageQueue(Message message) {
		queue.addElement(message);
		MessageCount++;
	}

	public synchronized Message pollMessage() {
		try {
			if (queue.size() == 0)
				return null;
			Message message = queue.firstElement();
			queue.removeElementAt(0);
			MessageCount--;
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public  Vector<Message>  getAll(){
		return queue;
	}
}
