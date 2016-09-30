package com.wisn.core;

import javax.websocket.Session;
/**
 * 
 * @author Wisn
 * 2016年9月30日   上午9:23:45
 *
 */
public class MessageHandingThread extends Thread {
	public boolean isRuning = true;
	private  OnHandleMessageCallBack onHandleMessageCallBack;
	
	public void setOnHandleMessageCallBack(
			OnHandleMessageCallBack onHandleMessageCallBack) {
		this.onHandleMessageCallBack = onHandleMessageCallBack;
	}

	@Override
	public void run() {
		super.run();
		while (isRuning) {
			OperationMessage pollMessage=null;
			try {
				pollMessage= MessageQueue.getInstance().init().pollMessage();
				if(pollMessage==null)
					break;
				Session session = SessionFactory.getInstance().init()
						.getSession(pollMessage.getMessageSendToID());
				if (session != null) {
					synchronized (pollMessage) {
						session.getAsyncRemote().sendText(
								pollMessage.getMessageContext());
						//handle  message  success
						if(onHandleMessageCallBack!=null){
							onHandleMessageCallBack.handMessageSuccess(pollMessage);
						}
					}
				}else{
					//no  online
					if(onHandleMessageCallBack!=null){
						onHandleMessageCallBack.handMessageStore(pollMessage);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				//handle message  error
				if(onHandleMessageCallBack!=null){
					onHandleMessageCallBack.handMessageError(pollMessage);
				}
			}
		}
	}

}
