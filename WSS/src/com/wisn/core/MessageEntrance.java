package com.wisn.core;

import com.wisn.bean.SessionClient;
import com.wisn.code.JsonPars;
import com.wisn.core.factory.MessageQueueFactory;
import com.wisn.core.factory.SessionFactory;
import com.wisn.utils.LogUtils;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 *
 */
public class MessageEntrance  extends WebSocketServer {
    public MessageEntrance( int port ) throws UnknownHostException {
        super( new InetSocketAddress( port ) );
    }

    public MessageEntrance( InetSocketAddress address ) {
        super( address );
    }


    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        LogUtils.d( "onOpen:=getHttpStatusMessage:" + handshake.getResourceDescriptor());
        try{
            String resourceDescriptor = handshake.getResourceDescriptor();
            long identify =Long.parseLong(resourceDescriptor.substring(1,resourceDescriptor.length()));
            if(IDS.getId(identify)){
                LogUtils.d("onOpen");
                SessionFactory.getInstance().addSession(identify,new SessionClient(conn));
            }else{
                LogUtils.e("onOpen:=close session  id is null");
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtils.e("onOpen:=close session  error:"+e.toString());
                }
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
            conn.close();
        }
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        LogUtils.d("onClose:=code:"+code + "reason:" + reason + " remote:" + remote);
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        LogUtils.d("onMessage:=message:" + message);
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
        LogUtils.e( "onError:=Exception:" + ex.getMessage());

    }

    @Override
    public void onStart() {

    }
}
