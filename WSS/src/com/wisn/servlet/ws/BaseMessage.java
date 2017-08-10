package com.wisn.servlet.ws;

import com.wisn.bean.SessionClient;
import com.wisn.code.JsonPars;
import com.wisn.core.IDS;
import com.wisn.core.MessageQueue;
import com.wisn.core.Message;
import com.wisn.core.SessionFactory;
import com.wisn.utils.LogUtils;

import javax.websocket.*;
import javax.websocket.CloseReason.CloseCodes;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
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
			SessionFactory.getInstance().init().removeUser(identify);
		}
		LogUtils.d("OnClose"+identify);
	}
	@OnMessage
	public  void onMessage(String message){
		try{
			LogUtils.d("onMessage："+identify+message);
			if(message!=null&&!"".equals(message)){
				Message operationMessage = JsonPars.fromJson(message, Message.class);
				MessageQueue.getInstance().init().MessageQueue(operationMessage);
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}
	@OnOpen
	public  void OnOpen(Session session, @PathParam(value = "identify") long identify){
		LogUtils.d("OnOpen"+identify);
		if(IDS.getId(identify)){
			SessionFactory.getInstance().init().addSession(identify,new SessionClient(session));
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
