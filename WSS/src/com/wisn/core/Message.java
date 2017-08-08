package com.wisn.core;

/**
  * 
  * @author Wisn
  * 2016年9月30日   上午9:23:05
  *
  */
public class Message {
	/**
	 * 需要发送给用户的id
	 */
	private long messageSendToID;
	
	/**
	 * 发送者id 系统发送默认为0
	 */
	private long messageFromID=0;

	private  int messageType;
	
	/**
	 * send Time
	 */
	private  long  sendTime;

	/**
	 * 消息内容
	 */
	private String   content;
	public Message() {
		super();
	}

	public Message(long messageSendToID, long messageFromID, int messageType, long sendTime, String content) {
		this.messageSendToID = messageSendToID;
		this.messageFromID = messageFromID;
		this.messageType = messageType;
		this.sendTime = sendTime;
		this.content = content;
	}

	public long getMessageSendToID() {
		return messageSendToID;
	}

	public void setMessageSendToID(long messageSendToID) {
		this.messageSendToID = messageSendToID;
	}

	public long getMessageFromID() {
		return messageFromID;
	}

	public void setMessageFromID(long messageFromID) {
		this.messageFromID = messageFromID;
	}

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public long getSendTime() {
		return sendTime;
	}

	public void setSendTime(long sendTime) {
		this.sendTime = sendTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
