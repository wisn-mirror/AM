package com.wisn.core;

import com.wisn.bean.SessionClient;
import com.wisn.bean.CacheUser;
import com.wisn.code.JsonPars;
import com.wisn.core.factory.MessageQueueFactory;
import com.wisn.core.factory.SessionFactory;

import java.util.Iterator;

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
			Message pollMessage=null;
			try {
				pollMessage= MessageQueueFactory.getInstance().init().pollMessage();
				if(pollMessage==null)
					break;
				CacheUser cacheUser = SessionFactory.getInstance().getUser(pollMessage.getMessageSendToID());
				if (cacheUser != null) {
					synchronized (pollMessage) {
						Iterator<SessionClient> iterator = cacheUser.sessionClientList.iterator();
						while(iterator.hasNext()){
							SessionClient next = iterator.next();
							next.send(JsonPars.toJson(pollMessage));
						}
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
