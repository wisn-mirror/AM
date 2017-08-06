package com.wisn.servlet;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.CloseReason.CloseCodes;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.wisn.code.JsonPars;
import com.wisn.core.IDS;
import com.wisn.core.MessageQueue;
import com.wisn.core.OperationMessage;
import com.wisn.core.SessionFactory;
import com.wisn.utils.LogUtils;
/**
 * 
 * @author Wisn
 * 2016年9月30日   上午9:26:24
 *
 */
@ServerEndpoint(value = "/ProtocolMessage/{identify}")
public class BaseMessage {
	private    long  identify=-1;
	@OnError
	public  void onError(Session session, Throwable throwable){
		LogUtils.d("OnError" );
		
	}
	@OnClose
	public  void OnClose(Session session,CloseReason closeReason){
		if(closeReason.getCloseCode()!=CloseCodes.CANNOT_ACCEPT){
			SessionFactory.getInstance().init().removeSession(identify);			
		}
		LogUtils.d("OnClose"+identify);
	}
	@OnMessage
	public  void onMessage(String message){
		LogUtils.d("onMessage："+identify+message);
		if(message!=null&&!"".equals(message)){
			OperationMessage operationMessage = JsonPars.fromJson(message, OperationMessage.class);
			operationMessage.setMessageContext(message);
			MessageQueue.getInstance().init().MessageQueue(operationMessage);
		}
	}
	@OnOpen
	public  void OnOpen(Session session, @PathParam(value = "identify") long identify){
		LogUtils.d("OnOpen"+identify);
		if(IDS.getId(identify)){
			SessionFactory.getInstance().init().addSession(identify, session);			
		}else{
			try {
				session.close(new  CloseReason(CloseCodes.CANNOT_ACCEPT, "CANNOT_ACCEPT"));
			} catch (IOException e) {
				e.printStackTrace();
				LogUtils.e("close session  error:"+e.toString());
			}
		}
	}
}
