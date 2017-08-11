package com.wisn.core;

import com.wisn.bean.SessionClient;
import com.wisn.code.JsonPars;
import com.wisn.utils.LogUtils;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

/**
 *
 */
public class MessageEntrance  extends WebSocketServer {
    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        try{
            long identify =Long.parseLong(handshake.getResourceDescriptor());
            if(IDS.getId(identify)){
                SessionFactory.getInstance().addSession(identify,new SessionClient(conn));
            }else{
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtils.e("close session  error:"+e.toString());
                }
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
            conn.close();
        }
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
//        SessionFactory.getInstance().init().removeUser(identify);
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        try{
            if(message!=null&&!"".equals(message)){
                Message operationMessage = JsonPars.fromJson(message, Message.class);
                operationMessage.setContent(message);
                MessageQueueFactory.getInstance().init().MessageQueue(operationMessage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onError(WebSocket conn, Exception ex) {

    }

    @Override
    public void onStart() {

    }
}
