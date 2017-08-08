package com.wisn.bean;

import org.java_websocket.WebSocket;

import javax.websocket.Session;

public class SessionClient {
    private Session session;
    private WebSocket webSocket;
    public SessionClient(){

    }

    public SessionClient(Session session) {
        this.session = session;
    }

    public SessionClient(WebSocket webSocket) {
        this.webSocket = webSocket;
    }

    public SessionClient(Session session, WebSocket webSocket) {
        this.session = session;
        this.webSocket = webSocket;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public WebSocket getWebSocket() {
        return webSocket;
    }

    public void setWebSocket(WebSocket webSocket) {
        this.webSocket = webSocket;
    }

    public void send(String msg){
        if(this.webSocket!=null){
            this.webSocket.send(msg);
        }
        if(this.session!=null){
            this.session.getAsyncRemote().sendText(msg);
        }
    }
}
