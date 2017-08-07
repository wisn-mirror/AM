package com.wisn.servlet.ws;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashSet;
import java.util.Set;

 
@ServerEndpoint(value = "/websocket/{user}")
public class ChatServerEndpoint {

	private static Set<Session> sessions = new HashSet<Session>();
	private Session session;

	@OnOpen
	public void open(Session session, @PathParam(value = "user") String user) {
		System.out.println("用户："+user);
		this.session = session;
		sessions.add(this.session);

		sendToAll(session.getRequestURI() + " 进入  ！");

		System.out.println(session.getRequestURI() + " 进入  ！");
	}

	@OnClose
	public void close() {

		sessions.remove(session);

		sendToAll(session.getRequestURI() + " 离开  ！");

		System.out.println(session.getRequestURI() + " 离开  ！");
	}

	@OnMessage
	public void message(String message) {

		sendToAll("[" + session.getRequestURI() + "]" + message);

		System.out.println("[" + session.getRequestURI() + "]" + message);
	}

	// 发送给所有的聊天者
	private void sendToAll(String text) {

		for (Session client : sessions) {
			synchronized (client) {
				client.getAsyncRemote().sendText(text);
			}
		}
	}

}
