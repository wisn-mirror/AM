package com.wisn.core;

import java.util.Vector;
/**
 * 
 * @author Wisn
 * 2016年9月30日   上午9:23:49
 *
 */
public class MessageQueue {
	private Vector<OperationMessage> queue = null;
	private static MessageQueue messageQueue = null;
	public  static  int  MessageCount=0;
	public static MessageQueue getInstance() {
		if (messageQueue == null) {
			synchronized (MessageQueue.class) {
				if (messageQueue == null) {
					messageQueue = new MessageQueue();
				}
				return messageQueue;
			}
		}
		return messageQueue;
	}

	public  MessageQueue init() {
		if (queue == null) {
			synchronized (MessageQueue.class) {
				if (queue == null) {
					queue = new Vector<OperationMessage>();
				}
			}
		}
		return messageQueue;
	}

	public synchronized void MessageQueue(OperationMessage message) {
		queue.addElement(message);
		MessageCount++;
	}

	public synchronized OperationMessage pollMessage() {
		try {
			if (queue.size() == 0)
				return null;
			OperationMessage message = queue.firstElement();
			queue.removeElementAt(0);
			MessageCount--;
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public  Vector<OperationMessage>  getAll(){
		return queue;
	}
}
